package model.database;

import model.DomainException;
import model.Speler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.util.*;


public class SpelersDatabaseInMemory {
    Map<String, Speler> spelers = new HashMap<>();


    public void leesGegevensIn(String filePathName) {
        File spelersFile = new File(filePathName);
        try {
            Scanner scannerFile = new Scanner(spelersFile);

            while (scannerFile.hasNextLine()) {
                String s = scannerFile.nextLine();
                String[] parts = s.split(",");
                String achternaam = parts[0];
                String voornaam = parts[1];
                String spelernaam = parts[2];
                double saldo = Double.parseDouble(parts[3]);
                Speler speler = new Speler(achternaam, voornaam, spelernaam, saldo);
                spelers.put(spelernaam, speler);
            }
        } catch (FileNotFoundException e) {
            throw new DomainException("Fout bij het inlezen", e);
        }
    }

    public List<Speler> getSpelers() {
        return new ArrayList<Speler>(spelers.values());
    }


}
