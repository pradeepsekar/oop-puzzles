package com.oop.puzzles.parkinglot.strategies;

import java.util.Optional;

import com.oop.puzzles.parkinglot.commands.ICommand;
import com.oop.puzzles.parkinglot.models.ParkingLot;
import com.oop.puzzles.parkinglot.models.Ticket;
import com.oop.puzzles.parkinglot.models.User;

public class IssueTicketStrategy implements ITicketStrategy {

	private ICommand allocateParkingCommand;

	public IssueTicketStrategy(ICommand allocateParkingCommand) {
		this.allocateParkingCommand = allocateParkingCommand;
	}

	@Override
	public Ticket execute(ParkingLot parkingLot, User user) {
		Ticket ticket = this.allocateParkingCommand.execute(parkingLot, user);
		if (ticket != null) {
			parkingLot.setTotalSlotsAvailable(parkingLot.getTotalSlotsAvailable() - 1);
			Optional<Integer> maxAllocatedSlot = parkingLot.getAllocatedVehicleSlots().stream().max(Integer::compareTo);
			if (parkingLot.getTotalSlotsAvailable() > 0) {
				parkingLot.setNearestSlotAvailable(maxAllocatedSlot.get() + 1);
			}
		}
		return ticket;
	}

}
