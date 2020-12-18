package controller;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.text.Text;
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
    public void update(Speler speler, double saldo) {
        // Geen implementatie nodig
    }

    @Override
    public void updateGok(String gokstrategie) {
        // Geen implementatie nodig
    }

    @Override
    public void updateWorp(Text text) {
        // Geen implementatie nodig
    }

    @Override
    public Gokspel getModel() {
        return this.gokspel;
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
