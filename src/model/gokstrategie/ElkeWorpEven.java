package model.gokstrategie;

public class ElkeWorpEven implements GokstrategieStrategy{
    private double winstfactor;

    public ElkeWorpEven() {
        this.winstfactor = setWinstfactor();
    }

    @Override
    public boolean evalueerGok(int worp){
        return (worp % 2) == 0;
    }

    @Override
    public double getWinstfactor() {
        return this.winstfactor;
    }


}
