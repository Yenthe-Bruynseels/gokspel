package model.database;

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





    //Schrijft de value met waarde 'keuze' weg naar de property met waarde 'property'
    public static void save(String keuze, String property) {
        //
    }








}
