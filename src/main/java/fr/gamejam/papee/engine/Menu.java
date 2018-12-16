package fr.gamejam.papee.engine;

import fr.gamejam.papee.engine.buttons.GButton;
import fr.gamejam.papee.engine.components.GWindow;
import fr.gamejam.papee.engine.game.GGame;
import fr.gamejam.papee.engine.graphics.GGraphics;
import fr.gamejam.papee.engine.graphics.GTexture;
import fr.gamejam.papee.engine.utils.GDefines;
import fr.gamejam.papee.game.Difficulty;
import org.lwjgl.opengl.Display;

public class Menu extends GGame {

    public Menu() {
        objects.clear();
        if(GGame.window == null)
            GGame.window = new GWindow(GDefines.WIDTH, GDefines.HEIGHT, GDefines.TITLE);

        GButton play_easy = new GButton("EASY", window.getWidth()/5 - (22 * 4), GGame.window.getHeight() / 2 - 16, 32) {

            @Override
            public void onClick() {
                GDefines.DIFFICULTY = Difficulty.EASY;
                GGame.window.start(new Game());
            }
        };

        GButton play_medium = new GButton("MEDIUM", window.getWidth()/2 - (22 * 4), GGame.window.getHeight() / 2 - 16, 32) {

            @Override
            public void onClick() {
                GDefines.DIFFICULTY = Difficulty.MEDIUM;
                GGame.window.start(new Game());
            }
        };

        GButton play_hard = new GButton("HARD", window.getWidth() - (22 * 16), GGame.window.getHeight() / 2 - 16, 32) {

            @Override
            public void onClick() {
                GDefines.DIFFICULTY = Difficulty.HARD;
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
