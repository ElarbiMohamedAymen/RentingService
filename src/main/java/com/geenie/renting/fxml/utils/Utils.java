package com.geenie.renting.fxml.utils;

import java.util.Iterator;

import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

public class Utils {

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
}
