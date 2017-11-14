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

	public ParkingLot(int totalSlots) {
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

	public void setTotalSlotsAvailable(int totalSlotsAvailable) {
		this.totalSlotsAvailable = totalSlotsAvailable;
	}

	public int getNearestSlotAvailable() {
		return nearestSlotAvailable;
	}

	public void setNearestSlotAvailable(int nearestSlotAvailable) {
		this.nearestSlotAvailable = nearestSlotAvailable;
	}
	
	public Set<Integer> getAllocatedVehicleSlots() {
		return this.allocatedSlotDetails.keySet();
	}
	
	public Vehicle getVehicleInSlot(int slotId) {
		return this.allocatedSlotDetails.get(slotId);
	}
	
	public Stream<Vehicle> getAllVehicles() {
		return this.allocatedSlotDetails.values().stream();
	}

	public void newVehicleParked(int slotId, Vehicle vehicle) {
		this.allocatedSlotDetails.put(slotId, vehicle);
	}

	public void vehicleLeftParking(int slotId) {
		this.allocatedSlotDetails.remove(slotId);
	}

}
