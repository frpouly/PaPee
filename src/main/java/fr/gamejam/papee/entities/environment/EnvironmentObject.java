package fr.gamejam.papee.entities.environment;

import fr.gamejam.papee.engine.objects.GObject;
import fr.gamejam.papee.entities.PaPee;
import fr.gamejam.papee.entities.environment.items.ItemType;

public abstract class EnvironmentObject extends GObject {

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

    public EnvironmentObject(int ID, float x, float y, int sizeX, int sizeY, boolean rigid, ItemType itemType, String name) {
        super(ID, x, y, sizeX, sizeY, rigid);
        this.itemType = itemType;
        this.name = name;
    }

    public abstract void effect(PaPee papee);
}
