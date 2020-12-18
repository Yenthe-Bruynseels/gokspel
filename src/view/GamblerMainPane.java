package view;

import controller.GamblerViewController;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

import model.Speler;
import model.gokstrategie.Gokstrategie;


public class GamblerMainPane extends GridPane {
    private GamblerViewController gambie;

    private Label spelernaamLabel, goksaldoLabel, kiesLabel, rendementLabel, verhoogLabel;
    private TextField spelernaamTextField, goksaldo, verhoogSaldo;
    private Button startGokspel, bevestigKeuze, werpDobbelsteen;
    private Text saldoText;
    private VBox gokstrategieënGroep, rendementGroep, worpenbox;
    private ToggleGroup toggleGroep;
    private int counter = 0;

    public GamblerMainPane(GamblerViewController gambie) {
        setController(gambie);
        this.gambie.setView(this);
        this.setPadding(new Insets(10, 10, 10, 10));
        this.setVgap(8);
        this.setHgap(10);

        spelernaamLabel = new Label("Wat is je spelersnaam?");
        setConstraints(spelernaamLabel, 0, 0);
        spelernaamTextField = new TextField("Vul hier je spelernaam in");
        setConstraints(spelernaamTextField, 1, 0);
        saldoText = new Text("");
        setConstraints(saldoText, 3, 0);

        goksaldoLabel = new Label("Wat is je inzet?");
        setConstraints(goksaldoLabel, 0, 1);
        goksaldo = new TextField();
        setConstraints(goksaldo, 1, 1);

        this.startGokspel = new Button("Start gokspel");
        setConstraints(startGokspel, 1, 2);

        kiesLabel = new Label("Kies je gok strategie uit onderstaande lijst");
        gokstrategieënGroep = new VBox();
        gokstrategieënGroep.setSpacing(4);
        toggleGroep = new ToggleGroup();
        gokstrategieënGroep.getChildren().add(kiesLabel);
        for (Gokstrategie gok : gambie.getAlleGokstrategieën()) {
            RadioButton radioButton = new RadioButton(gok.getVolledigUitleg());
            radioButton.setToggleGroup(toggleGroep);
            gokstrategieënGroep.getChildren().add(radioButton);
        }
        toggleGroep.getToggles().get(0).setSelected(true);
        bevestigKeuze = new Button("Bevestig je keuze  ");
        gokstrategieënGroep.getChildren().add(bevestigKeuze);
        setConstraints(gokstrategieënGroep, 0, 3);
        rendementLabel = new Label("Mogelijke winst");
        rendementGroep = new VBox();
        rendementGroep.setSpacing(4);
        rendementGroep.getChildren().add(rendementLabel);
        for (Gokstrategie gok : gambie.getAlleGokstrategieën()) {
            Text text = new Text(Double.toString(gok.getRendement()) + "x inzet");
            rendementGroep.getChildren().add(text);
        }
        setConstraints(rendementGroep, 2, 3);

        werpDobbelsteen = new Button("Werp dobbelsteen");
        setConstraints(werpDobbelsteen, 0, 4);

        worpenbox = new VBox();
        worpenbox.setSpacing(4);

        verhoogLabel = new Label("Inzet verhogen? 0 = Nee, 10 = Max, ENTER = OK");
        verhoogSaldo = new TextField();

        this.getChildren().addAll(spelernaamLabel, spelernaamTextField, goksaldoLabel, goksaldo, startGokspel, saldoText, gokstrategieënGroep, rendementGroep, werpDobbelsteen, worpenbox);

// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//                                                  Events

        spelernaamTextField.setOnMouseClicked(event -> {
            spelernaamTextField.clear();
        });

        //alles invisible aangezien applicatie opent zonder ingelogde gebruiker.
        startSpelVisibilities();

        inlogActivatie();

        goksaldoInzet();

        startGokspel();

        bevestigKeuze();

        werpDobbelsteen();
    }

    private void startSpelVisibilities() {
        saldoText.setVisible(false);
        goksaldoLabel.setVisible(false);
        goksaldo.setVisible(false);
        startGokspel.setVisible(false);
        gokstrategieënGroep.setVisible(false);
        rendementGroep.setVisible(false);
        werpDobbelsteen.setVisible(false);
        worpenbox.setVisible(false);
    }

    private void inlogActivatie() {
        spelernaamTextField.setOnKeyReleased(event -> {
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
                spelernaamTextField.clear();
            }
        });
    }

    private void goksaldoInzet() {
        goksaldo.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                double maxSaldo = gambie.getHuidigeSpeler().getSaldo();
                double ingezetBedrag = Double.parseDouble(goksaldo.getText());
                if (maxSaldo < ingezetBedrag) {
                    Alert saldoOntoereikend = new Alert(Alert.AlertType.ERROR);
                    saldoOntoereikend.setTitle("Saldo ontoereikend");
                    saldoOntoereikend.setHeaderText("Saldo ontoereikend");
                    saldoOntoereikend.setContentText("Het ingegeven bedrag is hoger dan je beschikbare saldo.");
                    saldoOntoereikend.showAndWait();
                } else {
                    gambie.setIngezetBedrag(ingezetBedrag);
                    gambie.getModel().notifyObservers();
                    startGokspel.setVisible(true);
                }
            }
        });
    }

    private void startGokspel() {
        startGokspel.setOnMouseClicked(event -> {
            gokstrategieënGroep.setVisible(true);
            rendementGroep.setVisible(true);
            gambie.startSpel();
        });
    }

    private void bevestigKeuze() {
        bevestigKeuze.setOnMouseClicked(event -> {
            RadioButton geselecteerdeButton = (RadioButton) toggleGroep.getSelectedToggle();
            String geselecteerdeGokstrategie = geselecteerdeButton.getText();
            gambie.getModel().notifyObserversGok(geselecteerdeGokstrategie);
            gambie.getModel().setStrategy(geselecteerdeGokstrategie);
            gambie.bevestigKeuze();

            werpDobbelsteen.setVisible(true);
            // na bevestiging keuze is aanpassing niet meer mogelijk
            spelernaamTextField.setOnKeyReleased(null);
            goksaldo.setOnKeyReleased(null);
            startGokspel.setOnMouseClicked(null);
            bevestigKeuze.setOnMouseClicked(null);
        });
    }

    private void werpDobbelsteen() {

        werpDobbelsteen.setOnMouseClicked(event -> {

            worpenbox.setVisible(true);
            setConstraints(worpenbox, 0, 5);

            int worp = gambie.werpDobbelsteen();
            boolean kanWinnen = gambie.evalueerWorp(worp);
            counter++;
            Text worpText = new Text("worp" + counter + ": " + worp);
            //Om de een of andere reden, mag je de Text niet rechtstreeks doorgeven. Dan update hij alleen in het spelverlooptab, vandaar wordt een 2e versie aangemaakt
            Text worpText2 = new Text(worpText.getText());
            worpenbox.getChildren().add(worpText);
            gambie.getModel().notifyObserversWorp(worpText2);

            if (!kanWinnen) {
                werpDobbelsteen.setOnMouseClicked(null);
                System.out.println("haha loser");
                Text verlorenText = new Text("Je hebt verloren");
                worpenbox.getChildren().add(verlorenText);
                //Om de een of andere reden, mag je de Text niet rechtstreeks doorgeven. Dan update hij alleen in het spelverlooptab, vandaar wordt een 2e versie aangemaakt
                Text verlorenText2 = new Text(verlorenText.getText());
                gambie.verminderSaldo();
                gambie.getModel().notifyObserversWorp(verlorenText2);
                gambie.getModel().notifyObserversWorp(new Button("Reset game"));
            } else {
                if (counter == 2) {
                    gambie.vraagVerhoog();
                    worpenbox.getChildren().addAll(verhoogLabel, verhoogSaldo);
                    verhoogSaldo.setOnKeyReleased(event1 -> {
                        if (event1.getCode() == KeyCode.ENTER) {
                            double maxSaldo = gambie.getHuidigeSpeler().getSaldo() - gambie.getIngezetBedrag();
                            double verhoging = Double.parseDouble(verhoogSaldo.getText());
                            if (verhoging > 10) {
                                Alert verhogingTeGroot = new Alert(Alert.AlertType.ERROR);
                                verhogingTeGroot.setTitle("Verhoging te groot");
                                verhogingTeGroot.setHeaderText("Verhoging te groot");
                                verhogingTeGroot.setContentText("De maximale verhoging bedraagt 10 euro.");
                                verhogingTeGroot.showAndWait();
                            } else if (verhoging < 0) {
                                Alert magNietVerlagen = new Alert(Alert.AlertType.ERROR);
                                magNietVerlagen.setTitle("Mag inzet niet verlagen");
                                magNietVerlagen.setHeaderText("Mag inzet niet verlagen");
                                magNietVerlagen.setContentText("De inzet mag uitsluitend onveranderd blijven of met maximaal 10 euro verhoogd worden. Niet verlaagd.");
                                magNietVerlagen.showAndWait();
                            } else if (maxSaldo < verhoging) {
                                Alert saldoOntoereikend = new Alert(Alert.AlertType.ERROR);
                                saldoOntoereikend.setTitle("Saldo ontoereikend");
                                saldoOntoereikend.setHeaderText("Saldo ontoereikend");
                                saldoOntoereikend.setContentText("Het ingegeven bedrag is hoger dan je beschikbare saldo.");
                                saldoOntoereikend.showAndWait();
                            } else {
                                gambie.setIngezetBedrag(verhoging);
                                gambie.getModel().notifyObservers();
                                worpenbox.getChildren().removeAll(verhoogSaldo, verhoogLabel);
                            }
                        }
                    });
                }

                if (counter == 4) {
                    werpDobbelsteen.setOnMouseClicked(null);
                    Text gewonnenText = new Text("Je hebt gewonnen");
                    //Om de een of andere reden, mag je de Text niet rechtstreeks doorgeven. Dan update hij alleen in het spelverlooptab, vandaar wordt een 2e versie aangemaakt
                    Text gewonnenText2 = new Text(gewonnenText.getText());
                    worpenbox.getChildren().add(gewonnenText);
                    gambie.vermeerderSaldo();
                    gambie.getModel().notifyObserversWorp(gewonnenText2);
                    gambie.getModel().notifyObserversWorp(new Button("Reset game"));
                }
            }

        });
    }

    public void updateReset() {
            gambie.getModel().setState(gambie.getModel().getWait());
            startSpelVisibilities();
            inlogActivatie();
            goksaldoInzet();
            startGokspel();
            bevestigKeuze();
            counter = 0;
            worpenbox.getChildren().clear();
            toggleGroep.getToggles().get(0).setSelected(true);
            verhoogSaldo.clear();
            werpDobbelsteen();
        }

    private void setController(GamblerViewController gambie) {
        this.gambie = gambie;
    }
}

