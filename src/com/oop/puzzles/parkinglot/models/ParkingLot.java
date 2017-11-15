/**
 * 
 */
package com.oop.puzzles.parkinglot.models;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

/**
 * @author Pradeep S
 *
 */
public class ParkingLot {

	private final int totalSlots;
	private int nearestSlotAvailable;
	private int totalSlotsAvailable;
	private Map<Integer, Vehicle> allocatedSlotDetails;

	public ParkingLot(final int totalSlots) {
		this.totalSlots = totalSlots;
		this.nearestSlotAvailable = 1;
		this.totalSlotsAvailable = totalSlots;
		allocatedSlotDetails = new HashMap<>(totalSlots);
	}

	public int getTotalSlots() {
		return totalSlots;
	}

	public int getTotalSlotsAvailable() {
		return totalSlotsAvailable;
	}

	public void setTotalSlotsAvailable(final int totalSlotsAvailable) {
		this.totalSlotsAvailable = totalSlotsAvailable;
	}

	public int getNearestSlotAvailable() {
		return nearestSlotAvailable;
	}

	public void setNearestSlotAvailable(final int nearestSlotAvailable) {
		this.nearestSlotAvailable = nearestSlotAvailable;
	}
	
	public Set<Integer> getAllocatedVehicleSlots() {
		return this.allocatedSlotDetails.keySet();
	}
	
	public Vehicle getVehicleInSlot(final int slotId) {
		return this.allocatedSlotDetails.get(slotId);
	}
	
	public Stream<Vehicle> getAllVehicles() {
		return this.allocatedSlotDetails.values().stream();
	}

	public void newVehicleParked(final int slotId, final Vehicle vehicle) {
		this.allocatedSlotDetails.put(slotId, vehicle);
	}

	public void vehicleLeftParking(final int slotId) {
		this.allocatedSlotDetails.remove(slotId);
	}

}
