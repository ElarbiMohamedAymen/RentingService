package com.geenie.renting.fxml.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import com.geenie.renting.beans.Hotel;
import com.geenie.renting.beans.HotelRoom;
import com.geenie.renting.service.interfaces.IHotelMySQLService;
import com.jfoenix.controls.JFXListView;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import com.jfoenix.controls.JFXButton;

@Controller
public class HRoomController implements Initializable {
	private static final Logger LOGGER = LoggerFactory.getLogger(HRoomController.class);

	public static HotelRoom hotelRoom;
	public static int selectedRoom;

	@FXML
	private JFXListView<String> hotelRoomsName;

	@FXML
	private Label roomTypeLabel;

	@FXML
	private Label roomBedsLabel;

	@FXML
	private Label roomStatusLabel;

	@FXML
	private JFXButton bookBTN;

	@Lazy
	@Autowired
	@Qualifier("hotelMySQLServiceImpl")
	IHotelMySQLService hotelService;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		LOGGER.info("focusing room {}", selectedRoom);
		ObservableList<String> items = FXCollections.observableArrayList();
		Hotel hotel = hotelRoom.getHotel();
		int i = 1;
		for (HotelRoom room : hotel.getRooms()) {
			items.add("Room " + i);
			i++;
		}
		hotelRoomsName.setItems(items);
		hotelRoomsName.requestFocus();
		hotelRoomsName.getSelectionModel().select(selectedRoom);
		hotelRoomsName.getFocusModel().focus(selectedRoom);
		displayRoomInformation(hotel.getRooms().get(selectedRoom));
		hotelRoomsName.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				displayRoomInformation(hotel.getRooms().get(hotelRoomsName.getSelectionModel().getSelectedIndex()));
			}
		});
	}

	private void displayRoomInformation(HotelRoom selectedHotelRoom) {
		LOGGER.info("setting information for room {}", hotelRoom);
		roomTypeLabel.setText(selectedHotelRoom.getType());
		roomBedsLabel.setText(String.valueOf(selectedHotelRoom.getBeds()));
		if (selectedHotelRoom.isOccupied()) {
			roomStatusLabel.setText("Not Available");
			bookBTN.setDisable(true);
		} else {
			roomStatusLabel.setText("Available now");
			bookBTN.setDisable(false);
		}

	}

	@FXML
	void bookAction(ActionEvent event) {

	}

}
