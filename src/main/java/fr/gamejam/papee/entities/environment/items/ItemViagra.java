package fr.gamejam.papee.entities.environment.items;

import fr.gamejam.papee.entities.PaPee;

public class ItemViagra extends Item{

    public ItemViagra(int ID, float x, float y) {
        super(ID, x, y, ItemType.BONUS, "viagra");
    }

    @Override
    public void effect(PaPee papee) {

    }
}
