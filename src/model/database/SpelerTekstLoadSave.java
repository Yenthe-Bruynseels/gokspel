package model.database;

import model.Speler;
import model.database.template.TekstLoadSaveTemplate;

/** @Authors Yenthe, Cisse, Lennert*/

public class SpelerTekstLoadSave extends TekstLoadSaveTemplate {

    @Override
    protected String getSeperator() {
        return ",";
    }

    @Override
    protected Object getKey(String[] parts) {
        return parts[2];
    }

    @Override
    protected String makeStringFromValue(Object value) {
        Speler speler = (Speler) value;
        return speler.getAchternaam() + "," + speler.getVoornaam() + "," + speler.getSpelernaam() + "," + speler.getSaldo();
    }

    @Override
    protected Object maakObject(String[] parts) {
        return new Speler(parts[0], parts[1], parts[2], Double.parseDouble(parts[3]));
    }
}