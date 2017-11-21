package rd222dv_assign1.ferryTransport;

public class Lorry extends Vehicle {

	/*
	 * Lorry 300 kr + 15 kr/ passenger (maximum 2 passengers).
	 */

	private final int costPass = 15; // cost for passenger on vehicle
	private final int costVehicle = 300; // cost for entering ferry
	private final int pMax = 2; // max number of passengers
	private final int vSize = 8; // size compared to car

	public Lorry(int p) {

		if (p > pMax)
			System.err.println("The lorry can take max: " + pMax + "  passengers!");
		else {
			setPass(p);
			setPrize(costVehicle + (costPass * p));
			setSize(vSize);
		}

	}

}
