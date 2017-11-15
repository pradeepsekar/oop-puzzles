package com.oop.puzzles.parkinglot.factories;

import com.oop.puzzles.parkinglot.commands.AllocateParkingLotCommand;
import com.oop.puzzles.parkinglot.commands.DeAllocateParkingLotCommand;
import com.oop.puzzles.parkinglot.commands.ICommand;
import com.oop.puzzles.parkinglot.enums.TicketCommandType;

public class TicketTypeFactory {

	public static ICommand getCommandInstance(final TicketCommandType ticketCommandType) {
		ICommand command = null;
		switch (ticketCommandType) {
		case ISSUE_TICKET: {
			command = AllocateParkingLotCommand.getInstance();
			break;
		}
		case RETURN_TICKET: {
			command = DeAllocateParkingLotCommand.getInstance();
			break;
		}
		default:
			break;
		}
		return command;
	}

}
