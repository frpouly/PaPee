package fr.gamejam.papee.engine.components;

import fr.gamejam.papee.engine.graphics.GGraphics;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.LWJGLException;

public class GWindow extends GRunnable {

    private int width;
    private int height;
    private String title;

    public GWindow(int width, int height, String title) {
        this.width = width;
        this.height = height;
        this.title = title;
        this.display();
    }

    /**
     * Display the state with OpenGL context initialized !
     */
    public void display() {
        try {
            Display.setDisplayMode(new DisplayMode(this.width, this.height));
            Display.setTitle(this.title);
            Display.setVSyncEnabled(true);
            Display.create();
        } catch (LWJGLException e) {
            e.printStackTrace();
            Display.destroy();
            System.exit(1);
        }
        GGraphics.init(this.width, this.height);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
