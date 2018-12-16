package fr.gamejam.papee.engine;

import fr.gamejam.papee.engine.buttons.GButton;
import fr.gamejam.papee.engine.game.GGame;
import fr.gamejam.papee.engine.graphics.GGraphics;
import fr.gamejam.papee.engine.utils.GDefines;

public class Congrats extends GGame {

    public Congrats() {
        objects.clear();
        new GButton("MENU", 400, 400, 32) {
            @Override
            public void onClick() {
                window.start(new Menu());
            }
        };
    }

    @Override
    public void render() {
        super.render();
        GGraphics.renderText("CONGRATS", window.getWidth()/2 - 252, window.getHeight()/2 - 28, 56, GDefines.WHITE);
    }
}
