package fr.gamejam.papee.entities.environment.items;

<<<<<<< HEAD
import fr.gamejam.papee.engine.graphics.GTexture;
=======
>>>>>>> Implement Items
import fr.gamejam.papee.entities.PaPee;

public class ItemViagra extends Item{

    public ItemViagra(int ID, float x, float y) {
        super(ID, x, y, ItemType.BONUS, "viagra");
        setTexture(GTexture.VIAGRA_TEXTURE);
    }

    @Override
    public void effect(PaPee papee) {
        papee.setSpeed(0);
    }
}
