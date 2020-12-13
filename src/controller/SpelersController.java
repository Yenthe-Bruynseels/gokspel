package controller;

import javafx.collections.ObservableList;
import model.Gokspel;
import model.Speler;
import model.observer.Observer;
import view.GamblerView;
import view.panels.GamblerOverviewPane;

public class SpelersController implements Observer {
    private Gokspel gokspel;
    private GamblerOverviewPane view;

    public SpelersController(Gokspel gokspel) {
        setModel(gokspel);
    }

    @Override
    public void update(ObservableList<Speler> spelers, double saldo) {

    }

    private void setModel(Gokspel gokspel) {
        this.gokspel = gokspel;
    }



    public void setView(GamblerOverviewPane view) {
        this.view = view;
    }

    public ObservableList<Speler> getSpelersObserve() {
        return gokspel.getSpelersObserve();
    }

}
