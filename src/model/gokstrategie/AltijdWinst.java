package model.gokstrategie;

/** @Authors Yenthe, Cisse, Lennert*/

public class AltijdWinst implements GokstrategieStrategy {
    private double winstfactor;

    public AltijdWinst() {
        this.winstfactor = setWinstfactor();
    }

    @Override
    public boolean evalueerGok(int worp1) {
        return true;
    }

    @Override
    public double getWinstfactor() {
        return this.winstfactor;
    }



}
