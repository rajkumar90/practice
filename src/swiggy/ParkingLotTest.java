package swiggy;

import org.junit.jupiter.api.Test;

class ParkingLotTest {

	@Test
	void test() {
		// Created parking lot with 6 slots and 3 entry points
		ParkingLotImpl pl = new ParkingLotImpl(6, 3);
		
		// Allocated slot number 0
		pl.park("KA-01-1111", "White", 1);
		
		// Allocated slot number 1
		pl.park("KA-01-2222", "Black", 1);
		
		// Allocated slot number 2
		pl.park("KA-01-3333", "Black", 1);
		
		// KA-01-2222, KA-01-3333
		System.out.println(pl.getRegistrationNumbersForColour("Black"));
		
		// 0
		System.out.println(pl.getSlotForRegistrationNumber("KA-01-1111"));
		
		// -1
		System.out.println(pl.getSlotForRegistrationNumber("KA-01-NOT-FOUND"));
				
		// [1,2]
		System.out.println(pl.getParkingSlotsForColour("Black"));
		
		pl.clear("KA-01-2222");
		// [2], since 1 is cleared
		System.out.println(pl.getParkingSlotsForColour("Black"));
	}

}
