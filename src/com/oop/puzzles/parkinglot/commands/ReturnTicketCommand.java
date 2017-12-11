/**
 * 
 */
package com.oop.puzzles.parkinglot.commands;

import com.oop.puzzles.parkinglot.models.Ticket;

/**
 * @author Pradeep S
 *
 */
public class ReturnTicketCommand implements ICommand {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.oop.puzzles.parkinglot.commands.ICommand#execute()
	 */
	@Override
	public Ticket execute(final String registrationNumber, final String color, final int slotNumber) {
		System.out.println("Slot number " + slotNumber + " is free");
		return null;
	}

}
