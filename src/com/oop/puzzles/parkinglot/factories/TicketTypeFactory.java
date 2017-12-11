package com.oop.puzzles.parkinglot.factories;

import com.oop.puzzles.parkinglot.commands.IssueTicketCommand;
import com.oop.puzzles.parkinglot.commands.ReturnTicketCommand;
import com.oop.puzzles.parkinglot.commands.ICommand;
import com.oop.puzzles.parkinglot.enums.TicketCommandType;

public class TicketTypeFactory {

	public static ICommand getCommandInstance(final TicketCommandType ticketCommandType) {
		ICommand command = null;
		switch (ticketCommandType) {
		case ISSUE_TICKET: {
			command = new IssueTicketCommand();
			break;
		}
		case RETURN_TICKET: {
			command = new ReturnTicketCommand();
			break;
		}
		default:
			break;
		}
		return command;
	}

}
