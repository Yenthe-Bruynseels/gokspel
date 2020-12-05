package model.database;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoadSave {

    //Returned de value van de property met waarde 'property'
    public static String load(String property) {
        String database = "";
        Properties proper = new Properties();
        try {
            InputStream fileInputStream = PropertiesLoadSave.class.getResourceAsStream("/bestanden/settings.properties");
            proper.load(fileInputStream);
            database = proper.getProperty(property);
        } catch (IOException e) {
            throw new DbException("Fout bij het inlezen van properties.");
        }
        return database;
    }
    public static boolean propertyBestaat(String prop) {
        return !PropertiesLoadSave.load(prop).equals("");
    }

    public static void save(String choice, String property) {
        try {
            FileInputStream fileInputStream = new FileInputStream("src/bestanden/settings.properties");
            Properties properties = new Properties();
            properties.load(fileInputStream);
            fileInputStream.close();

            FileOutputStream fileOutputStream = new FileOutputStream("src/bestanden/settings.properties");
            properties.setProperty(property, choice);
            properties.store(fileOutputStream, null);
            fileOutputStream.close();

        }catch (Exception e){
            throw new DbException("Probleem bij het opslaan.");
        }
    }
}
