package model.database.template;

import model.Speler;

public class SpelerTekstReaderWriter extends TekstLoadSaveTemplate {
    @Override
    String getSeperator() {
        return ",";
    }

    @Override
    protected Object getKey(String[] parts) {
        return parts[2];
    }

    @Override
    protected Object maakObject(String[] parts) {
        Speler speler = new Speler(parts[0], parts[1], parts[2], Double.parseDouble(parts[3]));
        return speler;
    }
}