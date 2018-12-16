package fr.gamejam.papee.entities.environment.obstacles;

import fr.gamejam.papee.entities.PaPee;
import fr.gamejam.papee.entities.environment.items.ItemType;

public class Wall extends Obstacle {

    public Wall(int ID, float x, float y) { super(ID, x, y, ItemType.MALUS, "wall"); }
    
    @Override
    public void effect(PaPee papee) {

    }
}
