package com.geenie.renting;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.geenie.renting.beans.Hotel;
import com.geenie.renting.beans.HotelRoom;
import com.geenie.renting.beans.User;
import com.geenie.renting.service.interfaces.IAppartmentMySQLService;
import com.geenie.renting.service.interfaces.IHotelMySQLService;
import com.geenie.renting.service.interfaces.IHotelRoomMySQLService;
import com.geenie.renting.service.interfaces.IStayMySQLService;
import com.geenie.renting.service.interfaces.IUserMYSQLService;


@Service
@Transactional
public class StartUpInit implements ApplicationRunner {

	
	@Autowired
	@Qualifier("hotelMySQLServiceImpl")
	IHotelMySQLService hotelService;
	
	@Autowired
	@Qualifier("appartmentMySQLServiceImpl")
	IAppartmentMySQLService appartmentService;
	
	@Autowired
	@Qualifier("hotelRoomMySQLServiceImpl")
	IHotelRoomMySQLService hotelRoomService;
	
	@Autowired
	@Qualifier("userMySQLServiceImpl")
	IUserMYSQLService userService;
	
	@Autowired
	@Qualifier("stayMySQLServiceImpl")
	IStayMySQLService stayService;
	
	
	@Override
	public void run(ApplicationArguments arg0) throws Exception {
		User manager = new User();
		manager.setFirstName("Elarbi");
		manager.setLastName("Aymen");
		manager.setAge(25);
		manager.setActive(true);
		manager.setMail("mohamedaymen.elarbi@esprit.tn");
		manager.setUsername("zimouarbi");
		manager.setPassword("123456");
		
		userService.addUser(manager);
		
		Hotel hotel = new Hotel();
		hotel.setHotelName("ARABIAN");
		hotel.setAddress("IBN KHALDOUN");
		hotel.setManager(manager);
		
		HotelRoom room1 = new HotelRoom();
		room1.setBeds(1);
		room1.setHotel(hotel);
		room1.setOccupied(true);
		
		HotelRoom room2 = new HotelRoom();
		room2.setBeds(2);
		room2.setHotel(hotel);
		room2.setOccupied(false);
		
		HotelRoom room3 = new HotelRoom();
		room3.setBeds(1);
		room3.setHotel(hotel);
		room3.setOccupied(false);
		
		HotelRoom room4 = new HotelRoom();
		room4.setBeds(3);
		room4.setHotel(hotel);
		room4.setOccupied(false);
		
		List<HotelRoom> rooms = new ArrayList<>();
		rooms.add(room1);
		rooms.add(room2);
		rooms.add(room3);
		rooms.add(room4);
		
		hotel.setRooms(rooms);
		hotel.setRoomNumber(rooms.size());
		
		hotelRoomService.addHotelRoom(room1);
		hotelRoomService.addHotelRoom(room2);
		hotelRoomService.addHotelRoom(room3);
		hotelRoomService.addHotelRoom(room4);
		
		hotelService.addHotel(hotel);
		

		
	}
}
