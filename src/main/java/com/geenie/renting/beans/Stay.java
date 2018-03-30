package com.geenie.renting.beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Stay implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idStay;
	@ManyToMany(mappedBy="stays")
	private List<User> users;
	private Hotel hotel;
	private HotelRoom room;
	private Appartment appartment;
	private String from;
	private String to;

	public Stay() {
	}

	public Stay(List<User> users, Hotel hotel, HotelRoom room, Appartment appartment, String from, String to) {
		room.setOccupied(true);
		appartment.setOccupied(true);
		this.users = users;
		this.hotel = hotel;
		this.room = room;
		this.appartment = appartment;
		this.from = from;
		this.to = to;
	}

	public long getIdStay() {
		return idStay;
	}

	public void setIdStay(long idStay) {
		this.idStay = idStay;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public HotelRoom getRoom() {
		return room;
	}

	public void setRoom(HotelRoom room) {
		this.room = room;
	}

	public Appartment getAppartment() {
		return appartment;
	}

	public void setAppartment(Appartment appartment) {
		this.appartment = appartment;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	@Override
	public String toString() {
		return "Stay [idStay=" + idStay + ", users=" + users.size() + ", hotel=" + hotel + ", room=" + room + ", appartment="
				+ appartment + ", from=" + from + ", to=" + to + "]";
	}

	
}
