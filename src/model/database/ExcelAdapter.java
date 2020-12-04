package model.database;

import excel.ExcelPlugin;
import jxl.read.biff.BiffException;
import model.Speler;
import model.database.strategy.LoadSaveStrategy;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelAdapter implements LoadSaveStrategy {
    ExcelPlugin excelPlugin;

    public ExcelAdapter(){
        excelPlugin = new ExcelPlugin();
    }

    @Override
    public Map load(File file) {
        Map<String, Speler> spelers = new HashMap<>();

        try{
            List<ArrayList<String>> excelLijst = excelPlugin.read(file);
            for(List<String> spelerParameters : excelLijst){
                String lastname = spelerParameters.get(0);
                String firstname = spelerParameters.get(1);
                String spelernaam = spelerParameters.get(2);
                double saldo = Double.parseDouble(spelerParameters.get(3));
                Speler speler = new Speler(lastname, firstname, spelernaam, saldo);
                spelers.put(spelernaam, speler);
            }
        }catch (BiffException | IOException e){
            throw new DbException(e.getMessage());
        }
        return spelers;
    }

    @Override
    public void save(String filename, List spelers) {
        // Later.
    }
}
