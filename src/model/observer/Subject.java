package model.observer;


import javafx.scene.Node;
import javafx.scene.text.Text;

public interface Subject {
    void notifyObservers();
    void notifyObserversGok(String gokstrategie);
    void notifyObserversWorp(Node node);
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
}
