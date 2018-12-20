package fr.gamejam.papee.entities.environment.obstacles;

import fr.gamejam.papee.util.GTextures;
import fr.gamejam.papee.util.GDefines;
import fr.gamejam.papee.entities.papee.Papee;
import fr.gamejam.papee.game.Game;

public class Toilets extends Obstacle {
    public Toilets(int ID, float x, float y) {
        super(ID, x, y, "toilets");
        setTexture(GTextures.TOILETS);
    }

    @Override
    public void effect(Papee papee) {
        Game.setWon(true);
    }

    public int getPosX() {
        return (int) (getX() / GDefines.OBJECT_WIDTH);
    }

    public int getPosY() {
        return (int) (getY() / GDefines.OBJECT_HEIGHT);
    }
}
