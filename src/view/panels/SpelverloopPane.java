package view.panels;

import controller.SpelverloopController;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.Speler;

public class SpelverloopPane extends GridPane {
    private SpelverloopController spellopie;

    private Text spelernaamText, saldoText, gokstrategieText;
    private VBox worpenbox;


    public SpelverloopPane(SpelverloopController spellopie) {
        setController(spellopie);
        this.spellopie.setView(this);
        this.setPadding(new Insets(10,10,10,10));
        this.setVgap(8);
        this.setHgap(10);

        spelernaamText = new Text();
        setConstraints(spelernaamText,0,0);
        saldoText = new Text();
        setConstraints(saldoText,0,1);
        gokstrategieText = new Text();
        setConstraints(gokstrategieText,0,2);

        worpenbox = new VBox();
        worpenbox.setSpacing(4);
        setConstraints(worpenbox,0,3);

        this.getChildren().addAll(spelernaamText,saldoText, gokstrategieText, worpenbox);
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

    public void updateWorp(Text text) {
        worpenbox.getChildren().add(text);
    }
}
