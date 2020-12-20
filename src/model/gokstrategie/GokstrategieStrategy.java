package model.gokstrategie;

/** @Authors Yenthe, Cisse, Lennert*/

public interface GokstrategieStrategy {

    boolean evalueerGok(int worp1);

    double getWinstfactor();

    default double setWinstfactor() {
        return Gokstrategie.valueOf(this.getClass().getSimpleName().toUpperCase()).getWinstfactor();
    }
}
