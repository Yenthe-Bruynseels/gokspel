package model.database;

import model.Speler;

import java.io.File;
import java.util.*;


public class SpelersDatabaseInMemory {

    // hashmap met als key de spelernaam want die moet uniek zijn en als value de speler
    public Map<String, Speler> spelers = new HashMap<>();

    public SpelersDatabaseInMemory() {
    }

    public void leesGegevensIn(File file) {
            spelers = new SpelerTekstLoadSave().load(file);
    }

    public Map<String, Speler> getSpelersInMap() {
        return spelers;
    }

    public List<Speler> getSpelers() {
        List<Speler> spelers = new ArrayList<Speler>(getSpelersInMap().values());
        Collections.sort(spelers);
        return spelers;
    }

    public Speler getSpelerMetSpelernaam(String spelerNaam) {
        return spelers.get(spelerNaam);
    }

    @Override
    public String toString() {
        return "SpelersDatabaseInMemory{" +
                "spelers=" + spelers +
                '}';
    }
}
