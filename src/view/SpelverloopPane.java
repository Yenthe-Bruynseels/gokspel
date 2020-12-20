package view;

import controller.SpelverloopController;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Speler;

import java.lang.management.PlatformLoggingMXBean;

/** @Authors Yenthe, Cisse, Lennert*/

public class SpelverloopPane extends GridPane {
    private SpelverloopController spellopie;
    private int counter = 1;

    private Text spelernaamText, saldoText, gokstrategieText, counterText;
    private VBox worpenbox;


    public SpelverloopPane(SpelverloopController spellopie) {
        setController(spellopie);
        this.spellopie.setView(this);
        this.setPadding(new Insets(10,10,10,10));
        this.setVgap(8);
        this.setHgap(10);


        counterText = new Text("Dit is spel " + counter + " van de huidige sessie.");
        setConstraints(counterText, 0,0);
        spelernaamText = new Text();
        setConstraints(spelernaamText,0,1);
        saldoText = new Text();
        setConstraints(saldoText,0,2);
        gokstrategieText = new Text();
        setConstraints(gokstrategieText,0,3);

        worpenbox = new VBox();
        worpenbox.setSpacing(4);
        setConstraints(worpenbox,0,4);

        this.getChildren().addAll(spelernaamText,saldoText, gokstrategieText, worpenbox, counterText);

    }

    private void setController(SpelverloopController spellopie) {
        this.spellopie = spellopie;
    }

    public void update(Speler speler, double saldo) {
        spelernaamText.setText("De huidige speler is " + speler.getVoornaam() + " " + speler.getAchternaam() + "- Spelernaam: " + speler.getSpelernaam());
        saldoText.setText("Inzet = " + saldo);

    }

    public void updateGok(String gokstrategie) {
        gokstrategieText.setText("De gekozen gokstrategie is: " + gokstrategie);
    }

    public void updateWorp(Node node) {
        worpenbox.getChildren().add(node);
        if (worpenbox.getChildren().size() > 3) {
            //Werkt alleen op button, dus werkt alleen op de reset button
            worpenbox.getChildren().get(worpenbox.getChildren().size()-2).setOnMouseClicked(event -> {
                counter++;
                spellopie.getModel().notifyObserversReset();
                counterText.setText("Dit is spel " + counter + " van de huidige sessie.");
                spelernaamText.setText("");
                saldoText.setText("");
                gokstrategieText.setText("");
                worpenbox.getChildren().clear();
            });
            worpenbox.getChildren().get(worpenbox.getChildren().size()-1).setOnMouseClicked(event -> {
                Platform.exit();
            });
        }

    }


}
