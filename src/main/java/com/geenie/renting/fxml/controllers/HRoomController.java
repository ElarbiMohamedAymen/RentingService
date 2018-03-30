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
import com.jfoenix.controls.JFXListView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;

@Controller
public class HRoomController implements Initializable {

	public static HotelRoom hotelRoom;

    @FXML
    private JFXListView<String> hotelRoomsName;
    
    
	@Lazy
	@Autowired
	@Qualifier("hotelMySQLServiceImpl")
	IHotelMySQLService hotelService;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<String> items = FXCollections.observableArrayList ();
		Hotel hotel = hotelRoom.getHotel();
		int i = 1;
		for (HotelRoom room : hotel.getRooms()) {
			items.add("Room "+i);
			i++;
		}
		hotelRoomsName.setItems(items);
	}

    @FXML
    void moreDetails(MouseEvent event) {

    }

}
