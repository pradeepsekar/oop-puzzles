package com.oop.puzzles.parkinglot.strategies.ticket;

import java.util.Optional;

import com.oop.puzzles.parkinglot.commands.ICommand;
import com.oop.puzzles.parkinglot.models.ParkingLot;
import com.oop.puzzles.parkinglot.models.User;
import com.oop.puzzles.parkinglot.strategies.ITicketStrategy;

public class ReturnTicketStrategy implements ITicketStrategy<Boolean> {

	private ICommand deAllocateParkingCommand;

	public ReturnTicketStrategy(ICommand deAllocateParkingCommand) {
		this.deAllocateParkingCommand = deAllocateParkingCommand;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Boolean execute(final ParkingLot parkingLot, final User user) {
		this.deAllocateParkingCommand.execute(parkingLot, user);
		parkingLot.setTotalSlotsAvailable(parkingLot.getTotalSlotsAvailable() + 1);
		Optional<Integer> maxAllocatedSlot = parkingLot.getAllocatedVehicleSlots().stream().max(Integer::compareTo);
		parkingLot.setNearestSlotAvailable(Integer.min(user.getTicket().getAllocatedSlotId(), maxAllocatedSlot.get()));
		return Boolean.TRUE;
	}
}
