package pkleczek.bugbrain.model;

import pkleczek.bugbrain.utils.BugMath;

public class NeuronMock extends Neuron {
	@Override
	public int calculateOutput() {
		return BugMath.clamp(sumInputs());
	}

}
