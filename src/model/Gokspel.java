package model;

import model.database.PropertiesLoadSave;
import model.database.SpelersDatabaseInMemory;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Gokspel {
    private SpelersDatabaseInMemory db;
    private Map<String, Speler> spelers;

    public Gokspel(){
        setDb(new SpelersDatabaseInMemory());
        this.spelers = new HashMap<>();
        spelers.putAll(this.db.getAll("speler." + PropertiesLoadSave.load("DATABASE")));
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


/*    public List<Speler> getSpelers() {
        return  spelersDb.getSpelers();
    }

    public void leesGegevensIn(File file) {
        spelersDb.leesGegevensIn(file);
    }*/

}
