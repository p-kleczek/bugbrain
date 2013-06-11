package pkleczek.bugbrain.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class SynapseTest {

	@Test
	public void testCalculateOutputDecayPosOutPos() {
		final int DECAY = 30;
		Neuron n = new ConstNeuronMock();
		
		Synapse s = new Synapse();
		s.setInput(n);
		s.setWeight(100);
		s.setDecay(DECAY);
		
		assertEquals(ConstNeuronMock.OUT_VAL, s.calculateOutput());
		n.nextIteration();
		assertEquals(ConstNeuronMock.OUT_VAL - DECAY, s.calculateOutput());
		n.nextIteration();
		assertEquals(0, s.calculateOutput());
	}

	@Test
	public void testCalculateOutputDecayPosOutNeg() {
		final int DECAY = 30;
		ConstNeuronMock n = new ConstNeuronMock();
		n.setNeg(true);
		n.nextIteration();	// update initial value
		
		Synapse s = new Synapse();
		s.setInput(n);
		s.setWeight(100);
		s.setDecay(DECAY);
		
		assertEquals(-ConstNeuronMock.OUT_VAL, s.calculateOutput());
		n.nextIteration();
		assertEquals(-ConstNeuronMock.OUT_VAL + DECAY, s.calculateOutput());
		n.nextIteration();
		assertEquals(0, s.calculateOutput());
	}	

	@Test
	public void testCalculateOutputDecayNegOutPos() {
		final int DECAY = -30;
		Neuron n = new ConstNeuronMock();
		
		Synapse s = new Synapse();
		s.setInput(n);
		s.setWeight(100);
		s.setDecay(DECAY);
		
		assertEquals(ConstNeuronMock.OUT_VAL, s.calculateOutput());
		n.nextIteration();
		assertEquals(ConstNeuronMock.OUT_VAL - DECAY, s.calculateOutput());
		n.nextIteration();
		assertEquals(100, s.calculateOutput());
	}
	
	@Test
	public void testCalculateOutputDecayNegOutNeg() {
		final int DECAY = -30;
		ConstNeuronMock n = new ConstNeuronMock();
		n.setNeg(true);
		n.nextIteration();	// update initial value
		
		Synapse s = new Synapse();
		s.setInput(n);
		s.setWeight(100);
		s.setDecay(DECAY);
		
		assertEquals(-ConstNeuronMock.OUT_VAL, s.calculateOutput());
		n.nextIteration();
		assertEquals(-ConstNeuronMock.OUT_VAL + DECAY, s.calculateOutput());
		n.nextIteration();
		assertEquals(-100, s.calculateOutput());
	}	

	
}
