package view.panels;

import controller.SpelverloopController;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class SpelverloopPane extends GridPane {
    private SpelverloopController spellopie;

    private Text spelernaamText, saldoText;


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

        this.getChildren().addAll(spelernaamText,saldoText);
    }


    private void setController(SpelverloopController spellopie) {
        this.spellopie = spellopie;
    }

    public void update(String spelernaam, double saldo) {
        spelernaamText.setText(spelernaam);
        saldoText.setText(Double.toString(saldo));
    }
}
