package rd222dv_assign1.ferryTransport;

public class Bicycle extends Vehicle {
	/*
	 * Bicycle 40 kr (passenger included).
	*/
	 
	private final int costPass = 0; // cost for passenger on vehicle
	private final int costVehicle = 40; // cost for entering ferry
	private final int pMax = 1; // max number of passengers
	private final int vSize = 1/5; // takes 1/5 of a car
	
	public Bicycle(){}
	public Bicycle(int p) {
		if (p > pMax)
			System.err.println("The bike can take maximum "+ pMax +" passenger!");
		else {
			setPass(p);
			setPrize(costVehicle + (costPass * p));
			setSize(vSize);
		}
	}	 
}