package swiggy;

import java.util.List;

/**
 * Allocates a parking slot that is closest to the entry
 * @author raj
 *
 */
public class ParkingSlotAllocatorImpl implements ParkingSlotAllocator {

	@Override
	public ParkingSlot allocateNext(List<ParkingSlot> parkingSlots, int entryPointId) {
//		Comparator<ParkingSlot> byDistance = (a, b) -> a.getDistanceFromEntry() - b.getDistanceFromEntry(); 
//		parkingSlots.sort(byDistance);
		
		// Iterate through the parking slots and find the one with minimum distance
		ParkingSlot psWithMinDistance = null;
		int minDistance = Integer.MAX_VALUE;
		for (int i = 0; i < parkingSlots.size(); i++) {
			ParkingSlot ps = parkingSlots.get(i);
			if (ps.isEmpty() && ps.getDistanceFromEntry() < minDistance) {
				psWithMinDistance = ps;
				minDistance = ps.getDistanceFromEntry();
			}				
		}
		
		return psWithMinDistance;
	}

}
