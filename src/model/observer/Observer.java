package model.observer;

import javafx.collections.ObservableList;
import model.Gokspel;
import model.Speler;

import java.util.List;


public interface Observer {
    void update(ObservableList<Speler> spelers, double saldo);
}
