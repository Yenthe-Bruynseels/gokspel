package view.panels;

import controller.InstellingenController;
import controller.SpelverloopController;
import javafx.scene.layout.GridPane;

public class SpelverloopPane extends GridPane {
    private SpelverloopController spellopie;



    public SpelverloopPane(SpelverloopController spellopie) {
        setController(spellopie);
        this.spellopie.setView(this);
    }


    private void setController(SpelverloopController spellopie) {
        this.spellopie = spellopie;
    }
}
