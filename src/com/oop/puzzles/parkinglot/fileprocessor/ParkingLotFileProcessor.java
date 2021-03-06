package com.oop.puzzles.parkinglot.fileprocessor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.oop.puzzles.parkinglot.enums.TicketCommandType;
import com.oop.puzzles.parkinglot.factories.TicketTypeFactory;
import com.oop.puzzles.parkinglot.models.ParkingLot;
import com.oop.puzzles.parkinglot.models.Ticket;
import com.oop.puzzles.parkinglot.models.User;
import com.oop.puzzles.parkinglot.models.Vehicle;
import com.oop.puzzles.parkinglot.strategies.IFetchDetailsStrategy;
import com.oop.puzzles.parkinglot.strategies.ITicketStrategy;
import com.oop.puzzles.parkinglot.strategies.fetchdetails.RegNumBasedOnColor;
import com.oop.puzzles.parkinglot.strategies.fetchdetails.SlotNumbersBasedOnColor;
import com.oop.puzzles.parkinglot.strategies.fetchdetails.SlotNumbersBasedOnRegNo;
import com.oop.puzzles.parkinglot.strategies.ticket.IssueTicketStrategy;
import com.oop.puzzles.parkinglot.strategies.ticket.ReturnTicketStrategy;

public class ParkingLotFileProcessor {

	private static final String CREATE_PARKING_LOT = "create_parking_lot";
	private static final String PARK_VEHICLE = "park";
	private static final String DEALLOCATE_PARKING = "leave";
	private static final String STATUS = "status";
	private static final String REG_NO_BASED_ON_COLOR = "registration_numbers_for_cars_with_colour";
	private static final String SLOT_NUM_FOR_COLOR = "slot_numbers_for_cars_with_colour";
	private static final String SLOT_NUM_FOR_REG = "slot_number_for_registration_number";

	private static ParkingLot parkingLot = null;
	private static List<User> users = new ArrayList<>();

	public static void processFileContents(List<String> fileContents) {
		for (String command : fileContents) {
			String[] commands = command.split("\\s");
			switch (commands[0]) {
			case ParkingLotFileProcessor.CREATE_PARKING_LOT:
				ParkingLotFileProcessor.createParkingLot(commands[1]);
				break;

			case ParkingLotFileProcessor.PARK_VEHICLE:
				ParkingLotFileProcessor.addNewVehicleToParking(commands[1], commands[2]);
				break;

			case ParkingLotFileProcessor.DEALLOCATE_PARKING:
				ParkingLotFileProcessor.deallocateParking(new Integer(commands[1]));
				break;

			case ParkingLotFileProcessor.REG_NO_BASED_ON_COLOR:
				regNoBasedOnColor(commands[1]);
				break;

			case ParkingLotFileProcessor.SLOT_NUM_FOR_COLOR:
				slotsBasesOnColor(commands[1]);
				break;

			case ParkingLotFileProcessor.SLOT_NUM_FOR_REG:
				slotsBasedOnRegNo(commands[1]);
				break;

			case STATUS:
				getParkingLotStatus();
				break;

			default:
				System.out.println("Unexpected command provided to system - " + command);
				break;

			}
		}
	}

	private static void createParkingLot(final String slots) {
		ParkingLotFileProcessor.parkingLot = new ParkingLot(new Integer(slots));
	}

	private static void addNewVehicleToParking(final String regNo, final String color) {
		ITicketStrategy<Ticket> allocateTicket = new IssueTicketStrategy(
				TicketTypeFactory.getCommandInstance(TicketCommandType.ISSUE_TICKET));
		Vehicle currentVehicle = new Vehicle(regNo, color);
		User currentUser = new User(currentVehicle);
		Ticket issueTicket = allocateTicket.execute(parkingLot, currentUser);
		if (issueTicket != null && issueTicket.getAllocatedSlotId() > 0) {
			currentUser.setTicket(issueTicket);
			ParkingLotFileProcessor.users.add(currentUser);
		}
	}

	private static void deallocateParking(final int slotId) {
		Optional<User> selectedUser = ParkingLotFileProcessor.users.stream()
				.filter(user -> user.getTicket().getAllocatedSlotId() == slotId).findFirst();
		if (selectedUser.isPresent()) {
			ITicketStrategy<Boolean> deallocateTicket = new ReturnTicketStrategy(
					TicketTypeFactory.getCommandInstance(TicketCommandType.RETURN_TICKET));
			deallocateTicket.execute(parkingLot, selectedUser.get());
		} else {
			System.out.println("Invalid slot id.");
		}
	}

	private static void regNoBasedOnColor(final String color) {
		IFetchDetailsStrategy regNoStrat = new RegNumBasedOnColor(parkingLot);
		regNoStrat.getDetails(color);
	}

	private static void slotsBasesOnColor(final String color) {
		IFetchDetailsStrategy slotBasedOnColor = new SlotNumbersBasedOnColor(parkingLot);
		slotBasedOnColor.getDetails(color);
	}

	private static void slotsBasedOnRegNo(final String regNo) {
		IFetchDetailsStrategy slotBasedOnColor = new SlotNumbersBasedOnRegNo(parkingLot);
		slotBasedOnColor.getDetails(regNo);
	}

	private static void getParkingLotStatus() {
		System.out.println("Slot No. Registration No Colour");
		parkingLot.getAllocatedVehicleSlots().stream()
				.forEach(slotId -> System.out
						.println(slotId + "   " + parkingLot.getVehicleInSlot(slotId).getRegistrationNumber() + "   "
								+ parkingLot.getVehicleInSlot(slotId).getColor()));
	}

}
