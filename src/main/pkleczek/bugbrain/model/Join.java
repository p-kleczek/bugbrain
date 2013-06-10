package pkleczek.bugbrain.model;

import java.util.List;

public abstract class Join {
	private List<Synapse> inputs;
	
	// outputs are computed from the synapse list
//	private List<Synapse> outputs;

	public List<Synapse> getInputs() {
		return inputs;
	}

	public void setInputs(List<Synapse> inputs) {
		this.inputs = inputs;
	}

	/**
	 * Sums weighted input signals and produces an output according to the
	 * neuron type.
	 * 
	 * @return 100 if the neuron is on, 0 otherwise
	 */
	public abstract int calculateOutput();

}
