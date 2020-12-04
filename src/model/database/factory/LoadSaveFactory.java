package model.database.factory;

import model.database.DbException;
import model.database.strategy.LoadSaveStrategy;

public class LoadSaveFactory {
    private static LoadSaveFactory uniqueFactory;

    private LoadSaveFactory() {}

    public static LoadSaveFactory getInstance() {
        if (uniqueFactory == null) {
            uniqueFactory = new LoadSaveFactory();
        }
        return uniqueFactory;
    }

    //Returned de juiste LoadSaveStrategy aan de hand van de waarde in de properties file, de switch zorgt er voor dat het juiste object aangemaakt wordt
    public LoadSaveStrategy getStrategy(String fileType){
        String strategy = "";
        switch(fileType){
            case "xls":
                strategy = "ExcelAdapter";
                break;
            case "txt":
                strategy = "SpelerTekstLoadSave";
                break;
            default:
                strategy = "SpelerTekstLoadSave";
        }
        LoadSaveStrategy loadSave = null;
        try{
            Class loadSaveClass = Class.forName("model.database." + strategy);
            Object loadSaveObject = loadSaveClass.newInstance();
            loadSave = (LoadSaveStrategy) loadSaveObject;
        }catch (ClassNotFoundException | InstantiationException | IllegalAccessException e){
            throw new DbException();
        }
        return loadSave;
    }


}
