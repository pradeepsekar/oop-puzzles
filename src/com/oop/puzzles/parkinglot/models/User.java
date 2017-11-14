package com.oop.puzzles.parkinglot.models;

public class User {

	private final Vehicle vehicle;
	private Ticket ticket;
	
	public User(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

}
