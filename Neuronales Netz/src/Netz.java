import java.util.ArrayList;

public class Netz {
	ArrayList<Neuron> input = new ArrayList<Neuron>();
	public static ArrayList<Neuron> output = new ArrayList<Neuron>();

	double[] gewichtK = {1.0};
	double[] gewichtJ = {1.0};
	double[] gewichtI = {0.9, 0.875};
	
	public Netz() {
		this.input.add(new Neuron(this.input, gewichtK));
		this.input.add(new Neuron(this.input, gewichtJ));
		
		Netz.output.add(new Neuron(null, gewichtI));
	}
	
	public double compute(ArrayList<Double> inputVektor) {
		ArrayList<Double> inputResult = new ArrayList<Double>();
		double outputResult = 0;

		for (int i = 0; i < this.input.size(); i++) {
			inputResult.add(this.input.get(i).fireInput(inputVektor.get(i)));
		}
		
		
		for (int i = 0; i < Netz.output.size(); i++) {
			outputResult = Netz.output.get(i).fireOutput(inputResult);
		}
		
		return outputResult;
	}

}
