package fr.gamejam.papee.entities.environment.items;

import fr.gamejam.papee.engine.fx.GParticle;
import fr.gamejam.papee.engine.graphics.GTexture;
import fr.gamejam.papee.engine.utils.GDefines;
import fr.gamejam.papee.entities.PaPee;
import fr.gamejam.papee.entities.environment.Effect;
import org.lwjgl.util.vector.Vector2f;

import java.util.Random;

public class ItemNitro extends Item {

    public ItemNitro(int ID, float x, float y) {
        super(ID, x, y, ItemType.BONUS, "nitro");
        setTexture(GTexture.NITRO_TEXTURE);
    }

    @Override
    public void effect(PaPee papee) {
        float speed = papee.getSpeed();

        setEffect(new Effect(120));
        getEffect().applyEffect(papee , (paPee) -> {
                    paPee.setSpeed(paPee.getSpeed() + 1.5f);
                    paPee.setTexture(GTexture.PLAYER_NITRO);
                },
                (paPee) -> {
                    paPee.setSpeed(PaPee.BASE_SPEED);
                    paPee.setTexture(GTexture.PLAYER);
                });
        getEffect().startEffect();
    }
}
