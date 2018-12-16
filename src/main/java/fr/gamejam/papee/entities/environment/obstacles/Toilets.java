package fr.gamejam.papee.entities.environment.obstacles;

import fr.gamejam.papee.engine.graphics.GTexture;
import fr.gamejam.papee.engine.utils.GDefines;
import fr.gamejam.papee.entities.PaPee;

public class Toilets extends Obstacle {
    public Toilets(int ID, float x, float y) {
        super(ID, x, y, "toilets");
        setTexture(GTexture.TOILETS);
    }

    public void recreatePosition() { // C'est dégueu mais j'ai pas le temps de faire un truc potable
        int x;
        int y;

        do {
            x = (int)(Math.random() * GDefines.MAP_WIDTH);
            y = (int)(Math.random() * GDefines.MAP_HEIGHT);
        } while(getMap().getTiles()[x][y].isRigid());

        setX(x * GDefines.OBJECT_WIDTH);
        setY(y * GDefines.OBJECT_HEIGHT);
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
