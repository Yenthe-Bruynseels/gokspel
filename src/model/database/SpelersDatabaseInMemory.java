package model.database;

import model.Speler;
import model.database.template.SpelerTekstReaderWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.File;


public class SpelersDatabaseInMemory {

    // hashmap met als key de spelernaam want die moet uniek zijn en als value de speler
    public Map<String, Speler> spelers = new HashMap<>();

    public SpelersDatabaseInMemory() {
    }

    public Map<String, Speler> leesGegevensIn(String filePathName) {
        SpelerTekstReaderWriter spelerTekstReaderWriter = new SpelerTekstReaderWriter();
        File spelersFile = new File(filePathName);
        try {
            spelers = spelerTekstReaderWriter.load(spelersFile);
            return spelers;
        } catch (IOException e) {
            throw new Dbexception("Er ging iets mis bij het inlezen van de file.");
        }
    }

    public List<Speler> getSpelers() {
        return new ArrayList<Speler>(spelers.values());
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
