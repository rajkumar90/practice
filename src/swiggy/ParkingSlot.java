package swiggy;

/**
 * Interface for parking spot
 * @author raj
 *
 */
public interface ParkingSlot {
	/**
	 * Parks the car
	 */
	public void park(Vehicle v);
	
	/**
	 * Clears/removes a car from a slot and marks it available
	 */
	public void clear();
	
	public boolean isEmpty();
	
	public int getParkingSlotId();
	
	public int getDistanceFromEntry();
	
	public Vehicle getVehicle();
}
