package fr.gamejam.papee.entities.environment.items;

import fr.gamejam.papee.entities.environment.EnvironmentObject;

public abstract class Item extends EnvironmentObject {
    public Item(String name, ItemType type) {
        super(name, type);
    }
}
