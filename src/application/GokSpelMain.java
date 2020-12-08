package application;

import javafx.application.Application;
import javafx.stage.Stage;
import model.Gokspel;
import model.Speler;
import model.database.SpelersDatabaseInMemory;
import view.AdminView;
import view.GamblerView;
import view.panels.GamblerOverviewPane;

import java.io.File;
import java.util.List;

public class GokSpelMain extends Application {
	private final Gokspel gokspel = new Gokspel();

	@Override
	public void start(Stage primaryStage) {
		GamblerView gamblerView = new GamblerView(gokspel);
		AdminView adminView = new AdminView(gokspel);
	}
	
	public static void main(String[] args) {
		launch(args);

	}
}
