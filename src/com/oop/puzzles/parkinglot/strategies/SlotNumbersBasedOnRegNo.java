package com.oop.puzzles.parkinglot.strategies;

import java.util.Optional;

import com.oop.puzzles.parkinglot.models.ParkingLot;

public class SlotNumbersBasedOnRegNo implements IFetchDetailsStrategy {

	private ParkingLot parkingLot;

	public SlotNumbersBasedOnRegNo(ParkingLot parkingLot) {
		this.parkingLot = parkingLot;
	}

	@Override
	public void getDetails(String condition) {
		Optional<Integer> slotNumber = this.parkingLot.getAllocatedVehicleSlots().stream()
				.filter(slotId -> this.parkingLot.getVehicleInSlot(slotId).getRegistrationNumber().equalsIgnoreCase(condition))
				.findFirst();
		if(slotNumber.isPresent()) {
			System.out.println(slotNumber.get());
		} else {
			System.out.println("Not found");
		}
	}

}
