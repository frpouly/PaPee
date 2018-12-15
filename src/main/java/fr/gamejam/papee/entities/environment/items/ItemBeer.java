package fr.gamejam.papee.entities.environment.items;

import fr.gamejam.papee.entities.PaPee;
import fr.gamejam.papee.entities.environment.EnvironmentObject;

public class ItemBeer extends EnvironmentObject {

    public ItemBeer() {
        super("beer", ItemType.MALUS);
    }

    @Override
    public void effect(PaPee papee) {

    }
}
