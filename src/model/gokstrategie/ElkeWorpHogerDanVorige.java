package model.gokstrategie;

import java.util.ArrayList;
import java.util.List;

public class ElkeWorpHogerDanVorige implements GokstrategieStrategy{
    private List<Integer> worpen;
    private double winstfactor = 10.0;

    public ElkeWorpHogerDanVorige(){
        worpen = new ArrayList<>();
        worpen.add(0);
        worpen.add(0);
        worpen.add(0);
        worpen.add(0);
    }

    public boolean evalueerGok(int worp){
        for (Integer worpje : worpen) {
            if (worpje >= worp) {
                return false;
            }
        }
        worpen.add(worp);

        if (worpen.get(0) > 3 || worpen.get(1) > 4 || worpen.get(2) > 5) {
            return false;
        }
        return true;
    }

    @Override
    public double getWinstfactor() {
        return winstfactor;
    }
}
