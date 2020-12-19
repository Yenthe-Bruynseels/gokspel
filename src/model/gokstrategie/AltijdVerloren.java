package model.gokstrategie;

public class AltijdVerloren implements GokstrategieStrategy{
    private double winstfactor = 100.0;

    @Override
    public boolean evalueerGok(int worp1) {
        return false;
    }

    @Override
    public double getWinstfactor() {
        return this.winstfactor;
    }

    @Override
    public void setWinstfactor(double winstfactor) {
        this.winstfactor = winstfactor;
    }
}
