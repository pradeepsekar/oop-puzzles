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

	private static AllocateParkingLotCommand instance = null;
	
	private AllocateParkingLotCommand() {}

	public static synchronized AllocateParkingLotCommand getInstance() {
		if (instance == null) {
			synchronized (AllocateParkingLotCommand.class) {
				instance = new AllocateParkingLotCommand();
			}
		}
		return instance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.oop.puzzles.parkinglot.commands.ICommand#execute()
	 */
	@Override
	public Ticket execute(final ParkingLot parkinglot, final User user) {
		Ticket ticket = null;
		if (parkinglot.getTotalSlotsAvailable() > 0) {
			parkinglot.newVehicleParked(parkinglot.getNearestSlotAvailable(), user.getVehicle());
			ticket = new Ticket(user.getVehicle().getRegistrationNumber(), user.getVehicle().getColor(),
					parkinglot.getNearestSlotAvailable());
			System.out.println("Allocated slot number: " + ticket.getAllocatedSlotId());
		} else {
			System.out.println("Sorry, parking lot is full");
		}
		return ticket;
	}
}
