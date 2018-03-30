package com.geenie.renting.beans;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class HotelRoom implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idHotelRoom;
	private String type;
	private int beds;
	private boolean occupied;
	@ManyToOne
	private Hotel hotel;

	public HotelRoom() {
	}

	public HotelRoom(long idHotelRoom, String type, int beds) {
		this.idHotelRoom = idHotelRoom;
		this.type = type;
		this.beds = beds;
		this.occupied = false;
	}

	public long getIdHotelRoom() {
		return idHotelRoom;
	}

	public void setIdHotelRoom(long idHotelRoom) {
		this.idHotelRoom = idHotelRoom;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getBeds() {
		return beds;
	}

	public void setBeds(int beds) {
		this.beds = beds;
	}

	public boolean isOccupied() {
		return occupied;
	}

	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	@Override
	public String toString() {
		return "HotelRoom [idHotelRoom=" + idHotelRoom + ", type=" + type + ", beds=" + beds + ", occupied=" + occupied
				+ ", hotel=" + hotel + "]";
	}
	
	

}
