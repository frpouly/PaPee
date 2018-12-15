package fr.gamejam.papee.entities.environment.obstacles;

import fr.gamejam.papee.entities.PaPee;
import fr.gamejam.papee.entities.environment.items.ItemType;

public class Chair extends Obstacle {

    public Chair(int ID, float x, float y) { super(ID, x, y, ItemType.MALUS, "chair"); }
    
    @Override
    public void effect(PaPee papee) {

    }
}
