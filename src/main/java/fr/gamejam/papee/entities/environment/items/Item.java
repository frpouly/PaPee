package fr.gamejam.papee.entities.environment.items;

import fr.gamejam.papee.entities.environment.EnvironmentObject;

public abstract class Item extends EnvironmentObject {
    public Item(int ID, float x, float y, ItemType itemType, String name) {
        super(ID, x, y, 32, 32, false, itemType, name);
    }
}
