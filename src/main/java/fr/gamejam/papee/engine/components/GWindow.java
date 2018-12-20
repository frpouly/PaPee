package fr.gamejam.papee.engine.components;

import fr.gamejam.papee.engine.graphics.GGraphics;
import fr.gamejam.papee.state.State;
import fr.gamejam.papee.util.GDefines;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.LWJGLException;

public class GWindow implements Runnable {
    private static State state;
    private int width;
    private int height;
    private String title;

    public GWindow(int width, int height, String title) {
        this.width = width;
        this.height = height;
        this.title = title;
        this.display();
    }

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

    public static GWindow create() {
        return new GWindow(GDefines.WIDTH, GDefines.HEIGHT, GDefines.TITLE);
    }

    public static State getState() {
        return state;
    }

    public static void setState(State state) {
        GWindow.state = state;
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

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double delta = 0.0;
        double ns = 1000000000.0 / GDefines.FPS;
        long timer = System.currentTimeMillis();
        int updates = 0;
        int frames = 0;

        state.init();

        while (!Display.isCloseRequested()) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if (delta >= 1.0) {
                state.update();
                updates++;
                delta--;
            }
            state.render();
            frames++;
            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                Display.setTitle(GDefines.TITLE + " | FPS : " + frames);
                updates = 0;
                frames = 0;
            }
            Display.update();
            GGraphics.clear();
        }

        state.dispose();
        Display.destroy();
        System.exit(0);
    }
}
