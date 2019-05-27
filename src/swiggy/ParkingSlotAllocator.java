package swiggy;

import java.util.List;

/**
 * Interface for the ParkingSlotAllocator
 * Currently, functionality is to allocate a parkingSlotId 
 * There can be different implementations - closest to entry (specified in requirement), or closest to exit or random
 * @author raj
 *
 */
public interface ParkingSlotAllocator {
	public ParkingSlot allocateNext(List<ParkingSlot> parkingSlots, int entryPointId);
}
