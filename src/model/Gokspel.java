package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.text.Text;
import model.database.PropertiesLoadSave;
import model.database.SpelersDatabaseInMemory;
import model.gokstrategie.Gokstrategie;
import model.gokstrategie.GokstrategieStrategy;
import model.gokstrategie.GokstrategieStrategyFactory;
import model.observer.Observer;
import model.observer.Subject;
import model.state.*;

import java.util.*;


public class Gokspel implements Subject {
    private State choose, play, wait, verhoogInzet, currentState;
    private SpelersDatabaseInMemory db;
    private Map<String, Speler> spelers;
    private Dobbelsteen dobbie = new Dobbelsteen();
    private GokstrategieStrategy gokstrategie;
    private Speler huidigeSpeler;
    private double ingezetBedrag;
    private List<Observer> observers = new ArrayList<Observer>();


    public Gokspel() {
        setDb(new SpelersDatabaseInMemory());
        this.spelers = new HashMap<>();
        spelers.putAll(this.db.getAll("speler." + PropertiesLoadSave.load("DATABASE")));
        choose = new Choose(this);
        wait = new Wait(this);
        play = new Play(this);
        verhoogInzet = new VerhoogInzet(this);
        currentState = wait;
    }

    public Speler vindSpeler(String spelernaam) {
        if (spelernaam == null || spelernaam.trim().isEmpty())
            throw new DomainException("Je geeft een lege spelernaam mee.");
        return spelers.get(spelernaam);
    }

    private void setDb(SpelersDatabaseInMemory db) {
        this.db = db;
    }

    public Map<String, Speler> getSpelers() {
        return spelers;
    }

    public ObservableList<Speler> getSpelersObserve() {
        return FXCollections.observableArrayList(getSpelers().values());
    }

    public boolean checkBestaat(String prop) {
        return PropertiesLoadSave.propertyBestaat(prop);
    }

    public String loadProperty(String prop) {
        return PropertiesLoadSave.load(prop);
    }

    public Speler getHuidigeSpeler() {
        return huidigeSpeler;
    }

    public void setHuidigeSpeler(Speler huidigeSpeler) {
        if (currentState == wait) {
            this.huidigeSpeler = huidigeSpeler;
        } else {
            throw new IllegalArgumentException("Kan nu niet inloggen.");
        }
    }


    public double getIngezetBedrag() {
        return ingezetBedrag;
    }

/*    public void verminderSaldo() {
        huidigeSpeler.verminderSaldo(this.ingezetBedrag);
    }

    public void vermeerderSaldo() {
        huidigeSpeler.vermeerderSaldo(gokstrategie.getWinstfactor(), this.ingezetBedrag);
    }*/


    public void verminderSaldo() {
        this.currentState.verminderSaldo(this.ingezetBedrag);
    }


    public void vermeerderSaldo() {
        this.currentState.vermeerderSaldo(gokstrategie.getWinstfactor(), this.ingezetBedrag);
    }


    public void setIngezetBedrag(double ingezetBedrag) {
        if (currentState == wait) {
            this.ingezetBedrag = ingezetBedrag;
        } else if (currentState == verhoogInzet) {
            this.ingezetBedrag += ingezetBedrag;
            verhoogInzet();
        } else {
            throw new IllegalArgumentException("Kan nu geen geld inzetten.");
        }
    }


    public Gokstrategie[] getAlleGokstrategieën() {
        return Gokstrategie.values();
    }

    /*public int werpDobbelsteen() {
        return dobbie.werpDobbelsteen();
    }*/

    public int werpDobbelsteen() {
        return currentState.werpDobbelsteen(dobbie);
    }

/*    public boolean evalueerWorp(int worp) {
        return gokstrategie.evalueerGok(worp);
    }*/

    public boolean evalueerWorp(int worp) {
        return currentState.evalueerWorp(worp, gokstrategie);
    }

    public void setStrategy(String keuze) {
        GokstrategieStrategyFactory strategyFactory = GokstrategieStrategyFactory.getInstance();
        GokstrategieStrategy strategy = strategyFactory.getStrategy(keuze);
        this.gokstrategie = strategy;
    }


    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(huidigeSpeler, ingezetBedrag);
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


    public void bevestigKeuze() {
        this.currentState.bevestigKeuze();
    }

    public void startSpel() {
        this.currentState.startSpel();
    }

    public void verhoogInzet() {
        this.currentState.verhoogInzet();
    }

    public void vraagVerhoog() {
        this.currentState.vraagVerhoog();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }


    public void setState(State state) {
        this.currentState = state;
    }

    public State getPlay() {
        return play;
    }

    public State getWait() {
        return wait;
    }

    public State getVerhoogInzet() {
        return verhoogInzet;
    }

    public State getChoose() {
        return choose;
    }
}
