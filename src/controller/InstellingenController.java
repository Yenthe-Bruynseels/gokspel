package controller;

import javafx.scene.Node;
import model.Gokspel;
import model.Speler;
import model.gokstrategie.Gokstrategie;
import model.observer.Observer;
import view.panels.InstellingenMainPane;

public class InstellingenController implements Observer {
    private InstellingenMainPane view;
    private Gokspel gokspel;

    public InstellingenController(Gokspel gokspel) {
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

    @Override
    public void updateReset() {
        view.updateReset();
    }

    public Gokstrategie[] getAlleGokstrategieën() {
        return gokspel.getAlleGokstrategieën();
    }


    private void setModel(Gokspel gokspel) {
        this.gokspel = gokspel;
    }

    public void setView(InstellingenMainPane view) {
        this.view = view;
    }

    public boolean checkBestaat(String prop) {
        return gokspel.checkBestaat(prop);
    }

    public void pasAanEnum(String keuze) {
        gokspel.pasAanEnum(keuze);
    }
}
