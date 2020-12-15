package model.observer;


import model.Gokspel;
import model.Speler;

public interface Observer {
    void update(Speler speler, double inzet);
    void updateGok(String gokstrategie);
    Gokspel getModel();
}
