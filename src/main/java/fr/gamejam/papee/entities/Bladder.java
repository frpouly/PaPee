package fr.gamejam.papee.entities;

import fr.gamejam.papee.engine.objects.GObject;

public class Bladder extends GObject {

    public static final float INCREASE_PEE_LEVEL_BASE = 0.12f;

    private float peeStartLevel;
    private float peeMaxLevel;
    private float peeLevel;
    private boolean isFull;
    private float scaleY;
    private float increaseLevel;

    public boolean isFull() {
        return isFull;
    }

    public Bladder(float peeStartLevel, float peeMaxLevel) {
        super(100, 10, 10, 64, 256, false);
        this.peeStartLevel = peeStartLevel;
        this.peeMaxLevel = peeMaxLevel;
        this.peeLevel = peeStartLevel;
        this.scaleY = (sizeY - 40) / peeMaxLevel;
        this.increaseLevel = INCREASE_PEE_LEVEL_BASE;
        this.peeLevel = peeStartLevel;
    }

    public float getPeeStartLevel() {
        return peeStartLevel;
    }

    public void setPeeStartLevel(float peeStartLevel) {
        if (peeStartLevel < 100 && peeStartLevel >= 0)
            this.peeStartLevel = peeStartLevel;
    }

    public float getPeeMaxLevel() {
        return peeMaxLevel;
    }

    public void setPeeMaxLevel(float peeMaxLevel) {
        if (peeMaxLevel <= 100 && peeMaxLevel > 0)
            this.peeMaxLevel = peeMaxLevel;
    }

    public float getPeeLevel() {
        return peeLevel;
    }

    public void setPeeLevel(float peeLevel) {
        this.peeLevel = peeLevel;
    }

    public float getIncreaseLevel() {
        return increaseLevel;
    }

    public void setIncreaseLevel(float increaseLevel) {
        this.increaseLevel = increaseLevel;
    }

    public float getScaleY() {
        return scaleY;
    }

    public void increasePeeLevel(float increaseLevel) {
        float newPeeLevel = peeLevel + increaseLevel;
        if (newPeeLevel >= peeMaxLevel) {
            isFull = true;
            peeLevel = peeMaxLevel;
        } else peeLevel = newPeeLevel;
    }

    public void increasePeeLevel() {
        this.increasePeeLevel(increaseLevel);
    }

    @Override
    public void render() {

    }
}
