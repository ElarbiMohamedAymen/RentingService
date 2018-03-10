package com.geenie.renting.beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
@DiscriminatorValue("APPARTMENT")
public class Appartment  extends User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String type;
	private int rooms;
	private boolean occupied;
	private User occupant;
	private User owner;
	@ManyToMany(mappedBy="appartmentsStayed")
	private List<User> previousOccupant;
	@ManyToMany(mappedBy="appartmentsOwned")
	private List<User> previousOwners;
	
	public Appartment(String type, int rooms, boolean occupied, User owner) {
		super();
		this.type = type;
		this.rooms = rooms;
		this.occupied = occupied;
		this.owner = owner;
	}

	
	public Appartment() {
	}


	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getRooms() {
		return rooms;
	}

	public void setRooms(int rooms) {
		this.rooms = rooms;
	}

	public boolean isOccupied() {
		return occupied;
	}

	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}

	public User getOccupant() {
		return occupant;
	}

	public void setOccupant(User occupant) {
		this.occupant = occupant;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public List<User> getPreviousOccupant() {
		return previousOccupant;
	}

	public void setPreviousOccupant(List<User> previousOccupant) {
		this.previousOccupant = previousOccupant;
	}

	public List<User> getPreviousOwners() {
		return previousOwners;
	}

	public void setPreviousOwners(List<User> previousOwners) {
		this.previousOwners = previousOwners;
	}
	
	
	
	
	
}
