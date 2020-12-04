package view.panels.instellingen;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import model.Gokspel;

public class InstellingenMainPane extends BorderPane {


    public InstellingenMainPane(Gokspel gokspel) {
        TabPane tabPane = new TabPane();
        InstellingenDbPane db = new InstellingenDbPane(gokspel);
        Tab dbT = new Tab("Database", db);
        tabPane.getTabs().add(dbT);

        this.setCenter(tabPane);
    }
}
