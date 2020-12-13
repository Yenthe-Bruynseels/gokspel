package view.panels;

import controller.SpelverloopController;
import javafx.scene.layout.GridPane;

public class SpelverloopPane extends GridPane {



    public SpelverloopPane(SpelverloopController spellopie) {
        setController(spellopie);
        this.spellopie.setView(this);
    }
}
