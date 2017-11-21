package rd222dv_assign1.ferryTransport;

public class Vehicle {
	protected int prize = 0; // price to enter
	protected int size = 0; // size of each vehicle
	protected int nPass = 0; // passengers
	
	// Helping methods for classes
	protected void setPrize(int n) { 
		prize = n; }
	protected void setPass(int n) { 
		nPass = n; }
	protected void setSize(int n) { 
		size = n; }
	
	protected int getPass() { 
		return nPass; }
	protected int getPrize() { 
		return prize; }
	protected int getSize() { 
		return size; }

}
