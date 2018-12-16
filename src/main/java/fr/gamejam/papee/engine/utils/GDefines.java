package fr.gamejam.papee.engine.utils;

import org.lwjgl.BufferUtils;

import java.nio.FloatBuffer;

public class GDefines {
    /**
     * Constants
     */

    public static final String TITLE = "PaPee";
    public static final String VERSION = "0.1";

    public static final int WIDTH = 1200;
    public static final int HEIGHT = 700;

    public static final int OBJECT_WIDTH = 32;
    public static final int OBJECT_HEIGHT = 32;

    public static final int TILE_WIDTH = 32;
    public static final int TILE_HEIGHT = 32;

    public static int MAP_HEIGHT = 0;
    public static int MAP_WIDTH = 0;

    public static final int FPS = 60;

    /**
     * Colors
     */
    public static final float[] WHITE = new float[] { 229f / 255f, 255f / 255f, 239f / 255f, 1.0f };
    public static final float[] BLACK = new float[] { 47f / 255f, 40f / 255f, 58f / 255f, 1.0f };
    public static final float[] RED = new float[] { 128f / 255f, 58f / 255f, 70f / 255f, 1.0f };
    public static final float[] BLUE = new float[] { 66f / 255f, 91f / 255f, 121f / 255f, 1.0f };
    public static final float[] LIGHT_BLUE = new float[] { 65f / 255f, 142f / 255f, 176f / 255f, 1.0f };
    public static final float[] GREEN = new float[] { 57f / 255f, 125f / 255f, 64f / 255f, 1.0f };
    public static final float[] LIGHT_GREEN = new float[] { 82f / 255f, 165f / 255f, 72f / 255f, 1.0f };
    public static final float[] YELLOW = new float[] { 228f / 255f, 219f / 255f, 81f / 255f, 1.0f };
    public static final float[] PURPLE = new float[] { 134f / 255f, 93f / 255f, 147f / 255f, 1.0f };
    public static final float[] GRAY = new float[] { 145f / 255f, 176f / 255f, 154f / 255f, 1.0f };

    /**
     * Resources
     */

    public static final String ASSETS = "/assets/";
    public static final String FONTS = ASSETS + "fonts/";
    public static final String LANG = ASSETS + "lang/";
    public static final String TEXTURES = ASSETS + "textures/";

    public static FloatBuffer floatBuffer(float a, float b, float c, float d) {
        float[] data = new float[] { a, b, c, d };
        FloatBuffer fb = BufferUtils.createFloatBuffer(data.length);
        fb.put(data);
        fb.flip();
        return fb;
    }
}
