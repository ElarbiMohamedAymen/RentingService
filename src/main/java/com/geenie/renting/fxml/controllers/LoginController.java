/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geenie.renting.fxml.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import javafx.fxml.Initializable;

import com.geenie.renting.beans.Hotel;
import com.geenie.renting.fxml.utils.Utils;
import com.geenie.renting.service.interfaces.IHotelMySQLService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author ElarbiMohamedAymen
 */
@Controller
public class LoginController implements Initializable {
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

	private static final String GOTO_LOGIN_PANE = "loginPane";

	@FXML
	private AnchorPane parentPane;

	@FXML
	private AnchorPane loginPane;
	@FXML
	private AnchorPane hotelPane;
	@FXML
	private AnchorPane appartmentPane;

	@FXML
	private JFXTextField usernameLoginTF;

	@FXML
	private JFXTextField passwordLoginTF;

	@FXML
	private JFXButton logoutHotelPane;

	@FXML
	private JFXButton logoutAppartmentPane;
	@FXML
	private AnchorPane newUserPane;

	@FXML
	private JFXButton logoutNewUserPane;

	@FXML
	private AnchorPane addHotelPane;

	@FXML
	private AnchorPane displayHotelPane;
	@FXML
	private TabPane hotelManagmentTab;
	@FXML
	private Tab specificHotelManagment;
	@FXML
	private AnchorPane manageHotelPane;
	@FXML
	private AnchorPane manageHotelPaneParent;

	@FXML
	private JFXTextField addHotelNameTF;

	@FXML
	private JFXTextField addHotelAddressTF;

	@FXML
	private JFXTextField addHotelRoomsTF;

	@FXML
	private JFXTextField addHotelManagerTF;
	@FXML
	private TableView<Hotel> displayAllHotelsTV;

	@FXML
	private TableColumn<Hotel, String> hotelnameCl;

	@FXML
	private TableColumn<Hotel, String> hoteladdresscl;

	@FXML
	private TableColumn<Hotel, String> hotelManagerCl;

	@FXML
	private TableColumn<Hotel, String> hotelRoomsCl;
	@FXML
	HBox hbox;

	@Lazy
	@Autowired
	@Qualifier("hotelMySQLServiceImpl")
	IHotelMySQLService hotelService;

	/**
	 * Initializes the controller class.
	 */
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		Utils.switchPanes(GOTO_LOGIN_PANE, parentPane);
		// TODO
	}

	@FXML
	void unlockAccess(ActionEvent event) {
		// TODO
		String gotos = usernameLoginTF.getText();
		if (gotos.equals("hafa")) {
			Utils.switchPanes("appartmentPane", parentPane);
		}
		if (gotos.equals("aymen")) {
			Utils.switchPanes("hotelPane", parentPane);
		} else {
			Utils.switchPanes("newUserPane", parentPane);
		}
	}

	@FXML
	void logoutAppartment(ActionEvent event) {
		Utils.switchPanes(GOTO_LOGIN_PANE, parentPane);

	}

	@FXML
	void logoutHotel(ActionEvent event) {
		Utils.switchPanes(GOTO_LOGIN_PANE, parentPane);
	}

	@FXML
	void logoutNewUser(ActionEvent event) {
		Utils.switchPanes(GOTO_LOGIN_PANE, parentPane);
	}

	@FXML
	void displayAddHotelGrid(ActionEvent event) {
		Utils.switchPanes("addHotelPane", manageHotelPane);
	}

	@FXML
	void displayHotelGrid(ActionEvent event) {
		Utils.switchPanes("displayHotelPane", manageHotelPane);
		ObservableList<Hotel> hotelsData = FXCollections.observableArrayList();
		List<Hotel> hotels = hotelService.findAllHotels();
		for (Hotel hotel : hotels) {
			hotelsData.add(hotel);
		}
		hotelnameCl.setCellValueFactory(new PropertyValueFactory<>("hotelName"));
		hoteladdresscl.setCellValueFactory(new PropertyValueFactory<>("address"));
		hotelManagerCl.setCellValueFactory(hotel -> {
			String manager = "";
			if (hotel.getValue().getManager() != null) {
				manager = hotel.getValue().getManager().getLastName() + " "
						+ hotel.getValue().getManager().getFirstName();
			} else {
				manager = "PasEncoreDéfini";
			}
			return new ReadOnlyStringWrapper(manager);
		});
		hotelRoomsCl.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
		// TODO change roomNumbers to available rooms, using
		// countAvailableRooms()
		displayAllHotelsTV.setItems(hotelsData);
	}

	@FXML
	void clearAddHotel(ActionEvent event) {

		addHotelNameTF.setText("");

		addHotelAddressTF.setText("");

		addHotelRoomsTF.setText("");

		addHotelManagerTF.setText("");
	}

	@FXML
	void performAddHotel(ActionEvent event) {
		String hotelName = addHotelNameTF.getText();

		String hotelAddress = addHotelAddressTF.getText();

		String hotelManager = addHotelManagerTF.getText();

		int hotelRooms = -1;

		if (Utils.isNumber(addHotelRoomsTF.getText())) {
			hotelRooms = Integer.valueOf(addHotelRoomsTF.getText());
		} else {
			// TODO error hotelRooms should be integer
		}
		Hotel hotel = new Hotel();
		hotel.setHotelName(hotelName);
		hotel.setAddress(hotelAddress);
		hotel.setRoomNumber(hotelRooms);
		hotelService.addHotel(hotel);

	}

	@FXML
	void viewInDetails(MouseEvent event) {
		try {
			Hotel hotel = displayAllHotelsTV.getSelectionModel().getSelectedItem();
			if (hotel == null) {
				return;
			}
			openProdDetails(hotel);
		} catch (Exception e) {
			LOGGER.error("Exception!!", e);
			return;
		}
	}

	private void openProdDetails(Hotel hotel) {
		//TODO to complete
		specificHotelManagment.setDisable(false);
		hotelManagmentTab.getSelectionModel().select(specificHotelManagment);
		specificHotelManagment.setText(hotel.getHotelName());

		for (int i = 0; i < hotel.getRoomNumber(); i++) {
			// for (Category L : listCategories) {
			JFXButton bn = new JFXButton();
			bn.setText(String.valueOf(i + 1));
			bn.setStyle("-fx-font-size: 20px");

			hbox.getChildren().add(bn);
			hbox.setSpacing(20);
			hbox.setLayoutY(20);
			hbox.setLayoutX(10);

			bn.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					System.out.println(bn.getText());

				}
			});

		}
	}
}
