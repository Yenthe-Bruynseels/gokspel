package view.panels.instellingen;

import controller.InstellingenController;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import model.Gokspel;

public class InstellingenMainPane extends BorderPane {


    public InstellingenMainPane(InstellingenController instellie) {
        TabPane tabPane = new TabPane();
        InstellingenDbPane db = new InstellingenDbPane(instellie);
        Tab dbT = new Tab("Database", db);
        tabPane.getTabs().add(dbT);

        this.setCenter(tabPane);
    }
}
