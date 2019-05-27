package swiggy;

import java.util.List;

public interface ParkingLot {
	public boolean park(String licensePlateNo, String colour, int entryPointId);
	
	/**
	 * Returns list of licensePlateNos corresponding to the input colour
	 * @param colour
	 * @return
	 */
	public List<String> getRegistrationNumbersForColour(String colour);
	
	/**
	 * Returns the parkingSlotId corresponding to licensePlateNo
	 * @param licensePlateNo
	 * @return
	 */
	public int getSlotForRegistrationNumber(String licensePlateNo);
	
	/**
	 * Returns the list of parking slots for a given colour
	 * @param colour
	 * @return
	 */
	public List<Integer> getParkingSlotsForColour(String colour);
	
	/**
	 * Clear a vehicle from its slot
	 * @param licensePlateNo
	 */
	public void clear(String licensePlateNo);
}
