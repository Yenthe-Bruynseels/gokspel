package model.gokstrategie;

public class AltijdWinst implements GokstrategieStrategy {
    private double winstfactor = 2.0;

    @Override
    public boolean evalueerGok(int worp1) {
        return true;
    }
}
