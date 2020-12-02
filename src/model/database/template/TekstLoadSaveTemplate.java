package model.database.template;
import model.DomainException;
import model.Speler;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public abstract class TekstLoadSaveTemplate <K,V> {

    protected abstract String getSeperator();


    public final Map<K, V> load(File file) throws IOException{
        Map<K, V> returnMap = new HashMap<K, V>();
        try {
            Scanner scannerFile = new Scanner(new FileReader(file));

            while (scannerFile.hasNextLine()) {
                String s = scannerFile.nextLine();
                String[] parts = s.split(",");
                V element = maakObject(parts);
                K key = getKey(parts);

                returnMap.put(key,element);
            }
        } catch (FileNotFoundException e) {
            throw new DomainException("Fout bij het inlezen", e);
        }
        return returnMap;
    }

    public final void save(String filename, List<Speler> spelers) {
        File spelersInFile = new File(filename);
        try {
            PrintWriter writer = new PrintWriter(spelersInFile);
            for(Speler s: spelers){
                writer.println(s.toStringWithGivenSeperator(getSeperator()));
            }
            writer.close();
        }
        catch (FileNotFoundException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    protected abstract K getKey(String[] parts);


    protected abstract V maakObject(String[] parts);
}
