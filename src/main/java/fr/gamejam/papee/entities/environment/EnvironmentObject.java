package fr.gamejam.papee.entities.environment;

import fr.gamejam.papee.entities.environment.items.ItemType;

public abstract class EnvironmentObject {

    private float effectTime;
    private ItemType itemType;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public float getEffectTime() {
        return effectTime;
    }

    public void setEffectTime(float effectTime) {
        this.effectTime = effectTime;
    }

    public EnvironmentObject(String name, ItemType type) {
        this.name = name;
        this.itemType = type;
    }
}
