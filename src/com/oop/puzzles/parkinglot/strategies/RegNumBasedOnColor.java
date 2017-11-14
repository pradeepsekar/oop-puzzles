package com.oop.puzzles.parkinglot.strategies;

import com.oop.puzzles.parkinglot.models.ParkingLot;

public class RegNumBasedOnColor implements IFetchDetailsStrategy {

	private ParkingLot parkingLot;

	public RegNumBasedOnColor(ParkingLot parkingLot) {
		this.parkingLot = parkingLot;
	}

	@Override
	public void getDetails(String condition) {
		System.out.println("Printing registration number of cars which are " + condition);
		this.parkingLot.getAllVehicles()
					   .filter(vehicle -> vehicle.getColor().equalsIgnoreCase(condition))
					   .map(v -> v.getRegistrationNumber())
					   .forEach(System.out::println);
	}

}
