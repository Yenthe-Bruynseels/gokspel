package model;

import java.util.Objects;

public class Speler implements Comparable<Speler>{
    private String achternaam;
    private String voornaam;
    private String spelernaam;
    private double saldo;

    public Speler() {
        this("", "", "", 0.00);
    }

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

    public void verminderSaldo(double ingezetBedrag) {
        this.saldo = this.saldo - ingezetBedrag ;

    }

    public void vermeerderSaldo(double winstfactor, double ingezetBedrag) {
        this.saldo =  (this.saldo - ingezetBedrag) + (ingezetBedrag * winstfactor);
    }

    public String toStringWithGivenSeperator(String seperator) {
        return achternaam + seperator + voornaam + seperator + spelernaam + seperator + saldo;
    }

    @Override
    public String toString() {
        return "Speler{" +
                "achternaam='" + achternaam + '\'' +
                ", voornaam='" + voornaam + '\'' +
                ", spelernaam='" + spelernaam + '\'' +
                ", saldo=" + saldo +
                '}';
    }

    @Override
    public int compareTo(Speler o) {
        return getSpelernaam().compareTo(o.getSpelernaam());
    }


    @Override
    public boolean equals (Object o) {
        boolean result = false;
        if (o instanceof Speler) {
            Speler s = (Speler) o;
            if (this.spelernaam.equals(s.spelernaam)) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSpelernaam());
    }
}
