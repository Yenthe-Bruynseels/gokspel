package controller;

import javafx.scene.Node;
import model.Gokspel;
import model.Speler;
import model.observer.Observer;
import view.StatistiekenPane;

/** @Authors Yenthe, Cisse, Lennert*/

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

    @Override
    public void updateGok(String gokstrategie) {
        // Geen implementatie nodig
    }

    @Override
    public void updateWorp(Node node) {
        // Geen implementatie nodig
    }

    private void setModel(Gokspel gokspel) {
        this.gokspel = gokspel;
    }

    @Override
    public Gokspel getModel() {
        return this.gokspel;
    }

    @Override
    public void updateReset() {
        // geen implementatie nodig
    }


    public void setView(StatistiekenPane view) {
        this.view = view;
    }

}
