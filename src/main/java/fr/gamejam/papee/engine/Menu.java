package fr.gamejam.papee.engine;

import fr.gamejam.papee.engine.buttons.GButton;
import fr.gamejam.papee.engine.components.GWindow;
import fr.gamejam.papee.engine.game.GGame;
import fr.gamejam.papee.engine.graphics.GGraphics;
import fr.gamejam.papee.engine.graphics.GTexture;
import fr.gamejam.papee.engine.utils.GDefines;
import org.lwjgl.opengl.Display;

public class Menu extends GGame {

    public Menu() {
        objects.clear();
        if(GGame.window == null)
            GGame.window = new GWindow(GDefines.WIDTH, GDefines.HEIGHT, GDefines.TITLE);

        GButton play = new GButton("PLAY", window.getWidth()/2 - (22 * 4), GGame.window.getHeight() / 2 - 16, 32) {

            @Override
            public void onClick() {
                GGame.window.start(new Game());
            }
        };
    }

    final int width = 610 / 3;
    final int height = 249 / 3;
    final int startX = (GDefines.WIDTH / 3) - (width / 3);
    final int startY = (GDefines.HEIGHT / 5) - (height / 2);
    final int endX = startX + width;
    final int endY = startY + height;

    @Override
    public void render() {
        super.render();

        GGraphics.renderImage(GTexture.ICON_TEXTURE, startX, startY, endX, endY, GDefines.WHITE);
    }
}
