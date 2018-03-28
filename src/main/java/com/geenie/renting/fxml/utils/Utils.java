package com.geenie.renting.fxml.utils;

import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

public class Utils {
	private static final Logger LOGGER = LoggerFactory.getLogger(Utils.class);

	private Utils() {
		// empty constructor
	}

	public static void switchPanes(String name, AnchorPane parentPane) {
		for (Iterator<Node> it = parentPane.getChildren().iterator(); it.hasNext();) {
			while (it.hasNext()) {
				Node node = it.next();
				if (node.getId().equals(name)) {
					node.setVisible(true);
				} else {
					node.setVisible(false);
				}
			}
		}
	}

	public static boolean isNumber(String input) {
		try {
			double d = Double.parseDouble(input);
		} catch (NumberFormatException nfe) {
			LOGGER.error("entred values {} is not numeric", input, nfe);
			return false;
		}
		LOGGER.info("entred values {} is numeric", input);
		return true;
	}
}
