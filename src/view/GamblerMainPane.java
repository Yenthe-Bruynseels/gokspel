package view;

import controller.GamblerViewController;
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


public class GamblerMainPane extends GridPane {

    private Label spelernaamLabel, goksaldoLabel;
    private TextField spelernaamTextField, goksaldo;
    private Button startGokspel, bevestigKeuze;
    private Text saldoText, kiesText, strategieText1, strategieText2, strategieText3, strategieText4;
    private RadioButton strategie1, strategie2, strategie3, strategie4;

    public GamblerMainPane(GamblerViewController gambie) {
        this.setPadding(new Insets(10,10,10,10));
        this.setVgap(8);
        this.setHgap(10);

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


        kiesText = new Text("Kies je gok strategie uit onderstaande lijst");
        setConstraints(kiesText,0, 4);

        strategie1 = new RadioButton("Het aantal ogen is bij elke worp een even getal");
        strategie2 = new RadioButton("De som van de ogen van alle worpen samen is 21");
        strategie3 = new RadioButton("Het aantal ogen is bij elke worp hogen dan bij de vorige worp");
        strategie4 = new RadioButton("het aantal ogen is bij minimaal 1 worp lager dan 6");
        strategieText1 = new Text("mogelijke winst is 4 x je inzet");
        strategieText2 = new Text("mogelijke winst is 5 x je inzet");
        strategieText3 = new Text("mogelijke winst is 10 x je inzet");
        strategieText4 = new Text("mogelijke winst is 1.1 x je inzet");

        setConstraints(strategie1, 0, 5);
        setConstraints(strategie2, 0, 6);
        setConstraints(strategie3, 0, 7);
        setConstraints(strategie4, 0, 8);
        setConstraints(strategieText1, 3, 5);
        setConstraints(strategieText2, 3, 6);
        setConstraints(strategieText3, 3, 7);
        setConstraints(strategieText4, 3, 8);

        this.bevestigKeuze = new Button("Bevestig je keuze");
        setConstraints(bevestigKeuze, 1, 9);


        this.getChildren().addAll(spelernaamLabel, spelernaamTextField, goksaldoLabel, goksaldo, startGokspel, saldoText, kiesText, strategie1,strategie2,strategie3,strategie4,strategieText1,strategieText2,strategieText3,strategieText4, bevestigKeuze);

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
                Speler speler = gambie.vindSpeler(spelernaamTextField.getText());
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
                gambie.setHuidigeSpeler(speler);
               /* gokspel.notifyObservers();*/
                spelernaamTextField.clear();
            }
        });

        goksaldo.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                double maxSaldo = gambie.getHuidigeSpeler().getSaldo();
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

