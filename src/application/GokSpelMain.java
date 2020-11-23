package application;

import javafx.application.Application;
import javafx.stage.Stage;
import model.Speler;
import model.database.SpelersDatabaseInMemory;
import view.AdminView;
import view.GamblerView;
import view.panels.GamblerOverviewPane;

import java.util.List;

public class GokSpelMain extends Application {

	@Override
	public void start(Stage primaryStage) {
		SpelersDatabaseInMemory sdb = new SpelersDatabaseInMemory();
		sdb.leesGegevensIn("src/bestanden/speler.txt");
		List<Speler> spelers = sdb.getSpelers();

		AdminView adminView = new AdminView();
		GamblerView gamblerView = new GamblerView();
		GamblerOverviewPane view = new GamblerOverviewPane(sdb);
		System.out.println(sdb);
	}
	
	public static void main(String[] args) {
		launch(args);

	}
}
