package fr.gamejam.papee.entities.environment.items;

import fr.gamejam.papee.entities.PaPee;

public class ItemGlasses extends Item {
    public ItemGlasses(int ID, float x, float y) {
        super(ID, x, y, ItemType.BONUS, "glasses");
    }

    @Override
    public void effect(PaPee papee) {

    }
}
