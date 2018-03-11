package com.geenie.renting;

import javafx.application.Application;
import javafx.stage.Stage;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.geenie.renting.config.StageManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class LauncherApplication extends Application {

	private static final Logger LOGGER = LoggerFactory.getLogger(LauncherApplication.class);
	protected ConfigurableApplicationContext springContext;
	protected StageManager stageManager;

	public static void main(String[] args) {
		LOGGER.info("Launching application");
		Application.launch(args);
	}

	@Override
	public void init() throws Exception {
		LOGGER.debug("entering init method");
		springContext = springBootApplicationContext();
		LOGGER.debug("quiting init method");
	}

	@Override
	public void start(Stage stage) throws Exception {
		LOGGER.debug("entering start method");
		stageManager = springContext.getBean(StageManager.class, stage);
		displayInitialScene();
		LOGGER.debug("quiting start method");
	}

	/**
	 * Useful to override this method by sub-classes wishing to change the first
	 * Scene to be displayed on startup. Example: Functional tests on main
	 * window.
	 */
	protected void displayInitialScene() {
		stageManager.switchScene("/gui/Login.fxml");
	}

	private ConfigurableApplicationContext springBootApplicationContext() {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(LauncherApplication.class);
		String[] args = getParameters().getRaw().stream().toArray(String[]::new);
		return builder.run(args);
	}

	@Override
	public void stop() throws Exception {
		LOGGER.info("Closing application");
		springContext.close();
	}
}
