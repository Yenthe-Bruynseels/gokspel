package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.database.PropertiesLoadSave;
import model.database.SpelersDatabaseInMemory;
import model.observer.Observer;
import model.observer.Subject;

import java.util.*;


public class Gokspel implements Subject {
    private SpelersDatabaseInMemory db;
    private Map<String, Speler> spelers;
    private Speler huidigeSpeler;
    private double ingezetBedrag;
    private List<Observer> observers = new ArrayList<Observer>();


    public Gokspel(){
        setDb(new SpelersDatabaseInMemory());
        this.spelers = new HashMap<>();
        spelers.putAll(this.db.getAll("speler." + PropertiesLoadSave.load("DATABASE")));
    }

    public Speler vindSpeler(String spelernaam) {
        if(spelernaam == null || spelernaam.trim().isEmpty()) throw new DomainException("Je geeft een lege spelernaam mee.");
        return spelers.get(spelernaam);
    }

    private void setDb( SpelersDatabaseInMemory db) {
        this.db = db;
    }

    public Map<String, Speler> getSpelers() {
        return spelers;
    }

    public ObservableList<Speler> getSpelersObserve(){
        return FXCollections.observableArrayList(getSpelers().values());
    }

    public boolean checkBestaat(String prop) {
       return  PropertiesLoadSave.propertyBestaat(prop);
    }

    public String loadProperty(String prop){
        return PropertiesLoadSave.load(prop);
    }

    public Speler getHuidigeSpeler() {
        return huidigeSpeler;
    }

    public void setHuidigeSpeler(Speler huidigeSpeler) {
        this.huidigeSpeler = huidigeSpeler;
    }

    public double getIngezetBedrag() {
        return ingezetBedrag;
    }

    public void setIngezetBedrag(double ingezetBedrag) {
        this.ingezetBedrag = ingezetBedrag;
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(huidigeSpeler.getSpelernaam(),ingezetBedrag);
        }
    }

    @Override
    public void registerObserver(Observer observer) {
            observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
}
