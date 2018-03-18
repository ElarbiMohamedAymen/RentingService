package com.geenie.renting.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.geenie.renting.beans.HotelRoom;
import com.geenie.renting.repository.HotelRoomRepository;
import com.geenie.renting.service.interfaces.IHotelRoomMySQLService;

public class HotelRoomMySQLServiceImpl implements IHotelRoomMySQLService {

	@Autowired
	private HotelRoomRepository hotelRoomRepository;
	
	@Override
	public void addHotelRoom(HotelRoom hotelRoom) {
		hotelRoomRepository.save(hotelRoom);
		
	}

}
