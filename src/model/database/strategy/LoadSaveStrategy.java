package model.database.strategy;

import java.util.Map;

/** @Authors Yenthe, Cisse, Lennert*/

public interface LoadSaveStrategy <K, V> {
    Map<K, V> load(String filename);
    void save(String filename, Map<K, V> mappie);
}
