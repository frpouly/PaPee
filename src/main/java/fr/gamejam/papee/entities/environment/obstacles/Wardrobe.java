package fr.gamejam.papee.entities.environment.obstacles;

import fr.gamejam.papee.entities.PaPee;
import fr.gamejam.papee.entities.environment.items.ItemType;

public class Wardrobe extends Obstacle {

    public Wardrobe(int ID, float x, float y) { super(ID, x, y, ItemType.MALUS, "wardrobe"); }
    
    @Override
    public void effect(PaPee papee) {

    }
}
