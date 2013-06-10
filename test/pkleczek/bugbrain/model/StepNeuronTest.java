package pkleczek.bugbrain.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class StepNeuronTest {
	
	@Test
	public void testCalculateOutputNoInputOff() {
		StepNeuron neuron = new StepNeuron();
		neuron.setThreshold(50);
		assertEquals(0, neuron.calculateOutput());
	}

	@Test
	public void testCalculateOutputNoInputOn() {
		StepNeuron neuron = new StepNeuron();
		neuron.setThreshold(0);
		assertEquals(100, neuron.calculateOutput());
	}

	@Test
	public void testCalculateOutputInputOff() {
		StepNeuron neuron = new StepNeuron();
		neuron.setThreshold(50);
		
		Neuron n1 = new StepNeuron();
		n1.setThreshold(0);
		Synapse s1 = new Synapse();
		s1.setInput(n1);
		s1.setWeight(30);
		neuron.getInputs().add(s1);
		
		assertEquals(0, neuron.calculateOutput());
	}
	
	@Test
	public void testCalculateOutputInputOn() {
		StepNeuron neuron = new StepNeuron();
		neuron.setThreshold(50);
		
		Neuron n1 = new StepNeuron();
		n1.setThreshold(0);
		Synapse s1 = new Synapse();
		s1.setInput(n1);
		s1.setWeight(60);
		neuron.getInputs().add(s1);
		
		assertEquals(100, neuron.calculateOutput());
	}
	
	@Test
	public void testCalculateOutputManyInputsOn() {
		StepNeuron neuron = new StepNeuron();
		neuron.setThreshold(50);
		
		Neuron n1 = new StepNeuron();
		n1.setThreshold(0);

		Synapse s1 = new Synapse();
		s1.setInput(n1);
		s1.setWeight(30);
		neuron.getInputs().add(s1);
		
		Synapse s2 = new Synapse();
		s2.setInput(n1);
		s2.setWeight(30);
		neuron.getInputs().add(s2);
		
		assertEquals(100, neuron.calculateOutput());
	}	
}
