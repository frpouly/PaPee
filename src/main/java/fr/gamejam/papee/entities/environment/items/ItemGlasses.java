package fr.gamejam.papee.entities.environment.items;

import fr.gamejam.papee.entities.PaPee;
import fr.gamejam.papee.entities.environment.EnvironmentObject;

public class ItemGlasses extends EnvironmentObject {

    public ItemGlasses() {
        super("glasses", ItemType.BONUS);
    }

    @Override
    public void effect(PaPee papee) {

    }
}
