package pkleczek.bugbrain.model;

import pkleczek.bugbrain.utils.BugMath;

public class Synapse {
	private int decay;
	private Join input;
	private boolean learn;
	private Join output;

	private int weight;

	public int calculateOutput() {
		if (input instanceof Neuron) {
			Neuron neuron = (Neuron) input;

			// TODO : 4 przypadki 'decay'
			int totalDecay = decay * neuron.getIterationsUnchanged();
			int neuronOut = neuron.calculateOutput();
			int unweightedOut;

			if (decay > 0) {
				if (neuronOut < 0) {
					unweightedOut = BugMath.clamp(neuronOut + totalDecay,
							-BugMath.SIGNAL_AMPLITUDE, 0);
				} else {
					unweightedOut = BugMath.clamp(neuronOut - totalDecay, 0,
							BugMath.SIGNAL_AMPLITUDE);
				}
			} else {
				if (neuronOut < 0) {
					unweightedOut = BugMath.clamp(neuronOut + totalDecay,
							-BugMath.SIGNAL_AMPLITUDE, 0);
				} else {
					unweightedOut = BugMath.clamp(neuronOut - totalDecay, 0,
							BugMath.SIGNAL_AMPLITUDE);
				}
			}

			return BugMath.clamp(unweightedOut * weight
					/ BugMath.SIGNAL_AMPLITUDE);
		} else {
			throw new UnsupportedOperationException("not yet implemented");
		}
	}

	public int getDecay() {
		return decay;
	}

	public Join getInput() {
		return input;
	}

	public Join getOutput() {
		return output;
	}

	public int getWeight() {
		return weight;
	}

	public void setDecay(int decay) {
		this.decay = decay;
	}

	public void setInput(Join input) {
		this.input = input;
	}

	public void setOutput(Join output) {
		this.output = output;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
}
