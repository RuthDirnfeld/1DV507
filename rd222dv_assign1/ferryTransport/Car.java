package rd222dv_assign1.ferryTransport;

public class Car extends Vehicle {
	
	/*
	 * Car 100 kr + 15 kr/passenger (maximum 4 passengers).
	 */
	
	private final int costPassenger = 15; // cost for passenger on vehicle
	private final int costVehicle = 100; // cost for entering ferry
	private final int pMax = 4; // max number of passengers
	private final int vSize = 1; // size compared to car
	
	 /* 
	  * Constructor for Car Object, takes passengers
	  */
	public Car(int p) { 
		
		if (p > pMax)
			System.err.println("The car can take max: " + pMax + " passengers!");
		else {
			setPass(p);
			setPrize(costVehicle + (costPassenger * p));
			setSize(vSize);
		}		
	}
	
}