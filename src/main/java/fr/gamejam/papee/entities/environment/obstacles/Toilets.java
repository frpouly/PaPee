package fr.gamejam.papee.entities.environment.obstacles;

import fr.gamejam.papee.engine.graphics.GTexture;
import fr.gamejam.papee.engine.utils.GDefines;
import fr.gamejam.papee.entities.PaPee;

public class Toilets extends Obstacle {

    public Toilets(int ID, float x, float y) {
        super(ID, x, y, null, "toilets");
        setTexture(GTexture.TOILETS);
    }

    @Override
    public void effect(PaPee papee) {
        papee.hasWon();
    }

    public int getPosX() {
        return (int) (getX() / GDefines.OBJECT_WIDTH);
    }

    public int getPosY() {
        return (int) (getY() / GDefines.OBJECT_HEIGHT);
    }
}
