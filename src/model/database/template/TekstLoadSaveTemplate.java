package model.database.template;
import model.DomainException;
import model.database.strategy.LoadSaveStrategy;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public abstract class TekstLoadSaveTemplate <K,V> implements LoadSaveStrategy {

    protected abstract String getSeperator();

    @Override
    public final Map<K, V> load(String filename){
        Map<K, V> returnMap = new HashMap<K, V>();
        try {
            Scanner scannerFile = new Scanner(new FileReader("src/bestanden/" + filename));

            while (scannerFile.hasNextLine()) {
                String s = scannerFile.nextLine();
                String[] parts = s.split(getSeperator());
                K key = getKey(parts);
                V element = maakObject(parts);

                returnMap.put(key,element);
            }
        } catch (FileNotFoundException e) {
            throw new DomainException("Fout bij het inlezen", e);
        }
        return returnMap;
    }

    @Override
    public final void save(String filename, Map mappie) {
        try {
            PrintWriter writer = new PrintWriter("src/bestanden/" + filename);

            for(Object value: mappie.values()){
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
