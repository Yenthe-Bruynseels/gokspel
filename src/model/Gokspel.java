package model;

import model.database.SpelersDatabaseInMemory;

import java.io.File;
import java.util.List;

public class Gokspel {
    private final SpelersDatabaseInMemory spelersDb = new SpelersDatabaseInMemory();

    public Gokspel(){};

    public List<Speler> getSpelers() {
        return  spelersDb.getSpelers();
    }

    public void leesGegevensIn(File filename) {
        spelersDb.leesGegevensIn(filename);
    }

}
