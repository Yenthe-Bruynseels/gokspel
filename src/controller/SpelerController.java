package controller;

import javafx.collections.ObservableList;
import model.Gokspel;
import model.Speler;
import model.observer.Observer;
import view.panels.GamblerOverviewPane;

public class SpelerController implements Observer {
    private GamblerOverviewPane gamblerOverviewPane;
    private Gokspel gokspel;

    public SpelerController(Gokspel gokspel, GamblerOverviewPane gamblerOverviewPane){
        setGokspel(gokspel);
        this.gamblerOverviewPane = gamblerOverviewPane;
    }

    @Override
    public void update(ObservableList<Speler> spelers, String saldo) {

    }


    public void setGokspel(Gokspel gokspel) {
        this.gokspel = gokspel;
    }

    public void setGamblerOverviewPane(GamblerOverviewPane gamblerOverviewPane) {
        this.gamblerOverviewPane = gamblerOverviewPane;
    }
}
