package swiggy;

public class AbstractVehicle implements Vehicle {

	protected String licensePlateNo;
	protected String colour;
	protected ParkingSlot parkedInSlot;
	
	public ParkingSlot getParkedInSlot() {
		return parkedInSlot;
	}

	public void setParkedInSlot(ParkingSlot parkedInSlot) {
		this.parkedInSlot = parkedInSlot;
	}

	public AbstractVehicle(String licensePlateNo, String colour) {
		this.licensePlateNo = licensePlateNo;
		this.colour = colour;
	}
	
	public String getLicensePlateNo() {
		return licensePlateNo;
	}

	public void setLicensePlateNo(String licensePlateNo) {
		this.licensePlateNo = licensePlateNo;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}	
	
	@Override
	public void park(ParkingSlot parkingSlot) {
		this.parkedInSlot = parkingSlot;
	}

	@Override
	public ParkingSlot getParkingSlot() {
		return this.parkedInSlot;
	}
	
	@Override
	public String toString() {
		return this.licensePlateNo;
	}
}
