package view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import model.Gokspel;


public class GamblerMiddlePane extends GridPane {
    private Label spelernaamLabel, goksaldoLabel;
    private TextField spelernaamTextField, goksaldo;
    private Button startGokspel, bevestigKeuze, werpDobbelsteen;
    private Text saldoText, kiesText, strategieText1, strategieText2, strategieText3, strategieText4;
    private RadioButton strategie1, strategie2, strategie3, strategie4;

    public GamblerMiddlePane(Gokspel gokspel) {
        this.setPadding(new Insets(10,10,10,10));
        this.setVgap(8);
        this.setHgap(10);
        this.setStyle("-fx-border-color: black");
        this.setStyle("-fx-border-width: 1");
        this.setStyle("-fx-border-style: solid");

        kiesText = new Text("Kies je gok strategie uit onderstaande lijst");
        setConstraints(kiesText,0, 0);

        strategie1 = new RadioButton("Het aantal ogen is bij elke worp een even getal");
        strategie2 = new RadioButton("De som van de ogen van alle worpen samen is 21");
        strategie3 = new RadioButton("Het aantal ogen is bij elke worp hogen dan bij de vorige worp");
        strategie4 = new RadioButton("het aantal ogen is bij minimaal 1 worp lager dan 6");
        strategieText1 = new Text("mogelijke winst is 4 x je inzet");
        strategieText2 = new Text("mogelijke winst is 5 x je inzet");
        strategieText3 = new Text("mogelijke winst is 10 x je inzet");
        strategieText4 = new Text("mogelijke winst is 1.1 x je inzet");

        setConstraints(strategie1, 0, 1);
        setConstraints(strategie2, 0, 2);
        setConstraints(strategie3, 0, 3);
        setConstraints(strategie4, 0, 4);
        setConstraints(strategieText1, 3, 1);
        setConstraints(strategieText2, 3, 2);
        setConstraints(strategieText3, 3, 3);
        setConstraints(strategieText4, 3, 4);


        this.bevestigKeuze = new Button("Bevestig je keuze");
        setConstraints(bevestigKeuze, 1, 9);



        this.getChildren().addAll(kiesText, strategie1,strategie2,strategie3,strategie4,strategieText1,strategieText2,strategieText3,strategieText4, bevestigKeuze);


    }
}

