package model.database.strategy;

import java.io.File;
import java.util.List;
import java.util.Map;

public interface LoadSaveStrategy <K, V> {
    Map<K, V> load(File file);
    void save(String filename, List spelers);
}
