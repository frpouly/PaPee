package fr.gamejam.papee.entities.environment.items;

import fr.gamejam.papee.util.GTextures;
import fr.gamejam.papee.entities.papee.Bladder;
import fr.gamejam.papee.entities.papee.Papee;
import fr.gamejam.papee.effect.Effect;

public class ItemViagra extends Item {
    public ItemViagra(int ID, float x, float y) {
        super(ID, x, y, "viagra");
        setTexture(GTextures.VIAGRA_TEXTURE);
    }

    @Override
    public void effect(Papee papee) {
        setEffect(new Effect(180, null));
        getEffect().applyEffect(papee , paPee -> paPee.getBladder().setIncreaseLevel(0),
                                 paPee -> paPee.getBladder().setIncreaseLevel(Bladder.INCREASE_PEE_LEVEL_BASE));
        getEffect().startEffect();
    }
}
