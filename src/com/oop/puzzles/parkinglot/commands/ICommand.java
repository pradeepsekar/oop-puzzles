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
public interface ICommand {
	
	public Ticket execute(final ParkingLot parkinglot, final User user);

}
