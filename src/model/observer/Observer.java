package model.observer;


import javafx.scene.text.Text;
import model.Gokspel;
import model.Speler;

public interface Observer {
    void update(Speler speler, double inzet);
    void updateGok(String gokstrategie);
    void updateWorp(Text text);
    Gokspel getModel();
}
