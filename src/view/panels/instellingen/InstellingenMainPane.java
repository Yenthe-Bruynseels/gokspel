package view.panels.instellingen;

import controller.InstellingenController;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import model.Gokspel;

public class InstellingenMainPane extends BorderPane {
    private InstellingenController instie;

    public InstellingenMainPane(InstellingenController instie) {
        setController(instie);
        this.instie.setView(this);
        TabPane tabPane = new TabPane();
        InstellingenDbPane db = new InstellingenDbPane(instie);
        Tab dbT = new Tab("Database", db);
        tabPane.getTabs().add(dbT);

        this.setCenter(tabPane);
    }

    private void setController(InstellingenController instie) {
        this.instie = instie;
    }
}
