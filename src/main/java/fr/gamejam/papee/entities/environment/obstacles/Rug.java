package fr.gamejam.papee.entities.environment.obstacles;

import fr.gamejam.papee.entities.PaPee;
import fr.gamejam.papee.entities.environment.items.ItemType;

public class Rug extends Obstacle {

    public Rug(int ID, float x, float y) { super(ID, x, y, ItemType.MALUS, "rug"); }
    
    @Override
    public void effect(PaPee papee) {

    }
}
