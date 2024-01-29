package casestudy;

public class ConsumptionAttempt {
	
	public static void main(String [] args) {	
			ConsumptionIntensiveLoad cil =  ConsumptionIntensiveLoad.getInstance();
			cil.main(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
	}
}
