package model;

public class Speler {
    private String achternaam;
    private String voornaam;
    private String spelernaam;
    private double saldo;


    public Speler(String achternaam, String voornaam, String spelernaam, double saldo) {
        setAchternaam(achternaam);
        setVoornaam(voornaam);
        setSpelernaam(spelernaam);
        setSaldo(saldo);
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public void setSpelernaam(String spelernaam) {
        this.spelernaam = spelernaam;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public String getSpelernaam() {
        return spelernaam;
    }

    public double getSaldo() {
        return saldo;
    }
}
