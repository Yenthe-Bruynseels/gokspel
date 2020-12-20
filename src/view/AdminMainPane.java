package view;


import controller.InstellingenController;
import controller.SpelersController;
import controller.SpelverloopController;
import controller.StatistiekenController;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import view.panels.GamblerOverviewPane;
import view.panels.SpelverloopPane;
import view.panels.InstellingenMainPane;

public class AdminMainPane extends BorderPane {


	public AdminMainPane(InstellingenController instie, SpelersController spellie, SpelverloopController spellopie, StatistiekenController statie){
	    TabPane tabPane = new TabPane();
	    SpelverloopPane spelverloopPane = new SpelverloopPane(spellopie);
        Tab spelVerloopTab = new Tab("Spelverloop", spelverloopPane);
        GamblerOverviewPane gamblerOverviewPane = new GamblerOverviewPane(spellie);
        Tab spelerTab = new Tab("Spelers",gamblerOverviewPane);
        InstellingenMainPane instellingPane = new InstellingenMainPane(instie);
        Tab instellingTab = new Tab("Instellingen", instellingPane);
        StatistiekenPane statistiekenPane = new StatistiekenPane(statie);
        Tab statistiekTab = new Tab("Statistieken", statistiekenPane);


        tabPane.getTabs().add(spelVerloopTab);
        tabPane.getTabs().add(spelerTab);
        tabPane.getTabs().add(statistiekTab);
        tabPane.getTabs().add(instellingTab);
        this.setCenter(tabPane);
	}
}
