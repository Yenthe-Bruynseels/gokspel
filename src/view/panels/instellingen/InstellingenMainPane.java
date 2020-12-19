package view.panels.instellingen;

import controller.InstellingenController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import model.database.PropertiesLoadSave;
import model.gokstrategie.Gokstrategie;

public class InstellingenMainPane extends GridPane {
    private String keuze = PropertiesLoadSave.load("GOKSTRATEGIEEN");
    private InstellingenController instie;
    private RadioButton file;
    private Label database = new Label("Database Instellingen:");
    private ComboBox comboBox;
    private ObservableList<String> optionsDB = FXCollections.observableArrayList(
            "txt",
            "xls"
    );
    private Button saveKnop;
    private VBox gokstrategieënGroep, winstfactorGroep;

    private Button slaOp;
    private Label winstfactorLabel;


    public InstellingenMainPane(InstellingenController instie) {
        this.setController(instie);
        this.instie.setView(this);

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
        this.add(database, 0,1);
        this.add(file, 0, 3);
        this.add(comboBox, 0,4);

        //SAVE KNOP VOOR ALLE INSTELLINGEN
        this.add(saveKnop,0,6);

        if (PropertiesLoadSave.propertyBestaat("DATABASE")) {
            comboBox.getSelectionModel().select(PropertiesLoadSave.load("DATABASE"));
        }

        file.setSelected(PropertiesLoadSave.load("DATABASE").equals("txt") || PropertiesLoadSave.load("DATABASE").equals("xls"));

        saveKnop.setOnAction(onClick -> {
            String database = comboBox.getValue().toString();
            PropertiesLoadSave.save(database, "DATABASE");
            Alert confirmation = new Alert(Alert.AlertType.INFORMATION);
            confirmation.setTitle("INFO");
            confirmation.setHeaderText("Wijzigingen opgeslagen");
            confirmation.setContentText("Herstart het programma om de aanpassingen toe te passen.");
            confirmation.showAndWait();
        });

//-----------------------------------------------------Gokstrategieën keuze----------------------------------------------------------------------------//


        gokstrategieënGroep = new VBox();
        gokstrategieënGroep.setSpacing(11);
        gokstrategieënGroep.getChildren().add(new Label("Gokstrategieën"));
        for (Gokstrategie gok : instie.getAlleGokstrategieën()) {
            RadioButton radioButton = new RadioButton(gok.getVolledigUitleg());
            if (gok.getActief()) {
                radioButton.fire();
            }
            gokstrategieënGroep.getChildren().add(radioButton);
        }
        slaOp = new Button("Save actieve strategieën");
        gokstrategieënGroep.getChildren().add(slaOp);
        setConstraints(gokstrategieënGroep, 0, 8);
        winstfactorLabel = new Label("Winstfactor");
        winstfactorGroep = new VBox();
        winstfactorGroep.setSpacing(4);
        winstfactorGroep.getChildren().add(winstfactorLabel);
        for (Gokstrategie gok : instie.getAlleGokstrategieën()) {
            TextField text = new TextField(Double.toString(gok.getWinstfactor()));
            text.setPrefWidth(20);
            winstfactorGroep.getChildren().add(text);
        }
        setConstraints(winstfactorGroep, 2, 8);
        this.getChildren().addAll(gokstrategieënGroep, winstfactorGroep);

        slaOp.setOnMouseClicked(event -> {
            resetKeuze();
            for (int i=1; i<winstfactorGroep.getChildren().size() ;i++) {
                keuze += instie.getAlleGokstrategieën()[i-1] + "," + ((TextField) winstfactorGroep.getChildren().get(i)).getText() + "," + ((RadioButton) gokstrategieënGroep.getChildren().get(i)).isSelected() + ";";
            }
            PropertiesLoadSave.save(keuze,"GOKSTRATEGIEEN");
        });
    }

    private void setController(InstellingenController instie) {
        this.instie = instie;
    }

    private void resetKeuze() {
        System.out.println(keuze);
        this.keuze = "";
    }

    public void updateReset() {
        instie.pasAanEnum(keuze);
    }
}
