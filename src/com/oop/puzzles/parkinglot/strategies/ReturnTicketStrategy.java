package com.oop.puzzles.parkinglot.strategies;

import java.util.Optional;

import com.oop.puzzles.parkinglot.commands.ICommand;
import com.oop.puzzles.parkinglot.models.ParkingLot;
import com.oop.puzzles.parkinglot.models.Ticket;
import com.oop.puzzles.parkinglot.models.User;

public class ReturnTicketStrategy implements ITicketStrategy {

	private ICommand deAllocateParkingCommand;

	public ReturnTicketStrategy(ICommand deAllocateParkingCommand) {
		this.deAllocateParkingCommand = deAllocateParkingCommand;
	}

	@Override
	public Ticket execute(ParkingLot parkingLot, User user) {
		this.deAllocateParkingCommand.execute(parkingLot, user);
		parkingLot.setTotalSlotsAvailable(parkingLot.getTotalSlotsAvailable() + 1);
		Optional<Integer> maxAllocatedSlot = parkingLot.getAllocatedVehicleSlots().stream().max(Integer::compareTo);
		parkingLot.setNearestSlotAvailable(Integer.min(user.getTicket().getAllocatedSlotId(), maxAllocatedSlot.get()));
		return null;
	}
}
