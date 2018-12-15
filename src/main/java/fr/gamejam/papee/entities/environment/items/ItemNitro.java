package fr.gamejam.papee.entities.environment.items;

import fr.gamejam.papee.entities.PaPee;

public class ItemNitro extends Item {
    public ItemNitro(int ID, float x, float y) {
        super(ID, x, y, ItemType.BONUS, "nitro");
    }

    @Override
    public void effect(PaPee papee) {

    }
}
