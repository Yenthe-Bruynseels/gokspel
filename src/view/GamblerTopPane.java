package view;

import javafx.geometry.Insets;

import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import model.Gokspel;
import model.Speler;


public class GamblerTopPane extends GridPane {
    private Gokspel gokspel;

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
        spelernaamTextField = new TextField("Vul hier je spelernaam in");
        setConstraints(spelernaamTextField,1,0);
        saldoText = new Text("");
        setConstraints(saldoText, 3, 0);

        goksaldoLabel = new Label("Wat is je inzet?");
        setConstraints(goksaldoLabel, 0, 1);
        goksaldo = new TextField();
        setConstraints(goksaldo, 1, 1);

        this.startGokspel = new Button("Start gokspel");
        setConstraints(startGokspel, 1, 2);


        this.getChildren().addAll(spelernaamLabel, spelernaamTextField, goksaldoLabel, goksaldo, startGokspel, saldoText);

// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//                                                  Events


        //alles invisible aangezien applicatie opent zonder ingelogde gebruiker.
        saldoText.setVisible(false);
        goksaldoLabel.setVisible(false);
        goksaldo.setVisible(false);
        startGokspel.setVisible(false);



        spelernaamTextField.setOnMouseClicked(event -> {
            spelernaamTextField.clear();
        });

        spelernaamTextField.setOnKeyReleased( event -> {
            if (event.getCode() == KeyCode.ENTER) {
                Speler speler = gokspel.vindSpeler(spelernaamTextField.getText());
                if (speler == null) {
                    Alert nietIngelogd = new Alert(Alert.AlertType.ERROR);
                    nietIngelogd.setTitle("Niet ingelogd");
                    nietIngelogd.setHeaderText("Speler niet gevonden");
                    nietIngelogd.setContentText("De ingevoerde spelernaam kan niet worden gevonden. Controleer het hoofdlettergebruik zeker!");
                    nietIngelogd.showAndWait();
                    spelernaamTextField.clear();
                } else {
                    double saldo = speler.getSaldo();
                    saldoText.setText("Je beschikbare saldo is " + saldo + " euro!");
                    saldoText.setVisible(true);
                    goksaldoLabel.setVisible(true);
                    goksaldo.setVisible(true);
                    goksaldo.requestFocus();
                }
                gokspel.setHuidigeSpeler(speler);
               /* gokspel.notifyObservers();*/
                spelernaamTextField.clear();
            }
        });

        goksaldo.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                double maxSaldo = gokspel.getHuidigeSpeler().getSaldo();
                if (maxSaldo < Double.parseDouble(goksaldo.getText())) {
                    Alert saldoOntoereikend = new Alert(Alert.AlertType.ERROR);
                    saldoOntoereikend.setTitle("Saldo ontoereikend");
                    saldoOntoereikend.setHeaderText("Saldo ontoereikend");
                    saldoOntoereikend.setContentText("Het ingegeven bedrag is hoger dan je beschikbare saldo.");
                    saldoOntoereikend.showAndWait();
                } else {
                    startGokspel.setVisible(true);
                }
            }
        });

        startGokspel.setOnMouseClicked(event -> {
            System.out.println("wollah goe gerold G");
        });

    }
}

