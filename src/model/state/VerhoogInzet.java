package model.state;

import model.Gokspel;

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
