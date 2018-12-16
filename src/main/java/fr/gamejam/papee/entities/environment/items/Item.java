package fr.gamejam.papee.entities.environment.items;

import fr.gamejam.papee.entities.environment.EnvironmentObject;

public abstract class Item extends EnvironmentObject {
    public Item(int ID, float x, float y, String name) {
        super(ID, x, y, 32, 32, false, name);
    }
}
