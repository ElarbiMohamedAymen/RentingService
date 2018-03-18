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
		
		HotelRoom room5 = new HotelRoom();
		room5.setBeds(1);
		room5.setHotel(hotel);
		room5.setOccupied(false);
		
		HotelRoom room6 = new HotelRoom();
		room6.setBeds(2);
		room6.setHotel(hotel);
		room6.setOccupied(true);
		
		HotelRoom room7 = new HotelRoom();
		room7.setBeds(1);
		room7.setHotel(hotel);
		room7.setOccupied(true);
		
		HotelRoom room8 = new HotelRoom();
		room8.setBeds(3);
		room8.setHotel(hotel);
		room8.setOccupied(true);
		
		List<HotelRoom> rooms = new ArrayList<>();
		rooms.add(room1);
		rooms.add(room2);
		rooms.add(room3);
		rooms.add(room4);
		rooms.add(room5);
		rooms.add(room6);
		rooms.add(room7);
		rooms.add(room8);
		
		hotel.setRooms(rooms);
		hotel.setRoomNumber(rooms.size());
		
		for (HotelRoom hotelRoom : rooms) {
			hotelRoomService.addHotelRoom(hotelRoom);
		}
		
		hotelService.addHotel(hotel);
		

		
	}
}
