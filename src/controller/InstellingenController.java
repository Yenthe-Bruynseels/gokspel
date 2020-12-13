package controller;

import javafx.collections.ObservableList;
import model.Gokspel;
import model.Speler;
import model.observer.Observer;
import view.GamblerView;
import view.panels.instellingen.InstellingenMainPane;

public class InstellingenController implements Observer {
    private InstellingenMainPane view;
    private Gokspel gokspel;

    public InstellingenController(Gokspel gokspel) {
        setModel(gokspel);
    }

    @Override
    public void update(String spelernaam, double saldo) {

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

    public String loadProperty(String prop) {
        return gokspel.loadProperty(prop);
    }
}
