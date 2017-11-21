package rd222dv_assign1.ferryTransport;

public class Bus extends Vehicle {
	/*
	 * Bus 200 kr + 10 kr/ passenger (maximum 20 passengers).
	*/
	 
	private final int costPass = 10; // cost for passenger on vehicle
	private final int costVehicle = 200; // cost for entering ferry
	private final int pMax = 20; // max number of passengers
	private final int vSize = 4; // size compared to car
	
	public Bus(int p) {
		if (p > pMax)
			System.err.println("The bus can take max: "+ pMax +" passengers!");
		else {
			setPass(p);
			setPrize(costVehicle + (costPass * p));
			setSize(vSize);
		}
	}	 
}