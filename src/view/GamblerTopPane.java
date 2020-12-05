package view;

import javafx.geometry.Insets;

import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import model.Gokspel;


public class GamblerTopPane extends GridPane {
    private Label spelernaamLabel, goksaldoLabel;
    private TextField spelernaamTextField, goksaldo;
    private Button startGokspel;
    private Text saldoText;

    public GamblerTopPane(Gokspel gokspel) {
        this.setPadding(new Insets(10,10,10,10));
        this.setVgap(8);
        this.setHgap(10);
        this.setStyle("-fx-border-color: black");
        this.setStyle("-fx-border-width: 1");
        this.setStyle("-fx-border-style: solid");

        spelernaamLabel = new Label("Wat is je spelersnaam?");
        setConstraints(spelernaamLabel,0,0);
        spelernaamTextField = new TextField();
        setConstraints(spelernaamTextField,1,0);
        saldoText = new Text("Je beschikbare saldo is 0 euro.");
        setConstraints(saldoText, 3, 0);

        goksaldoLabel = new Label("Wat is je inzet?");
        setConstraints(goksaldoLabel, 0, 1);
        goksaldo = new TextField();
        setConstraints(goksaldo, 1, 1);

        this.startGokspel = new Button("Start gokspel");
        setConstraints(startGokspel, 1, 2);


        this.getChildren().addAll(spelernaamLabel, spelernaamTextField, goksaldoLabel, goksaldo, startGokspel, saldoText);


    }
}

