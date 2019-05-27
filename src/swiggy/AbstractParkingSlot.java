package swiggy;

/**
 * Abstract class for Parking slot. Not having any default implementations currently
 * @author raj
 *
 */
public abstract class AbstractParkingSlot implements ParkingSlot {

	// static variable that is used for auto-incrementing parkingSlotId
	protected static int initializer = 0;
	
	// Id that will be auto incremented
	protected int parkingSlotId;
	
	// EMPTY/OCCUPIED. TODO Make this an enum
	protected String status;
	
	protected int distanceFromEntry;
	
	protected Vehicle vehicle;

	public static int getInitializer() {
		return initializer;
	}

	AbstractParkingSlot(int distanceFromClosestEntry) {
		this.parkingSlotId = initializer++;
		this.status = "EMPTY";
		this.distanceFromEntry = distanceFromClosestEntry;
	}
	
	public static void setInitializer(int initializer) {
		AbstractParkingSlot.initializer = initializer;
	}

	public int getDistanceFromEntry() {
		return distanceFromEntry;
	}

	public void setDistanceFromEntry(int distanceFromEntry) {
		this.distanceFromEntry = distanceFromEntry;
	}

	public int getParkingSlotId() {
		return parkingSlotId;
	}

	public void setParkingSlotId(int parkingSlotId) {
		this.parkingSlotId = parkingSlotId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}		
	
	@Override
	public void park(Vehicle v) {
		this.status = "OCCUPIED";
		this.vehicle = v;
	}

	@Override
	public void clear() {
		this.status = "EMPTY";
		this.vehicle = null;
	}

	@Override
	public boolean isEmpty() {
		return status.equals("EMPTY");
	}	
	
	public Vehicle getVehicle() {
		return this.vehicle;
	}
}
