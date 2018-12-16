package fr.gamejam.papee.entities.environment.items;

import fr.gamejam.papee.engine.graphics.GTexture;
import fr.gamejam.papee.entities.PaPee;
import fr.gamejam.papee.entities.environment.Effect;

public class ItemWhisky extends Item {
    public ItemWhisky(int ID, float x, float y) {
        super(ID, x, y, "whisky");
        setTexture(GTexture.WHISKY_TEXTURE);
    }

    @Override
    public void effect(PaPee papee) {
        setEffect(new Effect(0, null));
        getEffect().applyEffect(papee , paPee -> paPee.getBladder().increasePeeLevel(paPee.getBladder().getPeeLevel() / 2));
        getEffect().startEffect();
    }
}
