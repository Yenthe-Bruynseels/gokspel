package view;

import controller.StatistiekenController;
import javafx.scene.layout.GridPane;

/** @Authors Yenthe, Cisse, Lennert*/

public class StatistiekenPane extends GridPane {
    private StatistiekenController statie;

    public StatistiekenPane(StatistiekenController statie){
        setController(statie);
        this.statie.setView(this);
    }

    private void setController(StatistiekenController statie) {
        this.statie = statie;
    }
}
