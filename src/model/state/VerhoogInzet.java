package model.state;

import model.Gokspel;

/** @Authors Yenthe, Cisse, Lennert*/

public class VerhoogInzet implements State{
    private Gokspel gokspel;

    public VerhoogInzet(Gokspel gokspel){
        this.gokspel = gokspel;
    }

    @Override
    public void verhoogInzet() {
        gokspel.setState(gokspel.getPlay());
    }
}
