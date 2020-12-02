package model.database;

import model.Speler;
import model.database.template.TekstLoadSaveTemplate;

public class SpelerTekstReaderWriter extends TekstLoadSaveTemplate {
    @Override
    protected String getSeperator() {
        return ",";
    }

    @Override
    protected Object getKey(String[] parts) {
        return parts[2];
    }

    @Override
    protected Object maakObject(String[] parts) {
        return new Speler(parts[0], parts[1], parts[2], Double.parseDouble(parts[3]));
    }
}