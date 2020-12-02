package model.database;

import model.Speler;

import java.io.IOException;
import java.util.*;
import java.io.File;


public class SpelersDatabaseInMemory {

    // hashmap met als key de spelernaam want die moet uniek zijn en als value de speler
    public Map<String, Speler> spelers = new HashMap<>();

    public SpelersDatabaseInMemory() {
    }

    public void leesGegevensIn(File filename) {
        try {
            spelers = new SpelerTekstReaderWriter().load(filename);
        } catch (IOException e) {
            throw new Dbexception("Er ging iets mis bij het inlezen van de file.");
        }
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
