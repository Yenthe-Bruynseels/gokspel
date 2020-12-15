package controller;

import javafx.collections.ObservableList;
import model.Gokspel;
import model.Speler;
import model.gokstrategie.Gokstrategie;
import model.observer.Observer;
import view.GamblerMainPane;

import java.util.List;


public class GamblerViewController implements Observer {
    private GamblerMainPane view;
    private Gokspel gokspel;

    public GamblerViewController(Gokspel gokspel) {
        setModel(gokspel);
    }


    @Override
    public void update(String spelernaam, double saldo) {

    }

    @Override
    public void updateGok(String gokstrategie) {

    }

    @Override
    public Gokspel getModel() {
        return this.gokspel;
    }


    private void setModel(Gokspel gokspel) {
        this.gokspel = gokspel;
    }

    public void setView(GamblerMainPane view) {
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

    public void setIngezetBedrag(double saldo) {
        gokspel.setIngezetBedrag(saldo);
    }

    public Gokstrategie[] getAlleGokstrategieën() {
        return gokspel.getAlleGokstrategieën();
    }
}
