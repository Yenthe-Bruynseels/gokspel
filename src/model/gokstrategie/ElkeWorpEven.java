package model.gokstrategie;

public class ElkeWorpEven implements GokstrategieStrategy{
    private double winstfactor = 4.0;

    @Override
    public boolean evalueerGok(int worp){
        return (worp % 2) == 0;
    }

    @Override
    public double getWinstfactor() {
        return this.winstfactor;
    }

    public void setWinstfactor(double winstfactor) {
        this.winstfactor = winstfactor;
    }

}
