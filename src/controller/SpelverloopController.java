package controller;

import javafx.scene.Node;
import model.Speler;
import model.observer.Observer;
import model.Gokspel;
import view.SpelverloopPane;

/** @Authors Yenthe, Cisse, Lennert*/

public class SpelverloopController implements Observer {
    private Gokspel gokspel;
    private SpelverloopPane view;

    public SpelverloopController(Gokspel gokspel){
        setModel(gokspel);
    }

    @Override
    public void update(Speler speler, double saldo) {
        view.update(speler, saldo);
    }

    @Override
    public void updateGok(String gokstrategie) {
        view.updateGok(gokstrategie);
    }

    @Override
    public void updateWorp(Node node) {
        view.updateWorp(node);
    }

    @Override
    public Gokspel getModel() {
        return this.gokspel;
    }

    public void setView(SpelverloopPane view){
        this.view = view;
    }

    private void setModel(Gokspel gokspel){
        this.gokspel = gokspel;
    }



    @Override
    public void updateReset() {
        // geen implementatie nodig
    }


}
