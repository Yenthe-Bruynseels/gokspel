package controller;

import javafx.collections.ObservableList;
import javafx.scene.text.Text;
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

    @Override
    public void updateGok(String gokstrategie) {
        // Geen implementatie nodig
    }

    @Override
    public void updateWorp(Text text) {
        // Geen implementatie nodig
    }

    private void setModel(Gokspel gokspel) {
        this.gokspel = gokspel;
    }

    @Override
    public Gokspel getModel() {
        return this.gokspel;
    }


    public void setView(StatistiekenPane view) {
        this.view = view;
    }
}
