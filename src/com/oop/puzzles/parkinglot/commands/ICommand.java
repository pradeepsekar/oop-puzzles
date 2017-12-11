/**
 * 
 */
package com.oop.puzzles.parkinglot.commands;

import com.oop.puzzles.parkinglot.models.Ticket;

/**
 * @author Pradeep S
 *
 */
public interface ICommand {
	
	public Ticket execute(final String registrationNumber, final String color, final int slotNumber);

}
