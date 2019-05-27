package swiggy;

import java.util.LinkedList;
import java.util.List;

/**
 * Class to model the parking lot.
 * Not considering other vehicle types, since requirement states only cars
 * @author raj
 *
 */
public class ParkingLotImpl implements ParkingLot {
	private List<ParkingSlot> parkingSlots;
	private List<Vehicle> vehicles;
	// TODO See if this can be modelled as an inner class
	private ParkingSlotAllocator parkingSlotAllocator;
	
	private int numSlots;
	private int numFilledSlots;
	private int numEntries;
	
	ParkingLotImpl(int numSlots, int numEntries) {
		this.numSlots = numSlots;
		this.numEntries = numEntries;
		parkingSlots = new LinkedList<ParkingSlot>();
		for (int i = 0; i < numEntries; i++) {
			// Passing the distance from entry as an argument here. 
			// Currently 1st slot will be at a distance of 1 meters, 2nd slot will be at a distance of 2 meters and so on
			parkingSlots.add(new ParkingSlotImpl(i + 1));
		}
		
		vehicles = new LinkedList<Vehicle>();
		parkingSlotAllocator = new ParkingSlotAllocatorImpl();
		System.out.println("Created parking lot with " + numSlots + " slots and " + numEntries + " entry points");
	}
	
	public boolean park(String licensePlateNo, String colour, int entryPointId) {
		// Caller needs to take care of this case
		if (numFilledSlots == numSlots) {
			System.out.println("No Free slots available");
			return false;
		}
		
		Vehicle v = new Car(licensePlateNo, colour);
		vehicles.add(v);
		ParkingSlot ps = parkingSlotAllocator.allocateNext(parkingSlots, entryPointId);
		v.park(ps);
		ps.park(v);
		numFilledSlots++;
		System.out.println("Allocated slot number " + ps.getParkingSlotId());
		return true;
	}
	
	public List<String> getRegistrationNumbersForColour(String colour) {
		List<String> result = new LinkedList<String>();
		for(ParkingSlot ps : parkingSlots) {
			if (!ps.isEmpty() && ps.getVehicle().getColour().equals(colour))
				result.add(ps.getVehicle().getLicensePlateNo());
		}
		
		return result;
	}
	
	public int getSlotForRegistrationNumber(String licensePlateNo) {
		int result = -1;
		for (Vehicle v : vehicles) {
			if (v.getLicensePlateNo().equals(licensePlateNo))
				result = v.getParkingSlot().getParkingSlotId();
		}
		
		return result;
	}
	
	
	public List<Integer> getParkingSlotsForColour(String colour) {
		List<Integer> result = new LinkedList<Integer>();
		for(ParkingSlot ps : parkingSlots) {
			if (!ps.isEmpty() && ps.getVehicle().getColour().equals(colour))
				result.add(ps.getParkingSlotId());
		}
		
		return result;
	}
	
	public void clear(String licensePlateNo) {
		for (int i = 0; i < vehicles.size(); i++) {
			Vehicle v = vehicles.get(i);
			if (v.getLicensePlateNo().equals(licensePlateNo)) {
				v.getParkingSlot().clear();
				vehicles.remove(i);
				break;
			}
		}
	}
}
