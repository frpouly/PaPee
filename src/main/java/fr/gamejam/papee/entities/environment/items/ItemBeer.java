package fr.gamejam.papee.entities.environment.items;

import fr.gamejam.papee.entities.PaPee;
import fr.gamejam.papee.entities.environment.EnvironmentObject;

public class ItemBeer extends Item {

    public ItemBeer(int ID, float x, float y) {
        super(ID, x, y, ItemType.MALUS, "beer");
    }

    @Override
    public void effect(PaPee papee) {

    }
}
