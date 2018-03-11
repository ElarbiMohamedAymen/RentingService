package com.geenie.renting.config;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Manages switching Scenes on the Primary Stage
 */
public class StageManager {

	private static final Logger LOG = LoggerFactory.getLogger(StageManager.class);
	private final Stage primaryStage;
	private final SpringFXMLLoader springFXMLLoader;

	public StageManager(SpringFXMLLoader springFXMLLoader, Stage stage) {
		this.springFXMLLoader = springFXMLLoader;
		this.primaryStage = stage;
	}

	public void switchScene(final String view) {
		Parent viewRootNodeHierarchy = loadViewNodeHierarchy(view);
		show(viewRootNodeHierarchy);
	}

	private void show(final Parent rootnode) {
		Scene scene = prepareScene(rootnode);
		primaryStage.setTitle("Renting Service");
		primaryStage.setScene(scene);
		primaryStage.sizeToScene();
		primaryStage.centerOnScreen();

		try {
			primaryStage.show();
		} catch (Exception exception) {
			logAndExit("", exception);
		}
	}

	private Scene prepareScene(Parent rootnode) {
		Scene scene = primaryStage.getScene();

		if (scene == null) {
			scene = new Scene(rootnode);
		}
		scene.setRoot(rootnode);
		return scene;
	}

	/**
	 * Loads the object hierarchy from a FXML document and returns to root node
	 * of that hierarchy.
	 *
	 * @return Parent root node of the FXML document hierarchy
	 */
	private Parent loadViewNodeHierarchy(String fxmlFilePath) {
		Parent rootNode = null;
		try {
			rootNode = springFXMLLoader.load(fxmlFilePath);
			Objects.requireNonNull(rootNode, "A Root FXML node must not be null");
		} catch (Exception exception) {
			logAndExit("Unable to load FXML view" + fxmlFilePath, exception);
		}
		return rootNode;
	}

	private void logAndExit(String errorMsg, Exception exception) {
		LOG.error(errorMsg, exception, exception.getCause());
		Platform.exit();
	}

}
