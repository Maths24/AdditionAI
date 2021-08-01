import java.util.ArrayList;

public class Main {

	private static Netz netz= new Netz();
	
	static ArrayList<ArrayList<Double>> input = new ArrayList<ArrayList<Double>>();
	static ArrayList<Double> result = new ArrayList<Double>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Double> task = new ArrayList<Double>();
		task.add(113.0);
		task.add(13.0);
		//erzeugeTestdaten(50);
		testdaten();
		Netz.output.get(0).train(input, result);
		

		System.out.println(netz.compute(task));
	}
	
	private static void testdaten() {

		ArrayList<Double> pair1 = new ArrayList<Double>();
		pair1.add(0.03);
		pair1.add(0.04);
		input.add(pair1);
		result.add(7.0);
		
		ArrayList<Double> pair2 = new ArrayList<Double>();
		pair2.add(0.01);
		pair2.add(0.03);
		input.add(pair2);
		result.add(4.0);
		
		ArrayList<Double> pair3 = new ArrayList<Double>();
		pair3.add(0.01);
		pair3.add(0.01);
		input.add(pair3);
		result.add(2.0);
		
		ArrayList<Double> pair4 = new ArrayList<Double>();
		pair4.add(0.02);
		pair4.add(0.03);
		input.add(pair4);
		result.add(5.0);
		
		ArrayList<Double> pair5 = new ArrayList<Double>();
		pair5.add(0.07);
		pair5.add(0.03);
		input.add(pair5);
		result.add(10.0);
		
		ArrayList<Double> pair6 = new ArrayList<Double>();
		pair6.add(0.02);
		pair6.add(0.01);
		input.add(pair6);
		result.add(3.0);
		
		ArrayList<Double> pair7 = new ArrayList<Double>();
		pair7.add(0.04);
		pair7.add(0.02);
		input.add(pair7);
		result.add(6.0);
		
		ArrayList<Double> pair8 = new ArrayList<Double>();
		pair8.add(0.06);
		pair8.add(0.02);
		input.add(pair8);
		result.add(8.0);
		
		ArrayList<Double> pair9 = new ArrayList<Double>();
		pair9.add(0.02);
		pair9.add(0.07);
		input.add(pair9);
		result.add(9.0);
	}
	
	private static void erzeugeTestdaten(int menge) {
		double left = 0;
		double right = 0;
		double result = 0;
		for (int i = 0; i < menge; i++) {
			ArrayList<Double> test = new ArrayList<Double>();

			left = (double) (int) Math.round(Math.random() * 100);
			right =(double) (int) Math.round(Math.random() * 100);
			result = left + right;
			
			test.add(left);
			test.add(right);
			System.out.println(test.get(0));
			System.out.println(test.get(1));
			input.add(test);
			Main.result.add(result);
			test.clear();
		}
		
	}
}
