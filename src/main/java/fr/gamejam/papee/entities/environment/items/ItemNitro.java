package fr.gamejam.papee.entities.environment.items;

import fr.gamejam.papee.util.GTextures;
import fr.gamejam.papee.entities.papee.Papee;
import fr.gamejam.papee.effect.Effect;

public class ItemNitro extends Item {

    public ItemNitro(int ID, float x, float y) {
        super(ID, x, y, "nitro");
        setTexture(GTextures.NITRO_TEXTURE);
    }

    @Override
    public void effect(Papee papee) {
        float speed = papee.getSpeed();
        setEffect(new Effect(120, GTextures.FIRE_PARTICLE));
        getEffect().applyEffect(papee , (paPee) -> {
                    paPee.setSpeed(paPee.getSpeed() + 1.5f);
                    paPee.setTexture(GTextures.PLAYER_NITRO);
                },
                (paPee) -> {
                    paPee.setSpeed(Papee.BASE_SPEED);
                    paPee.setTexture(GTextures.PLAYER);
                });
        getEffect().startEffect();
    }
}
