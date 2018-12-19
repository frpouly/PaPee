package fr.gamejam.papee.engine.state;

import fr.gamejam.papee.engine.buttons.GButton;
import fr.gamejam.papee.engine.graphics.GGraphics;
import fr.gamejam.papee.engine.utils.GDefines;
import fr.gamejam.papee.engine.utils.GTextures;
import fr.gamejam.papee.game.level.Difficulty;

public class MenuState extends State {
    private int width;
    private int height;
    private int startX;
    private int startY;
    private int endX;
    private int endY;

    public MenuState() {
        GButton play_easy = new GButton("EASY", getWindow().getWidth() / 5 - (4 * 16), getWindow().getHeight() / 2 - 16, 32) {
            @Override
            public void onClick() {
                GDefines.DIFFICULTY = Difficulty.EASY;
                getWindow().start(new GameState());
            }
        };

        GButton play_medium = new GButton("MEDIUM", getWindow().getWidth() / 2 - (6 * 32 / 2), getWindow().getHeight() / 2 - 16, 32) {
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

    @Override
    public void init() {
        width = 610 / 3;
        height = 249 / 3;
        startX = (GDefines.WIDTH / 3) - (width / 3);
        startY = (GDefines.HEIGHT / 5) - (height / 2);
        endX = startX + width;
        endY = startY + height;
    }

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
