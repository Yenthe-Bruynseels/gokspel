package model;

import model.database.PropertiesLoadSave;
import model.database.SpelersDatabaseInMemory;
import model.observer.Observer;
import model.observer.Subject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class Gokspel {
    private SpelersDatabaseInMemory db;
    private Map<String, Speler> spelers;
    private Speler huidigeSpeler;
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

    /*@Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(getSpelersObserve(), getHuidigeSpeler().getSaldo());
        }
    }

    @Override
    public void registerObserver(Observer observer) {
        this.observers.add(observer);
    }*/
}
