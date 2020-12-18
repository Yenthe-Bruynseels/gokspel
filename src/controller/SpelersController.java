package controller;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.text.Text;
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
    public void update(Speler speler, double saldo) {
        // Geen implementatie nodig
    }

    @Override
    public void updateGok(String gokstrategie) {
        // Geen implementatie nodig
    }

    @Override
    public void updateWorp(Node node) {
        view.refresh();
    }

    @Override
    public Gokspel getModel() {
        return this.gokspel;
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

    @Override
    public void updateReset() {
        // geen implementatie nodig
    }

}
