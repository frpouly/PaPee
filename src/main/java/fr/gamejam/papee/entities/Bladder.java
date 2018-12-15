package fr.gamejam.papee.entities;

import fr.gamejam.papee.engine.graphics.GGraphics;
import fr.gamejam.papee.engine.objects.GObject;
import fr.gamejam.papee.engine.utils.GDefines;

public class Bladder extends GObject {
    private float peeStartLevel;
    private float peeMaxLevel;
    private float peeLevel;
    private boolean isFull;

    public boolean isFull() {
        return isFull;
    }

    public Bladder(float peeStartLevel, float peeMaxLevel) {
        super(100, 10, 10, 32, 128, false);
        this.peeStartLevel = peeStartLevel;
        this.peeMaxLevel = peeMaxLevel;
        this.peeLevel = peeStartLevel;
    }

    public float getPeeStartLevel() {
        return peeStartLevel;
    }

    public void setPeeStartLevel(float peeStartLevel) {
        if(peeStartLevel < 100 && peeStartLevel >= 0)
        this.peeStartLevel = peeStartLevel;
    }

    public float getPeeMaxLevel() {
        return peeMaxLevel;
    }

    public void setPeeMaxLevel(float peeMaxLevel) {
        if(peeMaxLevel <= 100 && peeMaxLevel > 0)
            this.peeMaxLevel = peeMaxLevel;
    }

    public void increasePeeLevel(float value) {
        float newPeeLevel = peeLevel + value;
        if(newPeeLevel >= peeMaxLevel) {
            isFull = true;
            peeLevel = peeMaxLevel;
        } else peeLevel = newPeeLevel;
    }

    public void decreasePeeLevel(float value)
    {
        float newPeeLevel = peeLevel - value;
        peeLevel = (newPeeLevel < 0) ? 0 : newPeeLevel;
    }

    @Override
    public void render() {
        GGraphics.renderQuad(x, y, sizeX, sizeY, GDefines.GRAY);
        GGraphics.renderQuad(x, y + 50, sizeX, sizeY - 50, GDefines.LIGHT_BLUE);
    }
}
