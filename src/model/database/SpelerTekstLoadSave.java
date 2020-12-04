package model.database;

import model.DomainException;
import model.Speler;
import model.database.template.TekstLoadSaveTemplate;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

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