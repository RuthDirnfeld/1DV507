package rd222dv_assign1.ferryTransport;

public class FerryMain {

	public static void main(String[] args) {
		FerryLoad ferry = new FerryLoad();
		
		Bicycle bike = new Bicycle(1); // the same vehicle cannot embark twice because I create new Objects everytime?
		Bicycle bike2 = new Bicycle(1);
		ferry.embark(bike);
		ferry.embark(bike2);
		System.out.println("\nEmbarked bikes: ");
		System.out.println(ferry.toString());
		
		Car car = new Car(4);
		ferry.embark(car);
		Car car2 = new Car(3);
		ferry.embark(car2);
		Car car3 = new Car(4);
		ferry.embark(car3);
		System.out.println("\nEmbarked cars: ");
		System.out.println(ferry.toString());
		System.out.println("Possible to embark more vehicles: "+ ferry.hasSpaceFor(car));
		
		Bus bus = new Bus(15);
		ferry.embark(bus);
		Bus bus2 = new Bus(15);
		ferry.embark(bus2);
		System.out.println("\nEmbarked busses: ");
		System.out.println(ferry.toString());
		System.out.println("Possible to embark more vehicles: "+ ferry.hasSpaceFor(bus));
		
		Lorry lorry = new Lorry(1);
		ferry.embark(lorry);
		Lorry lorry2 = new Lorry(1);
		ferry.embark(lorry2);
		System.out.println("\nEmbarked lorries: ");
		System.out.println(ferry.toString());
		System.out.println("Possible to embark more vehicles: "+ ferry.hasSpaceFor(lorry));
		
		System.out.println("\nMoney earned at this ferry: "+ferry.countMoney());
			
		ferry.disembark();
		System.out.println("\nAfter disembarking: \nVehicles on board: "+ferry.countVehicleSpace()+"\nNumber of passengers on board "+ ferry.countPassengers());
		
	}

}
