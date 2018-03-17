package com.geenie.renting.service.interfaces;

import java.util.List;

import com.geenie.renting.beans.Hotel;

public interface IHotelMySQLService {
	
	public void addHotel(Hotel hotel);
	
	public List<Hotel> findAllHotels();
	
	public int countAvailableRooms(Hotel hotel);

}
