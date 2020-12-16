package model.observer;


import javafx.scene.text.Text;

public interface Subject {
    void notifyObservers();
    void notifyObserversGok(String gokstrategie);
    void notifyObserversWorp(Text text);
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
}
