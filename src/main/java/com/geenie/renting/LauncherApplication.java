package com.geenie.renting;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LauncherApplication extends Application {

	protected ConfigurableApplicationContext springContext;

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/gui/Login.fxml"));

		Scene scene = new Scene(root);
		primaryStage.getIcons().add(new Image("/gui/IcoPaper.png"));
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	@Override
	public void init() throws Exception {
		springContext = springBootApplicationContext();
	}

	private ConfigurableApplicationContext springBootApplicationContext() {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(LauncherApplication.class);
		String[] args = getParameters().getRaw().stream().toArray(String[]::new);
		return builder.run(args);
	}

	@Override
	public void stop() throws Exception {
		springContext.close();
	}
}
