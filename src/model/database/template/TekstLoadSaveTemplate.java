package model.database.template;
import model.DomainException;
import model.Speler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;


import java.io.IOException;
import java.util.Scanner;

public abstract class TekstLoadSaveTemplate <K,V> {

    public final Map<K, V> load(File file) throws IOException{
        Map<K, V> returnMap = new HashMap<K, V>();
        try {
            Scanner scannerFile = new Scanner(new FileReader(file));

            while (scannerFile.hasNextLine()) {
                String s = scannerFile.nextLine();
                String[] parts = s.split(",");
                String achternaam = parts[0];
                String voornaam = parts[1];
                String spelernaam = parts[2];
                double saldo = Double.parseDouble(parts[3]);
                Speler speler = new Speler(achternaam, voornaam, spelernaam, saldo);
                returnMap.put(spelernaam, speler);
            }
        } catch (FileNotFoundException e) {
            throw new DomainException("Fout bij het inlezen", e);
        }
        return returnMap;
    }
}
