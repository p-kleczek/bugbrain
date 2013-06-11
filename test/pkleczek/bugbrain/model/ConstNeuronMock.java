package pkleczek.bugbrain.model;

public class ConstNeuronMock extends Neuron {
	static final int OUT_VAL = 50;

	private boolean neg = false;

	@Override
	public int calculateOutput() {
		return OUT_VAL * (neg ? -1 : 1);
	}

	public void setNeg(boolean neg) {
		this.neg = neg;
	}

}