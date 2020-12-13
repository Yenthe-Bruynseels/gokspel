package application;

import controller.*;
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

	@Override
	public void start(Stage primaryStage) {
		Gokspel gokspel = new Gokspel();

		GamblerViewController gambie = new GamblerViewController(gokspel);
		InstellingenController instie = new InstellingenController(gokspel);
		SpelersController spellie = new SpelersController(gokspel);
		SpelverloopController spellopie = new SpelverloopController(gokspel);
		StatistiekenController statie = new StatistiekenController(gokspel);

		gokspel.registerObserver(gambie);
		gokspel.registerObserver(instie);
		gokspel.registerObserver(spellie);
		gokspel.registerObserver(spellopie);
		gokspel.registerObserver(statie);

		GamblerView gamblerView = new GamblerView(gambie);
		AdminView adminView = new AdminView(instie,spellie,spellopie,statie);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
