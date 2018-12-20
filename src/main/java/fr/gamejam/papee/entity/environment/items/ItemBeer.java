package fr.gamejam.papee.entity.environment.items;

import fr.gamejam.papee.util.GTextures;
import fr.gamejam.papee.entity.papee.Papee;
import fr.gamejam.papee.effect.Effect;

public class ItemBeer extends Item {
    public ItemBeer(int ID, float x, float y) {
        super(ID, x, y, "beer");
        setTexture(GTextures.BEER_TEXTURE);
    }

    @Override
    public void effect(Papee papee) {
        setEffect(new Effect(0, null));
        getEffect().applyEffect(papee , paPee -> paPee.getBladder().increasePeeLevel(10));
        getEffect().startEffect();
    }
}
