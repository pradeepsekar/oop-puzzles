/**
 * 
 */
package com.oop.puzzles.parkinglot.models;

/**
 * @author Pradeep S
 *
 */
public class Ticket {

	private final String registrationNumber;
	private final String color;
	private final int allocatedSlotId;

	public Ticket(String registrationNumber, String color, int allocatedSlotId) {
		this.registrationNumber = registrationNumber;
		this.color = color;
		this.allocatedSlotId = allocatedSlotId;
	}
	
	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public String getColor() {
		return color;
	}

	public int getAllocatedSlotId() {
		return allocatedSlotId;
	}
}
