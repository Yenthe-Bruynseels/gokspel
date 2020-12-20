package model.gokstrategie;

import java.util.ArrayList;
import java.util.List;

public class ElkeWorpHogerDanVorige implements GokstrategieStrategy{
    private List<Integer> worpen;
    private double winstfactor;

    public ElkeWorpHogerDanVorige(){
        this.winstfactor = setWinstfactor();
        worpen = new ArrayList<>();

    }

    public boolean evalueerGok(int worp){
        for (Integer worpje : worpen) {
            if (worpje >= worp) {
                return false;
            }
        }
        worpen.add(worp);

        if (worpen.size() == 1) {
            return !(worpen.get(0) > 3);
        }
        else if (worpen.size() == 2) {
            return !(worpen.get(1) > 4);
        }
        else if (worpen.size() == 3) {
            return !(worpen.get(2) > 5);
        }

        else{
            return true;
        }
    }

    @Override
    public double getWinstfactor() {
        return winstfactor;
    }

    public void setWinstfactor(double winstfactor) {
        this.winstfactor = winstfactor;
    }
}
