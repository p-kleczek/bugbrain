package pkleczek.bugbrain.model;

public class StepNeuron extends Neuron {

	@Override
	public int calculateOutput() {
		// Calculate a sum of weighted inputs. If the sum is equal or greater
		// than the threshold then the neuron turns on and the output is 100.

		return (sumInputs() >= getThreshold()) ? 100 : 0;
	}

}
