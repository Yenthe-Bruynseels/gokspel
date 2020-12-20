package model.state;

import model.Gokspel;

/** @Authors Yenthe, Cisse, Lennert*/

public class Choose implements State{
    private Gokspel gokspel;


    public Choose(Gokspel gokspel) {
        this.gokspel = gokspel;
    }

    @Override
    public void bevestigKeuze(){
        gokspel.setState(gokspel.getPlay());
    }
}
