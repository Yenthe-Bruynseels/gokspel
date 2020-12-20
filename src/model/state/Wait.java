package model.state;

import model.Gokspel;

/** @Authors Yenthe, Cisse, Lennert*/

public class Wait implements State{
    private Gokspel gokspel;

    public Wait(Gokspel gokspel) {
        this.gokspel = gokspel;
    }

    @Override
    public void startSpel() {
        gokspel.setState(gokspel.getChoose());
    }
}
