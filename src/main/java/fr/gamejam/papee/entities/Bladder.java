package fr.gamejam.papee.entities;

import fr.gamejam.papee.engine.graphics.GGraphics;
import fr.gamejam.papee.engine.objects.GObject;
import fr.gamejam.papee.engine.utils.GDefines;
import sun.awt.SunHints;

public class Bladder extends GObject {

    public static final float INCREASE_PEE_LEVEL_BASE = 0.1f;

    private float peeStartLevel;
    private float peeMaxLevel;
    private float peeLevel;
    private boolean isFull;

    private float increaseLevel;

    public boolean isFull() {
        return isFull;
    }

    public Bladder(float peeStartLevel, float peeMaxLevel) {
        super(100, 10, 10, 32, 128, false);
        this.peeStartLevel = peeStartLevel;
        this.peeMaxLevel = peeMaxLevel;
        this.peeLevel = peeStartLevel;
        this.scaleY = sizeY/peeMaxLevel;
        this.increaseLevel = INCREASE_PEE_LEVEL_BASE;
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

    public float getIncreaseLevel() {
        return increaseLevel;
    }

    public void setIncreaseLevel(float increaseLevel) {
        this.increaseLevel = increaseLevel;
    }

    public void increasePeeLevel() {
        float newPeeLevel = peeLevel + increaseLevel;
        if(newPeeLevel >= peeMaxLevel) {
            isFull = true;
            peeLevel = peeMaxLevel;
        } else peeLevel = newPeeLevel;
    }

    public void decreasePeeLevel(float value) {
        float newPeeLevel = peeLevel - value;
        peeLevel = (newPeeLevel < 0) ? 0 : newPeeLevel;

    }

    @Override
    public void render() {
        GGraphics.renderQuad(x, y, sizeX, sizeY, GDefines.GRAY);
        GGraphics.renderQuad(x, y + (peeMaxLevel - peeLevel) * scaleY , sizeX, peeLevel * scaleY, GDefines.YELLOW);
    }
}
