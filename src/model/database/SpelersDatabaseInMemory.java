package model.database;

import model.Speler;
import model.database.factory.LoadSaveFactory;
import model.database.strategy.LoadSaveStrategy;

import java.io.File;
import java.util.*;

/** @Authors Yenthe, Cisse, Lennert*/

public class SpelersDatabaseInMemory {
    private LoadSaveStrategy loadSaveStrategy;


    public SpelersDatabaseInMemory() {
        String database = PropertiesLoadSave.load("DATABASE");
        LoadSaveFactory factory = LoadSaveFactory.getInstance();
        LoadSaveStrategy strategy = factory.getStrategy(database);
        setLoadSaveStrategy(strategy);
    }

    private void setLoadSaveStrategy(LoadSaveStrategy strategy) {
        this.loadSaveStrategy = strategy;
    }

    public Map<String, Speler> getAll(String filename) {
        return loadSaveStrategy.load(filename);
    }

    public void saveAll(String filename, Map<String, Speler> spelers) {
        loadSaveStrategy.save(filename, spelers);
    }

}
