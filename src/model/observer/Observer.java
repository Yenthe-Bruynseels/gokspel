package model.observer;

import javafx.collections.ObservableList;
import model.Gokspel;
import model.Speler;


public interface Observer {
    void update(ObservableList<Speler> spelers, String saldo);
}
