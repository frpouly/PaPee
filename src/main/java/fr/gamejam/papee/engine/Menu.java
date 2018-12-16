package fr.gamejam.papee.engine;

import fr.gamejam.papee.engine.buttons.GButton;
import fr.gamejam.papee.engine.components.GWindow;
import fr.gamejam.papee.engine.game.GGame;
import fr.gamejam.papee.engine.utils.GDefines;

public class Menu extends GGame {

    public Menu() {
        objects.clear();
        if(GGame.window == null)
            GGame.window = new GWindow(GDefines.WIDTH, GDefines.HEIGHT, GDefines.TITLE);


        GButton play = new GButton("PLAY", GGame.window.getWidth() / 2 - 64, GGame.window.getHeight() / 2 - 16, 32) {
            @Override
            public void onClick() {
                GGame.window.start(new Game());
            }
        };
    }
}
