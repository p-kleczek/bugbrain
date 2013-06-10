package pkleczek.bugbrain.model;

public class Synapse {
	private Join input;
	private Join output;
	private int weight;
	private double decay;
	private boolean learn;

	public Join getInput() {
		return input;
	}

	public void setInput(Join input) {
		this.input = input;
	}

	public Join getOutput() {
		return output;
	}

	public void setOutput(Join output) {
		this.output = output;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int calculateOutput() {
		if (input instanceof Neuron) {
			Neuron neuron = (Neuron) input;
			return neuron.calculateOutput() * weight / 100;
		} else {
			throw new UnsupportedOperationException("not yet implemented");
		}
	}
}
