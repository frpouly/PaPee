package fr.gamejam.papee.entities.environment.items;

import fr.gamejam.papee.engine.graphics.GTexture;
import fr.gamejam.papee.entities.PaPee;
import fr.gamejam.papee.entities.environment.Effect;

public class ItemNitro extends Item {
    public ItemNitro(int ID, float x, float y) {
        super(ID, x, y, ItemType.BONUS, "nitro");
        setTexture(GTexture.NITRO_TEXTURE);
    }

    @Override
    public void effect(PaPee papee) {
        float speed = papee.getSpeed();

        setEffect(new Effect(120));
        getEffect().applyEffect(papee , paPee -> paPee.setSpeed(paPee.getSpeed() + 0.5f),
                paPee -> paPee.setSpeed(speed));
        getEffect().startEffect();
    }
}
