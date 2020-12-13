package controller;

import javafx.collections.ObservableList;
import model.Speler;
import model.observer.Observer;
import model.Gokspel;
import view.panels.SpelverloopPane;

public class SpelverloopController implements Observer {
    private Gokspel gokspel;
    private SpelverloopPane view;

    public SpelverloopController(Gokspel gokspel){
        setModel(gokspel);
    }

    @Override
    public void update(ObservableList<Speler> spelers, double saldo) {

    }

    public void setView(SpelverloopPane view){
        this.view = view;
    }


    private void setModel(Gokspel gokspel){
        this.gokspel = gokspel;
    }
}
