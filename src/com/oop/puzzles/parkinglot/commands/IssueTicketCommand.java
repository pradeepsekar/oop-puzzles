/**
 * 
 */
package com.oop.puzzles.parkinglot.commands;

import com.oop.puzzles.parkinglot.models.Ticket;

/**
 * @author Pradeep S
 *
 */
public class IssueTicketCommand implements ICommand {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.oop.puzzles.parkinglot.commands.ICommand#execute()
	 */
	@Override
	public Ticket execute(final String registrationNumber, final String color, final int slotNumber) {
		Ticket ticket = null;
		ticket = new Ticket(registrationNumber, color, slotNumber);
		System.out.println("Allocated slot number: " + ticket.getAllocatedSlotId());
		return ticket;
	}
}
