package model.state;

import model.Dobbelsteen;
import model.Gokspel;
import model.gokstrategie.GokstrategieStrategy;

public class Play implements State {
    private Gokspel gokspel;

    public Play(Gokspel gokspel) {
        this.gokspel = gokspel;
    }

    public boolean evalueerWorp(int worp, GokstrategieStrategy gokstrategie) {
        return gokstrategie.evalueerGok(worp);
    }

    @Override
    public int werpDobbelsteen(Dobbelsteen dobbie) {
        return dobbie.werpDobbelsteen();
    }

    @Override
    public void vraagVerhoog() {
        gokspel.setState(gokspel.getVerhoogInzet());
    }

    @Override
    public void vermeerderSaldo(double winstfactor, double ingezetBedrag) {
        gokspel.getHuidigeSpeler().vermeerderSaldo(winstfactor, ingezetBedrag);
        gokspel.setState(gokspel.getWait());
    }

    @Override
    public void verminderSaldo(double ingezetBedrag) {
        gokspel.getHuidigeSpeler().verminderSaldo(ingezetBedrag);
        gokspel.setState(gokspel.getWait());
    }
}
