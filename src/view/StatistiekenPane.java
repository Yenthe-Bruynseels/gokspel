package view;

import controller.GamblerViewController;
import controller.SpelersController;
import controller.StatistiekenController;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import model.Speler;

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
