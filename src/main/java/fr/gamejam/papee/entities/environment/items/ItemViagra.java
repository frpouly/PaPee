package fr.gamejam.papee.entities.environment.items;

import fr.gamejam.papee.engine.graphics.GTexture;
import fr.gamejam.papee.entities.Bladder;
import fr.gamejam.papee.entities.PaPee;
import fr.gamejam.papee.entities.environment.Effect;

public class ItemViagra extends Item{

    public ItemViagra(int ID, float x, float y) {
        super(ID, x, y, ItemType.BONUS, "viagra");
        setTexture(GTexture.VIAGRA_TEXTURE);
    }

    @Override
    public void effect(PaPee papee) {
        setEffect(new Effect(180));
        getEffect().applyEffect(papee , paPee -> paPee.getBladder().setIncreaseLevel(0),
                                 paPee -> paPee.getBladder().setIncreaseLevel(Bladder.INCREASE_PEE_LEVEL_BASE));
        getEffect().startEffect();
    }
}
