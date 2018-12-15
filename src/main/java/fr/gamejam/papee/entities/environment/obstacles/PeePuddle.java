package fr.gamejam.papee.entities.environment.obstacles;

import fr.gamejam.papee.entities.PaPee;
import fr.gamejam.papee.entities.environment.items.ItemType;

public class PeePuddle extends Obstacle {

    public PeePuddle(int ID, float x, float y) {
        super(ID, x, y, ItemType.MALUS, "PeePuddle");
    }


    @Override
    public void effect(PaPee papee) {

    }
}
