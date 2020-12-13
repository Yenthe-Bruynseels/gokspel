package controller;

import javafx.collections.ObservableList;
import model.Gokspel;
import model.Speler;
import model.observer.Observer;
import view.GamblerView;

public class GamblerViewController implements Observer {
    private GamblerView view;
    private Gokspel gokspel;

    public GamblerViewController(Gokspel gokspel) {
        setModel(gokspel);
    }


    @Override
    public void update(ObservableList<Speler> spelers, double saldo) {

    }

    private void setModel(Gokspel gokspel) {
        this.gokspel = gokspel;
    }

    public void setView(GamblerView view) {
        this.view = view;
    }

    public Speler vindSpeler(String spelernaam) {
        return gokspel.vindSpeler(spelernaam);
    }

    public void setHuidigeSpeler(Speler huidigeSpeler) {
        gokspel.setHuidigeSpeler(huidigeSpeler);
    }

    public Speler getHuidigeSpeler() {
        return gokspel.getHuidigeSpeler();
    }
}
