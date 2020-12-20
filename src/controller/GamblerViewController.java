package controller;

import javafx.scene.Node;
import model.Gokspel;
import model.Speler;
import model.gokstrategie.Gokstrategie;
import model.observer.Observer;
import view.GamblerMainPane;

/** @Authors Yenthe, Cisse, Lennert*/

public class GamblerViewController implements Observer {
    private GamblerMainPane view;
    private Gokspel gokspel;

    public GamblerViewController(Gokspel gokspel) {
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

    @Override
    public Gokspel getModel() {
        return this.gokspel;
    }

    public int werpDobbelsteen() {
        return gokspel.werpDobbelsteen();
    }

    public boolean evalueerWorp(int worp) {
        return gokspel.evalueerWorp(worp);
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

    public void verminderSaldo() {
        gokspel.verminderSaldo();
    }

    public void vermeerderSaldo() {
        gokspel.vermeerderSaldo();
    }

    public void startSpel() {
        gokspel.startSpel();
    }

    public void bevestigKeuze() {
        gokspel.bevestigKeuze();
    }

    public void vraagVerhoog() {
        gokspel.vraagVerhoog();
    }

    public double getIngezetBedrag() {
        return gokspel.getIngezetBedrag();
    }
    @Override
    public void updateReset() {
        view.updateReset();
    }


    public void saveAll() {
        gokspel.saveAll();
    }
}
