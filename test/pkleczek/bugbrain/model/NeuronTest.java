package pkleczek.bugbrain.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NeuronTest {
	
	@Test
	public void testNextIteration() {
		Neuron n = new NeuronMock();

		assertEquals(0, n.getIterationsUnchanged());
		n.nextIteration();
		assertEquals(1, n.getIterationsUnchanged());
		
		Synapse s = new Synapse();
		Neuron cn = new ConstNeuronMock();
		s.setInput(cn);
		s.setOutput(n);
		s.setWeight(100);
		s.setDecay(0);
		n.getInputs().add(s);
		
		n.nextIteration();
		assertEquals(0, n.getIterationsUnchanged());
	}

}
