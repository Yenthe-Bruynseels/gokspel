package model.gokstrategie;

import java.util.ArrayList;
import java.util.List;

public class SomIs21 implements GokstrategieStrategy{
    private List<Integer> worpen = new ArrayList<>();
    private int som = 0;

    public SomIs21(){
    }

    public boolean evalueerGok(int worp) {
        if (worpen.size() == 0) {
            worpen.add(worp);
            som += worp;
            if (som < 3) {
                return false;
            }
        } else if (worpen.size() == 1) {
            worpen.add(worp);
            som += worp;
            if (som < 9) {
                return false;
            }
        } else if (worpen.size() == 2) {
            worpen.add(worp);
            som += worp;
            if (som < 15) {
                return false;
            }
        } else if (worpen.size() == 3) {
            worpen.add(worp);
            som += worp;
            if (som != 21) {
                return false;
            }
        }
        return true;
    }
}

