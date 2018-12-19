package fr.gamejam.papee.engine.state;

import fr.gamejam.papee.engine.buttons.GButton;
import fr.gamejam.papee.engine.components.GWindow;
import fr.gamejam.papee.engine.graphics.GGraphics;
import fr.gamejam.papee.engine.utils.GDefines;
import fr.gamejam.papee.engine.utils.GTextures;
import fr.gamejam.papee.game.Game;
import fr.gamejam.papee.game.level.Difficulty;

public class MenuState extends State {
    public MenuState() {
        if (getWindow() == null)
            setWindow(new GWindow(GDefines.WIDTH, GDefines.HEIGHT, GDefines.TITLE));

        Game.setWon(false);

        GButton play_easy = new GButton("EASY", getWindow().getWidth()/5 - (4 * 16), getWindow().getHeight() / 2 - 16, 32) {
            @Override
            public void onClick() {
                GDefines.DIFFICULTY = Difficulty.EASY;
                getWindow().start(new GameState());
            }
        };

        GButton play_medium = new GButton("MEDIUM", getWindow().getWidth()/2 - (6 * 32 /2), getWindow().getHeight() / 2 - 16, 32) {
            @Override
            public void onClick() {
                GDefines.DIFFICULTY = Difficulty.MEDIUM;
                getWindow().start(new GameState());
            }
        };

        GButton play_hard = new GButton("HARD", getWindow().getWidth() - (9 * 32), getWindow().getHeight() / 2 - 16, 32) {
            @Override
            public void onClick() {
                GDefines.DIFFICULTY = Difficulty.HARD;
                getWindow().start(new GameState());
            }
        };

        getListUI().add(play_easy);
        getListUI().add(play_medium);
        getListUI().add(play_hard);
    }

    private final int width = 610 / 3;
    private final int height = 249 / 3;
    private final int startX = (GDefines.WIDTH / 3) - (width / 3);
    private final int startY = (GDefines.HEIGHT / 5) - (height / 2);
    private final int endX = startX + width;
    private final int endY = startY + height;

    @Override
    public void update() {
        super.update();
    }

    @Override
    public void render() {
        super.render();

        GGraphics.renderImage(GTextures.ICON_TEXTURE, startX, startY, endX, endY, GDefines.WHITE);
    }
}
