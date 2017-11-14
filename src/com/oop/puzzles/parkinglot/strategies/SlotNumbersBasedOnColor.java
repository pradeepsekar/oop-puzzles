package com.oop.puzzles.parkinglot.strategies;

import com.oop.puzzles.parkinglot.models.ParkingLot;

public class SlotNumbersBasedOnColor implements IFetchDetailsStrategy {

	private ParkingLot parkingLot;

	public SlotNumbersBasedOnColor(ParkingLot parkingLot) {
		this.parkingLot = parkingLot;
	}
	
	@Override
	public void getDetails(String condition) {
		this.parkingLot.getAllocatedVehicleSlots().stream()
				.filter(slotId -> this.parkingLot.getVehicleInSlot(slotId).getColor().equalsIgnoreCase(condition))
				.forEach(System.out::println);
	}

}
