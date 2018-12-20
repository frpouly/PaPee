package fr.gamejam.papee.entity.environment.obstacles;

import fr.gamejam.papee.util.GTextures;
import fr.gamejam.papee.entity.papee.Papee;
import fr.gamejam.papee.effect.Effect;

public class PeePuddle extends Obstacle {
    public PeePuddle(int ID, float x, float y) {
        super(ID, x, y, "pee_puddle");
        setTexture(GTextures.PEE_PUDDLE_TEXTURE);
    }

    @Override
    public void effect(Papee papee) {
        setEffect(new Effect(10, null));
        getEffect().applyEffect(papee, paPee -> paPee.setDrag(0.95f), paPee -> paPee.setDrag(0.8f));
        getEffect().startEffect();
    }

    @Override
    public boolean isRigid(){
        return false;
    }
}
