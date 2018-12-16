package fr.gamejam.papee.engine.graphics;

import fr.gamejam.papee.engine.utils.GDefines;
import org.lwjgl.BufferUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.ByteBuffer;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL12.GL_CLAMP_TO_EDGE;

public class GTexture {
    public static final GTexture DEFAULT_FONT = loadTexture(GDefines.FONTS + "default_font.png");

    public static final GTexture ICON_TEXTURE = loadTexture(GDefines.TEXTURES + "logo/logo.png");
    public static final GTexture VIAGRA_TEXTURE = loadTexture(GDefines.TEXTURES + "items/viagra.png");
    public static final GTexture BEER_TEXTURE = loadTexture(GDefines.TEXTURES + "items/beer.png");
    public static final GTexture NITRO_TEXTURE = loadTexture(GDefines.TEXTURES + "items/nitro.png");
    public static final GTexture PEE_PUDDLE_TEXTURE = loadTexture(GDefines.TEXTURES + "obstacles/pee_puddle.png");
    public static final GTexture TILE_SET = loadTexture(GDefines.TEXTURES + "obstacles/obstacles_tileset.png");
    public static final GTexture TILE_SET_2 = loadTexture(GDefines.TEXTURES + "obstacles/ui_pieces.png");
    public static final GTexture FIRE_PARTICLE = loadTexture(GDefines.TEXTURES + "particles/fire.png");
    public static final GTexture TOILETS = loadTexture(GDefines.TEXTURES + "obstacles/toilets.png");
    public static final GTexture UI_BLADDER_1 = loadTexture(GDefines.TEXTURES + "ui/bladder_1.png");
    public static final GTexture UI_BLADDER_3 = loadTexture(GDefines.TEXTURES + "ui/bladder_2.png");
    public static final GTexture UI_BLADDER_2 = loadTexture(GDefines.TEXTURES + "ui/bladder_3.png");
    public static final GTexture PLAYER = loadTexture(GDefines.TEXTURES + "player/player.png");
    public static final GTexture PLAYER_NITRO = loadTexture(GDefines.TEXTURES + "player/player_nitro.png");
    public static final GTexture CROSS_MINIMAP = loadTexture(GDefines.TEXTURES + "/minimap_cross.png");
    public static final GTexture CHECK_MINIMAP = loadTexture(GDefines.TEXTURES + "/check_minimap.png");
    public static final GTexture GUI_MINIMAP = loadTexture(GDefines.TEXTURES + "/gui_minimap.png");

    public static final GTexture GUI_BLADDER = loadTexture(GDefines.TEXTURES + "/gui_bladder.png");

    private int width, height;
    private int id;

    public GTexture(int width, int height, int id) {
        this.width = width;
        this.height = height;
        this.setId(id);
    }

    /**
     * @param path the path of the asset
     * @return the texture with the asset
     */
    public static GTexture loadTexture(String path) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(GTexture.class.getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        int w = image.getWidth();
        int h = image.getHeight();

        int[] pixels = new int[w * h];
        image.getRGB(0, 0, w, h, pixels, 0, w);

        ByteBuffer buffer = BufferUtils.createByteBuffer(w * h * 4);

        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                int pixel = pixels[x + y * w];
                buffer.put((byte) ((pixel >> 16) & 0xFF));
                buffer.put((byte) ((pixel >> 8) & 0xFF));
                buffer.put((byte) ((pixel) & 0xFF));
                buffer.put((byte) ((pixel >> 24) & 0xFF));
            }
        }

        buffer.flip();

        int id = glGenTextures();
        glBindTexture(GL_TEXTURE_2D, id);

        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_CLAMP_TO_EDGE);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP_TO_EDGE);

        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);

        glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA8, w, h, 0, GL_RGBA, GL_UNSIGNED_BYTE, buffer);

        return new GTexture(w, h, id);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void bind() {
        glBindTexture(GL_TEXTURE_2D, getId());
    }

    public void unbind() {
        glBindTexture(GL_TEXTURE_2D, 0);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}