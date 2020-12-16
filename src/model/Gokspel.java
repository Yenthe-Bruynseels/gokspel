package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.text.Text;
import model.database.PropertiesLoadSave;
import model.database.SpelersDatabaseInMemory;
import model.database.factory.LoadSaveFactory;
import model.database.strategy.LoadSaveStrategy;
import model.gokstrategie.Gokstrategie;
import model.gokstrategie.GokstrategieStrategy;
import model.gokstrategie.GokstrategieStrategyFactory;
import model.observer.Observer;
import model.observer.Subject;

import java.util.*;


public class Gokspel implements Subject {
    private SpelersDatabaseInMemory db;
    private Map<String, Speler> spelers;
    private Dobbelsteen dobbie = new Dobbelsteen();
    private GokstrategieStrategy gokstrategie;
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
    }

    public Gokstrategie[] getAlleGokstrategieën() {
        return Gokstrategie.values();
    }

    public int werpDobbelsteen() {
        return dobbie.werpDobbelsteen();
    }

    public void setStrategy(String keuze) {
        GokstrategieStrategyFactory strategyFactory = GokstrategieStrategyFactory.getInstance();
        GokstrategieStrategy strategy = strategyFactory.getStrategy(keuze);
        this.gokstrategie = strategy;
    }

    public boolean evalueerWorp(int worp) {
        return gokstrategie.evalueerGok(worp);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(huidigeSpeler,ingezetBedrag);
        }
    }

    @Override
    public void notifyObserversGok(String gokstrategie) {
        for (Observer o : observers) {
            o.updateGok(gokstrategie);
        }
    }

    @Override
    public void notifyObserversWorp(Text text) {
        for (Observer o : observers) {
            o.updateWorp(text);
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
