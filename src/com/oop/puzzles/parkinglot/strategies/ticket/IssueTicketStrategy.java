package com.oop.puzzles.parkinglot.strategies.ticket;

import java.util.Optional;

import com.oop.puzzles.parkinglot.commands.ICommand;
import com.oop.puzzles.parkinglot.models.ParkingLot;
import com.oop.puzzles.parkinglot.models.Ticket;
import com.oop.puzzles.parkinglot.models.User;
import com.oop.puzzles.parkinglot.strategies.ITicketStrategy;

public class IssueTicketStrategy implements ITicketStrategy<Ticket> {

	private ICommand allocateParkingCommand;

	public IssueTicketStrategy(ICommand allocateParkingCommand) {
		this.allocateParkingCommand = allocateParkingCommand;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Ticket execute(final ParkingLot parkingLot, final User user) {
		Ticket ticket = null;
		if (parkingLot.getTotalSlotsAvailable() > 0) {
			ticket = this.allocateParkingCommand.execute(user.getVehicle().getRegistrationNumber(),
					user.getVehicle().getColor(), parkingLot.getNearestSlotAvailable());
			parkingLot.newVehicleParked(parkingLot.getNearestSlotAvailable(), user.getVehicle());
			parkingLot.setTotalSlotsAvailable(parkingLot.getTotalSlotsAvailable() - 1);
			Optional<Integer> maxAllocatedSlot = parkingLot.getAllocatedVehicleSlots().stream().max(Integer::compareTo);
			parkingLot.newVehicleParked(parkingLot.getNearestSlotAvailable(), user.getVehicle());
			parkingLot.setNearestSlotAvailable(maxAllocatedSlot.get() + 1);
		} else {
			System.out.println("Sorry, parking lot is full");
		}
		return ticket;
	}

}
