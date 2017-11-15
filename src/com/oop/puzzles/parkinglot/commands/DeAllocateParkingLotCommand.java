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
public class DeAllocateParkingLotCommand implements ICommand {

	private static DeAllocateParkingLotCommand instance = null;

	private DeAllocateParkingLotCommand() {
	}

	public static synchronized DeAllocateParkingLotCommand getInstance() {
		if (instance == null) {
			synchronized (DeAllocateParkingLotCommand.class) {
				instance = new DeAllocateParkingLotCommand();
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
		parkinglot.vehicleLeftParking(user.getTicket().getAllocatedSlotId());
		System.out.println("Slot number " + user.getTicket().getAllocatedSlotId() + " is free");
		return null;
	}

}
