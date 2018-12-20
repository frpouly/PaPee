package fr.gamejam.papee.engine.graphics;

import fr.gamejam.papee.util.GTextures;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

import static org.lwjgl.opengl.GL11.*;

public class GGraphics {
    public static String chars = "abcdefghijklmnopqrstuvwxyz " + "0123456789:!?.,()°+-/*#|{} "
            + "=%@°                       " + "                           " + "";

    /**
     * @param text the text to render
     * @param x the x position
     * @param y the y position
     * @param size size of each character of the text
     * @param color the color of the text
     * Rendering text with coordinates LEFT_TOP (x, y) and size with the color color
     */
    public static void renderText(String text, float x, float y, int size, float[] color) {
        text = text.toLowerCase();
        glEnable(GL_TEXTURE_2D);
        GTextures.DEFAULT_FONT.bind();
        glBegin(GL_QUADS);
        glColor4f(color[0], color[1], color[2], color[3]);
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            int offs = i * size;
            charData(c, x + offs, y, size);
        }
        glColor4f(1, 1, 1, 1);
        glEnd();
        GTextures.DEFAULT_FONT.unbind();
        glDisable(GL_TEXTURE_2D);
    }

    /**
     * @param c the character
     * @param f the x position
     * @param y the y position
     * @param size the size of the character
     */
    private static void charData(char c, float f, float y, int size) {
        int i = chars.indexOf(c);
        int xo = i % 27;
        int yo = i / 27;
        glTexCoord2f((0 + xo) / 27.0f, (0 + yo) / 4.0f);
        glVertex2f(f, y);
        glTexCoord2f((1 + xo) / 27.0f, (0 + yo) / 4.0f);
        glVertex2f(f + size, y);
        glTexCoord2f((1 + xo) / 27.0f, (1 + yo) / 4.0f);
        glVertex2f(f + size, y + size);
        glTexCoord2f((0 + xo) / 27.0f, (1 + yo) / 4.0f);
        glVertex2f(f, y + size);
    }

    /**
     * @param texture the texture of the asset
     * @param x1 the x position
     * @param y1 the y position
     * @param x2 the sizeX
     * @param y2 the sizeY
     * @param color the color of the texture
     * Render an image with texture, and coordinates LEFT_TOP (x1, y1) and RIGHT-BOTTOM (x2, y2)
     * color is just to change saturation of the image
     */
    public static void renderImage(GTexture texture, float x1, float y1, float x2, float y2, float[] color) {
        if (texture != null) {
            texture.bind();
        }
        glEnable(GL_TEXTURE_2D);
        glBegin(GL_QUADS);
        glColor4f(color[0], color[1], color[2], color[3]);
        glTexCoord2f(0, 0);
        glVertex2f(x1, y1);
        glTexCoord2f(0, 1);
        glVertex2f(x1, y1 + y2);
        glTexCoord2f(1, 1);
        glVertex2f(x1 + x2, y1 + y2);
        glTexCoord2f(1, 0);
        glVertex2f(x1 + x2, y1);
        glColor4f(1, 1, 1, 1.0f);
        glEnd();
        if (texture != null) {
            texture.unbind();
        }
        glDisable(GL_TEXTURE_2D);
    }

    /**
     * @param x1 the x position
     * @param y1 the y position
     * @param x2 the sizeX
     * @param y2 the sizeY
     * @param color the color of the quad
     * Rendering quad with coordinates LEFT_TOP (x1, y1) and RIGHT-BOTTOM (x2, y2) and colored in color
     */
    public static void renderQuad(float x1, float y1, float x2, float y2, float[] color) {
        glBegin(GL_QUADS);
        glColor4f(color[0], color[1], color[2], color[3]);
        glVertex2f(x1, y1);
        glVertex2f(x1, y1 + y2);
        glVertex2f(x1 + x2, y1 + y2);
        glVertex2f(x1 + x2, y1);
        glColor4f(1, 1, 1, 1.0f);
        glEnd();
    }


    /**
     * @param texture the texture of the asset
     * @param x the x position
     * @param y the y position
     * @param width the sizeX
     * @param height the sizeY
     * @param color the color
     * @param x_off the x position of the subimage
     * @param y_off the y position of the subimage
     * @param size_x_off the sizeX of the subimage
     * @param size_y_off the sizeY of the subimage
     * Rendering a subimage according to a tileset image
     */
    public static void renderOffsetImage(GTexture texture, float x, float y, float width, float height,
                                         float[] color, float x_off, float y_off, float size_x_off,
                                         float size_y_off) {
        float texture_size_x = texture.getWidth();
        float texture_size_y = texture.getHeight();
        glEnable(GL_TEXTURE_2D);
        texture.bind();
        glBegin(GL_QUADS);
        glColor4f(color[0], color[1], color[2], color[3]);
        glTexCoord2f(x_off / texture_size_x, y_off / texture_size_y);
        glVertex2f(x, y);
        glTexCoord2f((x_off + size_x_off) / texture_size_x, y_off / texture_size_y);
        glVertex2f(x + width, y);
        glTexCoord2f((x_off + size_x_off) / texture_size_x, (y_off + size_y_off) / texture_size_y);
        glVertex2f(x + width, y + height);
        glTexCoord2f(x_off / texture_size_x, (y_off + size_y_off) / texture_size_y);
        glVertex2f(x, y + height);
        glEnd();
        texture.unbind();
        glDisable(GL_TEXTURE_2D);
    }

    /**
     * @param width the width of the state
     * @param height the height of the state
     * Initializing OpenGL context with the dimension of the state
     */
    public static void init(int width, int height) {
        glViewport(0, 0, width, height);
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        GLU.gluOrtho2D(0, width, height, 0);
        glMatrixMode(GL_MODELVIEW);
        glLoadIdentity();
        glEnable(GL_TEXTURE_2D);
        glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);

    }

    /**
     * Clearing OpenGL context
     */
    public static void clear() {
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
        glClearColor(0 / 255f, 0 / 255f, 0 / 255f, 1.0f);
    }
}
