/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geenie.renting.fxml.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;

import com.geenie.renting.fxml.utils.Utils;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author ElarbiMohamedAymen
 */
public class LoginController implements Initializable {

	private final static String gotoLoginPane = "loginPane";

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

	/**
	 * Initializes the controller class.
	 */
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		Utils.switchPanes(gotoLoginPane, parentPane);
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
		}
		else{
			Utils.switchPanes("newUserPane", parentPane);
		}
	}

	@FXML
	void logoutAppartment(ActionEvent event) {
		Utils.switchPanes(gotoLoginPane, parentPane);

	}

	@FXML
	void logoutHotel(ActionEvent event) {
		Utils.switchPanes(gotoLoginPane, parentPane);
	}

	@FXML
	void logoutNewUser(ActionEvent event) {
		Utils.switchPanes(gotoLoginPane, parentPane);
	}

}
