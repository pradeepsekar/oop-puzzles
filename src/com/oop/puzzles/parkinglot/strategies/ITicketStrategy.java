package com.oop.puzzles.parkinglot.strategies;

import com.oop.puzzles.parkinglot.models.ParkingLot;
import com.oop.puzzles.parkinglot.models.User;

public interface ITicketStrategy<T> {
	
	@SuppressWarnings("hiding")
	<T>T execute(final ParkingLot parkingLot, final User user);

}
