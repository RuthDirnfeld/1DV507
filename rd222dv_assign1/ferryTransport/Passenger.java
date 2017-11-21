package rd222dv_assign1.ferryTransport;

public class Passenger {
	private int nPass = 0;
	private int nPrize = 0;
	
	// Constructor for how many passengers are allowed on the ferry
	public Passenger(int p) {
		setPass(p);
		setPrize(p);
	}
	
	public void setPass(int p) { nPass = p; }
	public void setPrize(int p) { nPrize = 20 * p; }
	
	public int getPass() { return nPass; }
	public int getPrize() { return nPrize; }
}
