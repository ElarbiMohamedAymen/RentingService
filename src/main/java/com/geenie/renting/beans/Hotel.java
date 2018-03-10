package com.geenie.renting.beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("HOTEL")
public class Hotel extends User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int roomNumber;
	private String address;
	private User manager;
	@OneToMany(mappedBy="hotel",cascade=CascadeType.PERSIST,fetch = FetchType.EAGER)
	private List<HotelRoom> rooms;

	public Hotel(int roomNumber, String address, User manager, List<HotelRoom> rooms) {
		super();
		this.roomNumber = roomNumber;
		this.address = address;
		this.manager = manager;
		this.rooms = rooms;
	}

	public Hotel() {
	}
	

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public User getManager() {
		return manager;
	}

	public void setManager(User manager) {
		this.manager = manager;
	}

	public List<HotelRoom> getRooms() {
		return rooms;
	}

	public void setRooms(List<HotelRoom> rooms) {
		this.rooms = rooms;
	}

}
