package swiggy;

/**
 * Interface for Vehicles. Should this be 'Car' instead of 'Vehicle'?
 * @author raj
 *
 */
public interface Vehicle {
	/**
	 * Park a vehicle in a specific slot
	 * @param parkingSlotId
	 */
	public void park(ParkingSlot ps);	
	
	public String getLicensePlateNo();
	
	public String getColour();
	
	public ParkingSlot getParkingSlot();
}
