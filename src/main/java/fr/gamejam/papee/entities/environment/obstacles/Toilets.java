package fr.gamejam.papee.entities.environment.obstacles;

import fr.gamejam.papee.engine.graphics.GTexture;
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
}
