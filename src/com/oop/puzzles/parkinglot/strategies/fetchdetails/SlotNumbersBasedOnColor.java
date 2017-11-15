package com.oop.puzzles.parkinglot.strategies.fetchdetails;

import com.oop.puzzles.parkinglot.models.ParkingLot;
import com.oop.puzzles.parkinglot.strategies.IFetchDetailsStrategy;

public class SlotNumbersBasedOnColor implements IFetchDetailsStrategy {

	private ParkingLot parkingLot;

	public SlotNumbersBasedOnColor(ParkingLot parkingLot) {
		this.parkingLot = parkingLot;
	}
	
	@Override
	public void getDetails(final String condition) {
		this.parkingLot.getAllocatedVehicleSlots().stream()
				.filter(slotId -> this.parkingLot.getVehicleInSlot(slotId).getColor().equalsIgnoreCase(condition))
				.forEach(System.out::println);
	}

}
