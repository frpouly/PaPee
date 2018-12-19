package fr.gamejam.papee.entities.environment.items;

import fr.gamejam.papee.engine.utils.GTextures;
import fr.gamejam.papee.entities.papee.Papee;
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
