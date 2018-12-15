package fr.gamejam.papee.entities.environment.obstacles;

import fr.gamejam.papee.entities.PaPee;
import fr.gamejam.papee.entities.environment.items.ItemType;

public class Door extends Obstacle {

    public Door(int ID, float x, float y) { super(ID, x, y, ItemType.MALUS, "Door"); }
    
    @Override
    public void effect(PaPee papee) {

    }
}
