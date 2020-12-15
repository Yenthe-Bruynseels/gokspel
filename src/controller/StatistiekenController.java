package controller;

import javafx.collections.ObservableList;
import model.Gokspel;
import model.Speler;
import model.observer.Observer;
import view.StatistiekenPane;

public class StatistiekenController implements Observer {
    private StatistiekenPane view;
    private Gokspel gokspel;

    public StatistiekenController(Gokspel gokspel){
        setModel(gokspel);
    }

    @Override
    public void update(Speler speler, double saldo) {
        // Geen implementatie nodig
    }

    private void setModel(Gokspel gokspel) {
        this.gokspel = gokspel;
    }

    public void setView(StatistiekenPane view) {
        this.view = view;
    }
}
