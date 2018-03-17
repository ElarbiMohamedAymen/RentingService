package com.geenie.renting.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geenie.renting.beans.Hotel;
import com.geenie.renting.repository.HotelRepository;
import com.geenie.renting.service.interfaces.IHotelMySQLService;

@Service
public class HotelMySQLServiceImpl implements IHotelMySQLService {
	
	@Autowired
	private HotelRepository hotelRepository;

	@Override
	public void addHotel(Hotel hotel) {
		hotelRepository.save(hotel);	
	}

	@Override
	public List<Hotel> findAllHotels() {
		return (List<Hotel>) hotelRepository.findAll();
	}

}
