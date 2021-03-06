package com.geenie.renting.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.geenie.renting.beans.Hotel;
import com.geenie.renting.beans.HotelRoom;
import com.geenie.renting.repository.HotelRepository;
import com.geenie.renting.service.interfaces.IHotelMySQLService;

@Service
public class HotelMySQLServiceImpl implements IHotelMySQLService {
	
	@Autowired
	private HotelRepository hotelRepository;

	@Override
	@Transactional
	public void addHotel(Hotel hotel) {
		hotelRepository.save(hotel);	
	}

	@Override
	public List<Hotel> findAllHotels() {
		return (List<Hotel>) hotelRepository.findAll();
	}

	@Override
	public int countAvailableRooms(Hotel hotel) {
		List<HotelRoom>rooms = hotel.getRooms();
		int availableRooms = 0;
		for (HotelRoom hotelRoom : rooms) {
			if(!hotelRoom.isOccupied()){
				availableRooms++;
			}
		}
		return availableRooms;
	}

}
