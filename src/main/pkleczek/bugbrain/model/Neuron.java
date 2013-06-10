package pkleczek.bugbrain.model;

import java.util.ArrayList;
import java.util.List;
import static java.lang.Math.*;

public abstract class Neuron extends Join {
	private int threshold;
	private List<Synapse> inputs = new ArrayList<>();
	private List<Synapse> outputs = new ArrayList<>();

	protected int sumInputs() {
		int out = 0;

		for (Synapse s : getInputs()) {
			out += s.calculateOutput();
		}

		// Clamp to [-100,100]
		out = (abs(out) > 100) ? (100 * (int) signum(out)) : out;

		return out;
	}

	public int getThreshold() {
		return threshold;
	}

	public void setThreshold(int threshold) {
		this.threshold = threshold;
	}

	public List<Synapse> getInputs() {
		return inputs;
	}

	public void setInputs(List<Synapse> inputs) {
		this.inputs = inputs;
	}

	public List<Synapse> getOutputs() {
		return outputs;
	}

	public void setOutputs(List<Synapse> outputs) {
		this.outputs = outputs;
	}

}
