package fr.gamejam.papee.engine.animation;

import fr.gamejam.papee.engine.graphics.GTexture;

public class GAnimation {
    private final int BASE_CROP_ROTATION;
    private int cropRotation;
    private int currentCrop;
    private final GTexture[] TEXTURES;

    public GAnimation(int cropRotation, GTexture ...textures) {
        this.BASE_CROP_ROTATION = cropRotation;
        this.cropRotation = cropRotation;
        this.currentCrop = 0;
        this.TEXTURES = textures;
    }

    public GTexture current() {
        return TEXTURES[currentCrop];
    }

    public void update() {
        cropRotation--;

        if (cropRotation <= 0) {
            cropRotation = BASE_CROP_ROTATION;
            currentCrop = (currentCrop + 1 >= TEXTURES.length) ? 0 : currentCrop + 1;
        }
    }
}