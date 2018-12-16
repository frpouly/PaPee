package fr.gamejam.papee.entities.environment.obstacles;

import fr.gamejam.papee.engine.graphics.GTexture;
import fr.gamejam.papee.entities.PaPee;
import fr.gamejam.papee.entities.environment.Effect;

public class PeePuddle extends Obstacle {
    public PeePuddle(int ID, float x, float y) {
        super(ID, x, y, "pee_puddle");
        setTexture(GTexture.PEE_PUDDLE_TEXTURE);
    }

    @Override
    public void effect(PaPee papee) {
        setEffect(new Effect(15));
        getEffect().applyEffect(papee, paPee -> paPee.setDrag(0.95f), paPee -> paPee.setDrag(0.8f));
        getEffect().startEffect();
    }

    @Override
    public boolean isRigid(){
        return false;
    }
}
