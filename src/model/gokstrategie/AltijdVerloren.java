package model.gokstrategie;

/** @Authors Yenthe, Cisse, Lennert*/

public class AltijdVerloren implements GokstrategieStrategy{
    private double winstfactor;

    public AltijdVerloren() {
        this.winstfactor = setWinstfactor();
    }

    @Override
    public boolean evalueerGok(int worp1) {
        return false;
    }

    @Override
    public double getWinstfactor() {
        return this.winstfactor;
    }


}
