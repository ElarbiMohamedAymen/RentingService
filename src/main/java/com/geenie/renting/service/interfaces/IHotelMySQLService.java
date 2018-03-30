package com.geenie.renting.service.interfaces;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.geenie.renting.beans.Hotel;

public interface IHotelMySQLService {
	
	@Transactional
	public void addHotel(Hotel hotel);
	
	public List<Hotel> findAllHotels();
	
	public int countAvailableRooms(Hotel hotel);

}
