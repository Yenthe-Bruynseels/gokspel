package view;


import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import model.database.SpelersDatabaseInMemory;
import view.panels.GamblerOverviewPane;
import model.Gokspel;

public class AdminMainPane extends BorderPane {


	public AdminMainPane(Gokspel gokspel){
	    TabPane tabPane = new TabPane(); 	    
        Tab spelVerloopTab = new Tab("Spelverloop");
        GamblerOverviewPane gamblerOverviewPane = new GamblerOverviewPane(gokspel);
        Tab spelerTab = new Tab("Spelers",gamblerOverviewPane);
        Tab instellingTab = new Tab("Instellingen");
        Tab statistiekTab = new Tab("Statistieken");
        tabPane.getTabs().add(spelVerloopTab);
        tabPane.getTabs().add(spelerTab);
        tabPane.getTabs().add(statistiekTab);
        tabPane.getTabs().add(instellingTab);
        this.setCenter(tabPane);
	}
}
