package fr.gamejam.papee.entities.environment.items;

import fr.gamejam.papee.engine.graphics.GTexture;
import fr.gamejam.papee.entities.Bladder;
import fr.gamejam.papee.entities.PaPee;
import fr.gamejam.papee.entities.environment.Effect;

public class ItemBeer extends Item {
    public ItemBeer(int ID, float x, float y) {
        super(ID, x, y, ItemType.MALUS, "beer");
        setTexture(GTexture.BEER_TEXTURE);
    }

    @Override
    public void effect(PaPee papee) {
        setEffect(new Effect(0));
        getEffect().applyEffect(papee , paPee -> paPee.getBladder().increasePeeLevel(10));
        getEffect().startEffect();
    }
}
