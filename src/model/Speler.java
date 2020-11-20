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
        if(achternaam == null || achternaam.trim().isEmpty()) {
            throw new DomainException("Achternaam mag niet leeg zijn");
        }
        this.achternaam = achternaam;
    }

    public void setVoornaam(String voornaam) {
        if(voornaam == null || voornaam.trim().isEmpty()) {
            throw new DomainException("Voornaam mag niet leeg zijn");
        }
        this.voornaam = voornaam;
    }

    public void setSpelernaam(String spelernaam) {
        if(spelernaam == null || spelernaam.trim().isEmpty()) {
            throw new DomainException("Spelernaam mag niet leeg zijn");
        }
        this.spelernaam = spelernaam;
    }

    public void setSaldo(double saldo) {
        if(saldo < 0) {
            throw new DomainException("Saldo mag niet negatief zijn");
        }
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
