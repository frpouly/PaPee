package fr.gamejam.papee.entities.environment.obstacles;

import fr.gamejam.papee.engine.graphics.GTexture;
import fr.gamejam.papee.entities.PaPee;
import fr.gamejam.papee.entities.environment.items.ItemType;

public class Toilets extends Obstacle {

    public Toilets(int ID, float x, float y) {
        super(ID, x, y, ItemType.BONUS, "viagra");
        setTexture(GTexture.VIAGRA_TEXTURE);
    }

    @Override
    public void effect(PaPee papee) {
        papee.hasWon();
    }
}
