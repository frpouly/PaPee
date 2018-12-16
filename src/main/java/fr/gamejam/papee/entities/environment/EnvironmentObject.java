package fr.gamejam.papee.entities.environment;

import fr.gamejam.papee.engine.objects.GObject;
import fr.gamejam.papee.entities.PaPee;

public abstract class EnvironmentObject extends GObject {
    private Effect effect;
    private String name;

    public EnvironmentObject(int ID, float x, float y, int sizeX, int sizeY, boolean rigid, String name) {
        super(ID, x, y, sizeX, sizeY, rigid);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Effect getEffect() {
        return effect;
    }

    public void setEffect(Effect effectTime) {
        this.effect = effectTime;
    }

    public abstract void effect(PaPee papee);
}
