package fr.gamejam.papee.engine;

import fr.gamejam.papee.engine.buttons.GButton;
import fr.gamejam.papee.engine.components.GWindow;
import fr.gamejam.papee.engine.game.GGame;
import fr.gamejam.papee.engine.graphics.GGraphics;
import fr.gamejam.papee.engine.graphics.GTexture;
import fr.gamejam.papee.engine.guis.GGui;
import fr.gamejam.papee.engine.objects.GObject;
import fr.gamejam.papee.engine.utils.GDefines;

public class GameOver extends GGame {

    public GameOver() {
        objects.clear();
        GButton returnMenu = new GButton("MENU", 400, 400, 32) {
            @Override
            public void onClick() {
                window.start(new Menu());
            }
        };
    }

    @Override
    public void render() {
        super.render();
        GGraphics.renderText("GAME OVER", window.getWidth()/2 - 252, window.getHeight()/2 - 28, 56, GDefines.WHITE);
    }
}
