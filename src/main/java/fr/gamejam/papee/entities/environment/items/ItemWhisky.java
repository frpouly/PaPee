package fr.gamejam.papee.entities.environment.items;

import fr.gamejam.papee.util.GTextures;
import fr.gamejam.papee.entities.papee.Papee;
import fr.gamejam.papee.effect.Effect;

public class ItemWhisky extends Item {
    public ItemWhisky(int ID, float x, float y) {
        super(ID, x, y, "whisky");
        setTexture(GTextures.WHISKY_TEXTURE);
    }

    @Override
    public void effect(Papee papee) {
        setEffect(new Effect(0, null));
        getEffect().applyEffect(papee , paPee -> paPee.getBladder().increasePeeLevel(paPee.getBladder().getPeeLevel() / 2));
        getEffect().startEffect();
    }
}
