/**
 * 
 */
package com.oop.puzzles.parkinglot.commands;

import com.oop.puzzles.parkinglot.models.ParkingLot;
import com.oop.puzzles.parkinglot.models.Ticket;
import com.oop.puzzles.parkinglot.models.User;

/**
 * @author Pradeep S
 *
 */
public class AllocateParkingLotCommand implements ICommand {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.oop.puzzles.parkinglot.commands.ICommand#execute()
	 */
	@Override
	public Ticket execute(ParkingLot parkinglot, User user) {
		Ticket ticket = null;
		if (parkinglot.getTotalSlotsAvailable() > 0) {
			parkinglot.newVehicleParked(parkinglot.getNearestSlotAvailable(), user.getVehicle());
			ticket = new Ticket(user.getVehicle().getRegistrationNumber(), 
					user.getVehicle().getColor(), parkinglot.getNearestSlotAvailable());
			System.out.println("Allocated slot number: " + ticket.getAllocatedSlotId());
		} else {
			System.out.println("Sorry, parking lot is full");
		}
		return ticket;
	}
}
