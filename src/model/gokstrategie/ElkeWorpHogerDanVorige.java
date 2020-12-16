package model.gokstrategie;

import java.util.ArrayList;
import java.util.List;

public class ElkeWorpHogerDanVorige implements GokstrategieStrategy{
    private List<Integer> worpen;

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

    /*
    worp 1 3
    worp 2 4
    worp 3 5
    worp 4 6
     */
}
