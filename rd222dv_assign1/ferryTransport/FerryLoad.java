package rd222dv_assign1.ferryTransport;

import java.util.ArrayList;
import java.util.Iterator;

public class FerryLoad implements Ferry {

		// Arraylist for all Objects from class Vehicle
		ArrayList<Vehicle> pVehicle = new ArrayList<>();
		
		ArrayList<Passenger> pPass = new ArrayList<>();
		
		@Override
		public int countPassengers() {
			int pSum = 0; // sum of passengers
			
			for (int i = 0; i < pPass.size(); i++) { // Loop over passengers and add to pSum
				pSum += pPass.get(i).getPass();
			}
			
			for (int i = 0; i < pVehicle.size(); i++) { // Loop over vehicles and add to pSum
				pSum += pVehicle.get(i).getPass();
			}
			
			return pSum;
		}

		@Override
		public int countVehicleSpace() {
			
			int sizeSum = 0; // Return sum of how much space the vehicles take
			
			// Loop over vehicles and add size to sizeSum
			for (int i = 0; i < pVehicle.size(); i++) {
				sizeSum += pVehicle.get(i).getSize();
			}
			
			return sizeSum;
		}

		@Override
		public int countMoney() {
			int sum = 0; // total sum
			
			// Loop over vehicles, add prize
			for (int i = 0; i < pVehicle.size(); i++) {
				sum += pVehicle.get(i).getPrize();
			}
			
			for (int i = 0; i < pPass.size(); i++) {
				sum += pPass.get(i).getPrize();
			}
			
			return sum;
		}

		@Override
		public Iterator <Vehicle> iterator() {
			
			return null;
		}

		@Override
		public void embark(Vehicle v) {
			// adding vehicles to ferry
			
			if (hasRoomFor(null) && hasSpaceFor(v)) {
				pVehicle.add(v);
				countMoney();
			}
			else
				System.err.println("No more space for further vehicles");
			
		}

		@Override
		public void embark(Passenger p) {
			// Adds passengers to ferry
			if (hasRoomFor(p)) {
				pPass.add(p);
				countMoney();
			}
			else
				System.err.println("No more space for further passengers");		
		}

		@Override
		public void disembark() {
			// empty vehicle and passengers, save money
			pPass.clear();
			pVehicle.clear();
			
		}

		@Override
		public boolean hasSpaceFor(Vehicle v) {
			// looks at the vehicle space; if smaller than 40
			
			if (v.getSize() + countVehicleSpace() <= 40)
				return true;
			else
				return false;
			
		}

		@Override
		public boolean hasRoomFor(Passenger p) {
			// looks if there is room for all passengers
			
			if (this.countPassengers() + countPassengers() <= 200)
				return true;
			else
				return false;
		}
		public String toString() {
			StringBuffer buf = new StringBuffer();
			buf.append("Number of Vehicles on board: "+countVehicleSpace()+"\nNumber of Passengers on board: "+countPassengers()+
					"\nCash in desk: "+countMoney()+"\nPossible to embark more people: "+ hasRoomFor(null));
			
			return buf.toString();
		}

	}



