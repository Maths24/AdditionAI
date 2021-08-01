import java.util.ArrayList;

public class Neuron {
	double[] gewicht;
	double schwellwert;
	double bias = 100;
	ArrayList<Neuron> sendToArrayList;
	
	public Neuron(ArrayList<Neuron> sendTo, double[] gewicht) {
		this.sendToArrayList = sendTo;
		
		this.gewicht = gewicht;
	}
	
	//für Neuronen des Input Layers
	public double fireInput(Double input) {
		double sum = 0;
		
		int limit = Math.min(input.intValue(), gewicht.length);
		
		for (int i = 0; i < limit; i++) {
			sum += input * gewicht[i];
		}
		
		sum /= bias;
		
		return sum;
	}
	
	//für Neuronen des Output Layers
	public double fireOutput(ArrayList<Double> input) {
		double sum = 0;
		
		int limit = Math.min(input.size(), gewicht.length);
		for (int i = 0; i < limit; i++) {
			sum += input.get(i) * gewicht[i];
		}
		
		sum *= bias;
		
		return sum;
	}
	
	//Training mithilfe des Delta-Verfahrens (nur Output!)
	public void train(ArrayList<ArrayList<Double>> input, ArrayList<Double> result) {
		double epsilon = 0.2;
		int rounds = 0;
		while (rounds < input.size()) {
			double step = fireOutput(input.get(rounds));
			if (Math.abs(result.get(rounds) - step) < 0.01) {
				System.out.println(step);
				rounds++;
				continue;
			}
			
			for (int i = 0; i < gewicht.length; i++) {
				gewicht[i] = gewicht[i] + epsilon * input.get(rounds).get(i) * (result.get(rounds) - step);
				step = fireOutput(input.get(rounds));
			}
		}
		System.out.println("finished");

	}
	

}
