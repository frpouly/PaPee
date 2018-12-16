package fr.gamejam.papee.entities.environment.obstacles;

import fr.gamejam.papee.entities.PaPee;
import fr.gamejam.papee.entities.environment.items.ItemType;

public class Poop extends Obstacle {

    public Poop(int ID, float x, float y) {
        super(ID, x, y, ItemType.MALUS, "poop");
    }


    @Override
    public void effect(PaPee papee) {

    }

    @Override
    public boolean isRigid(){
        return false;
    }
}
