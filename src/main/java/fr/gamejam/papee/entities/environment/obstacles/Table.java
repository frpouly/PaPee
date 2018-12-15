package fr.gamejam.papee.entities.environment.obstacles;

import fr.gamejam.papee.entities.PaPee;
import fr.gamejam.papee.entities.environment.items.ItemType;

public class Table extends Obstacle {

    public Table(int ID, float x, float y) { super(ID, x, y, ItemType.MALUS, "table"); }
    
    @Override
    public void effect(PaPee papee) {

    }
}
