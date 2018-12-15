package fr.gamejam.papee.entities.environment;

import fr.gamejam.papee.engine.objects.GObject;
import fr.gamejam.papee.entities.PaPee;
import fr.gamejam.papee.entities.environment.items.ItemType;

public abstract class EnvironmentObject extends GObject {

    private Effect effect;
    private ItemType itemType;
    private String name;

    public EnvironmentObject(int ID, float x, float y, int sizeX, int sizeY, boolean rigid, ItemType itemType, String name) {
        super(ID, x, y, sizeX, sizeY, rigid);
        this.itemType = itemType;
        this.name = name;
    }

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

    public Effect getEffect() {
        return effect;
    }

    public void setEffect(Effect effectTime) {
        this.effect = effectTime;
    }

    public abstract void effect(PaPee papee);
}
