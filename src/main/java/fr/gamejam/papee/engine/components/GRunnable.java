package fr.gamejam.papee.engine.components;

import fr.gamejam.papee.engine.graphics.GGraphics;
import fr.gamejam.papee.engine.utils.GDefines;
import fr.gamejam.papee.engine.state.State;
import org.lwjgl.opengl.Display;

public class GRunnable {
    /**
     * Main loop whit FPS calculator and frequencer
     * @param state that is included into the state
     */
    public static void start(State state) {
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
