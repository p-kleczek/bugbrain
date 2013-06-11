package pkleczek.bugbrain.model;

import java.util.ArrayList;
import java.util.List;

import pkleczek.bugbrain.utils.BugMath;
import static java.lang.Math.*;

public abstract class Neuron extends Join {
	private int threshold;
	private List<Synapse> inputs = new ArrayList<>();

	private int previousOutputValue = calculateOutput();

	/**
	 * Number of previous iterations in which the output value remained
	 * unchanged.
	 */
	private int iterationsUnchanged;

	protected int sumInputs() {
		int out = 0;

		for (Synapse s : getInputs()) {
			out += s.calculateOutput();
		}

		return BugMath.clamp(out);
	}

	public int getIterationsUnchanged() {
		return iterationsUnchanged;
	}

	public void setIterationsUnchanged(int iterationsUnchanged) {
		this.iterationsUnchanged = iterationsUnchanged;
	}

	/**
	 * Next iteration of the simulation.
	 */
	public void nextIteration() {
		int newOutputValue = calculateOutput();
		if (previousOutputValue == newOutputValue) {
			iterationsUnchanged++;
		} else {
			iterationsUnchanged = 0;
		}
		previousOutputValue = newOutputValue;
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

}
