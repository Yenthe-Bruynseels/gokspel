package model.observer;


import javafx.scene.Node;
import javafx.scene.text.Text;
import model.Gokspel;
import model.Speler;

/** @Authors Yenthe, Cisse, Lennert*/

public interface Observer {
    void update(Speler speler, double inzet);
    void updateGok(String gokstrategie);
    void updateWorp(Node node);
    Gokspel getModel();
    void updateReset();
}
