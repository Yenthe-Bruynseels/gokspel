package view.panels;


import controller.SpelersController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import model.Gokspel;
import model.Speler;
import model.database.SpelersDatabaseInMemory;

import java.util.List;


public class GamblerOverviewPane extends GridPane {
    private TableView<Speler> table;
    private SpelersController spellie;

    public GamblerOverviewPane(SpelersController spellie) {
        setController(spellie);
        this.spellie.setView(this);
        this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);
        this.add(new Label("Spelers:"), 0, 0, 1, 1);

        table = new TableView<Speler>();

        TableColumn<Speler, String> colSpelernaam = new TableColumn<Speler, String>("Spelernaam");
        colSpelernaam.setMinWidth(125);
        colSpelernaam.setCellValueFactory(new PropertyValueFactory<Speler, String>("spelernaam"));

        TableColumn<Speler, String> colAchternaam = new TableColumn<Speler, String>("Achternaam");
        colAchternaam.setMinWidth(125);
        colAchternaam.setCellValueFactory(new PropertyValueFactory<Speler, String>("achternaam"));

        TableColumn<Speler, String> colVoornaam = new TableColumn<Speler, String>("Voornaam");
        colVoornaam.setMinWidth(125);
        colVoornaam.setCellValueFactory(new PropertyValueFactory<Speler, String>("voornaam"));

        TableColumn<Speler, Double> colSaldo = new TableColumn<Speler, Double>("Saldo");
        colSaldo.setMinWidth(125);
        colSaldo.setCellValueFactory(new PropertyValueFactory<Speler, Double>("saldo"));

        table.getColumns().addAll(colSpelernaam, colAchternaam, colVoornaam, colSaldo);
        table.getItems().addAll(spellie.getSpelersObserve());
        table.getSortOrder().add(colSpelernaam);

        this.getChildren().add(table);
    }

    private void setController(SpelersController spellie) {
        this.spellie = spellie;
    }

    private void refresh() {
        //
    }
}
