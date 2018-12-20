package fr.gamejam.papee.entity.environment.obstacles;

import fr.gamejam.papee.entity.papee.Papee;

public class Poop extends Obstacle {
    public Poop(int ID, float x, float y) {
        super(ID, x, y, "poop");
    }

    @Override
    public void effect(Papee papee) {

    }

    @Override
    public boolean isRigid(){
        return false;
    }
}
