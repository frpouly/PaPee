package fr.gamejam.papee.entities.environment.obstacles;

import fr.gamejam.papee.entities.PaPee;
import fr.gamejam.papee.entities.environment.items.ItemType;

public class Poop extends Obstacle {

    public Poop(int ID, float x, float y) {
        super(ID, x, y, ItemType.MALUS, "Poop");
    }


    @Override
    public void effect(PaPee papee) {

    }
}
