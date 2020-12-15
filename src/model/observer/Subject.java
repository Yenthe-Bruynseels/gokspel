package model.observer;


public interface Subject {
    void notifyObservers();
    void notifyObserversGok(String gokstrategie);
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
}
