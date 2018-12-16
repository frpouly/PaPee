package fr.gamejam.papee.entities.environment.obstacles;

import fr.gamejam.papee.engine.graphics.GTexture;
import fr.gamejam.papee.entities.PaPee;
import fr.gamejam.papee.entities.environment.Effect;
import fr.gamejam.papee.entities.environment.items.ItemType;

public class PeePuddle extends Obstacle {

    public PeePuddle(int ID, float x, float y) {
        super(ID, x, y, ItemType.MALUS, "pee_puddle");
        setTexture(GTexture.PEE_PUDDLE_TEXTURE);
    }


    @Override
    public void effect(PaPee papee) {
        setEffect(new Effect(10));
        getEffect().applyEffect(papee, paPee -> paPee.setDrag(1), paPee -> paPee.setDrag(0.8f));
        getEffect().startEffect();
    }

    @Override
    public boolean isRigid(){
        return false;
    }
}
