package fr.gamejam.papee.entities.environment.obstacles;

import fr.gamejam.papee.entities.environment.EnvironmentObject;
import fr.gamejam.papee.entities.environment.items.ItemType;

public abstract class Obstacle extends EnvironmentObject {
    public Obstacle(int ID, float x, float y, ItemType itemType, String name) {
        super(ID, x, y, 64, 64, true, itemType, name);
    }
}
