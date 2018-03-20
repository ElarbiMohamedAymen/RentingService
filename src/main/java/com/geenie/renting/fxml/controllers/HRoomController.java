package com.geenie.renting.fxml.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import com.geenie.renting.beans.Hotel;
import com.geenie.renting.beans.HotelRoom;
import com.geenie.renting.service.interfaces.IHotelMySQLService;

import javafx.fxml.Initializable;

@Controller
public class HRoomController implements Initializable {

	public static HotelRoom hotelRoom;
	@Lazy
	@Autowired
	@Qualifier("hotelMySQLServiceImpl")
	IHotelMySQLService hotelService;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Hotel hotel = new Hotel();
		hotel.setHotelName("ARABIAN2");
		hotel.setAddress("IBN KHALDOUN");
		hotelService.addHotel(hotel);
		// TODO Auto-generated method stub
		
	}

}
