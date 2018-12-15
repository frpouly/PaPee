package fr.gamejam.papee.entities.environment.items;

import fr.gamejam.papee.entities.PaPee;
import fr.gamejam.papee.entities.environment.EnvironmentObject;

public class ItemNitro extends EnvironmentObject {

    public ItemNitro() {
        super("nitro", ItemType.BONUS);
    }

    @Override
    public void effect(PaPee papee) {

    }
}
