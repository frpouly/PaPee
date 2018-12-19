package fr.gamejam.papee.engine.window;

import fr.gamejam.papee.engine.buttons.GButton;
import fr.gamejam.papee.engine.game.GGame;
import fr.gamejam.papee.engine.graphics.GGraphics;
import fr.gamejam.papee.engine.utils.GDefines;

public class Congrats extends GGame {

    public Congrats() {
        objects.clear();
        new GButton("MENU", window.getWidth()/2 - 80, 400, 32) {
            @Override
            public void onClick() {
                window.start(new Menu());
            }
        };
    }

    @Override
    public void render() {
        super.render();
        GGraphics.renderText("CONGRATS", window.getWidth()/2 - (56 * 4), window.getHeight() - 600, 56, GDefines.WHITE);
    }
}
