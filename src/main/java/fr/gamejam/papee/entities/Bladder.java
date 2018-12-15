package fr.gamejam.papee.entities;

public class Bladder {
    private float peeStartLevel;
    private float peeMaxLevel;

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
}
