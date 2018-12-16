package fr.gamejam.papee.engine.animation;

import fr.gamejam.papee.engine.graphics.GTexture;

public class GAnimation {
    public static final GAnimation UI_BLADDER = new GAnimation(10, GTexture.UI_BLADDER_1, GTexture.UI_BLADDER_2, GTexture.UI_BLADDER_3);

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