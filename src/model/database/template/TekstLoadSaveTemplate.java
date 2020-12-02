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
                String[] parts = s.split(getSeperator());
                V element = maakObject(parts);
                K key = getKey(parts);

                returnMap.put(key,element);
            }
        } catch (FileNotFoundException e) {
            throw new DomainException("Fout bij het inlezen", e);
        }
        return returnMap;
    }

    public final void save(String filename, List valuelist) {
        File spelersInFile = new File(filename);
        try {
            PrintWriter writer = new PrintWriter(spelersInFile);

            for(Object value: valuelist){
                writer.println(makeStringFromValue(value));
            }
            writer.close();
        }
        catch (FileNotFoundException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    protected abstract V maakObject(String[] parts);

    protected abstract K getKey(String[] parts);

    protected abstract String makeStringFromValue(Object value);

}
