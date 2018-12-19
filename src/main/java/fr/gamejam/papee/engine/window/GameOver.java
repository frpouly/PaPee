package fr.gamejam.papee.engine.window;

import fr.gamejam.papee.engine.buttons.GButton;
import fr.gamejam.papee.engine.game.GGame;
import fr.gamejam.papee.engine.graphics.GGraphics;
import fr.gamejam.papee.engine.utils.GDefines;
import org.lwjgl.opengl.Display;

public class GameOver extends GGame {

    public GameOver() {
        objects.clear();
        GButton returnMenu = new GButton("MENU", Display.getWidth() / 2 - 4 * 16, 400, 32) {
            @Override
            public void onClick() {
                window.start(new Menu());
            }
        };
    }

    @Override
    public void render() {
        super.render();
        GGraphics.renderText("GAME OVER", window.getWidth() / 2 - 252, window.getHeight() / 2 - 28, 56, GDefines.WHITE);
    }
}
