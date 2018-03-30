package com.geenie.renting.beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Hotel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idHotel;
	private int roomNumber;
	private String address;
	private String hotelName;
	@OneToOne()
	private User manager;
	@OneToMany(mappedBy = "hotel", fetch = FetchType.EAGER)
	private List<HotelRoom> rooms;

	public Hotel(String hotelName, int roomNumber, String address, User manager, List<HotelRoom> rooms) {
		this.roomNumber = roomNumber;
		this.address = address;
		this.manager = manager;
		this.rooms = rooms;
		this.hotelName = hotelName;
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

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public long getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(long idHotel) {
		this.idHotel = idHotel;
	}
	

}
