package view.panels.instellingen;

import controller.InstellingenController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import model.Gokspel;
import model.database.PropertiesLoadSave;

public class InstellingenDbPane extends GridPane {
    private RadioButton file;
    private Label database = new Label("Database Instellingen:");
    private ComboBox comboBox;
    private ObservableList<String> optionsDB = FXCollections.observableArrayList(
            "txt",
            "xls"
    );
    private Button saveKnop;

    public InstellingenDbPane(InstellingenController instie) {

        ToggleGroup groep = new ToggleGroup();
        file = new RadioButton("DB in memory");
        file.setToggleGroup(groep);
        comboBox = new ComboBox<>(optionsDB);
        saveKnop = new Button("Save DB ");

        //Scherm indeling ALGEMEEN
        this.setPadding(new Insets(10,10,10,10));
        this.setVgap(8);
        this.setHgap(10);

        /*Lay-out voor DATABASE instellingen*/
        this.add(database, 1,1);
        this.add(file, 1, 3);
        this.add(comboBox, 1,4);

        //SAVE KNOP VOOR ALLE INSTELLINGEN
        this.add(saveKnop,1,6);

        if (instie.checkBestaat("DATABASE")) {
            comboBox.getSelectionModel().select(instie.loadProperty("DATABASE"));
        }

        file.setSelected(instie.loadProperty("DATABASE").equals("txt") || instie.loadProperty("DATABASE").equals("xls"));

        saveKnop.setOnAction(onClick -> {
                String database = comboBox.getValue().toString();
                PropertiesLoadSave.save(database, "DATABASE");
                Alert confirmation = new Alert(Alert.AlertType.INFORMATION);
                confirmation.setTitle("INFO");
                confirmation.setHeaderText("Wijzigingen opgeslagen");
                confirmation.setContentText("Herstart het programma om de aanpassingen toe te passen.");
                confirmation.showAndWait();
        });
    }
}
