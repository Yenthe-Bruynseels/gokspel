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
	private final File textfile = new File("src/bestanden/speler.txt");
	private final File xlsfile = new File("src/bestanden/speler.xls");

	@Override
	public void start(Stage primaryStage) {
		gokspel.getSpelers();
		AdminView adminView = new AdminView(gokspel);
		GamblerView gamblerView = new GamblerView(gokspel);
		GamblerOverviewPane view = new GamblerOverviewPane(gokspel);
	}
	
	public static void main(String[] args) {
		launch(args);

	}
}
