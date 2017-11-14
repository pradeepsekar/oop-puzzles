package com.oop.puzzles.parkinglot.strategies;

import com.oop.puzzles.parkinglot.models.ParkingLot;
import com.oop.puzzles.parkinglot.models.Ticket;
import com.oop.puzzles.parkinglot.models.User;

public interface ITicketStrategy {
	
	Ticket execute(ParkingLot parkingLot, User user);

}
