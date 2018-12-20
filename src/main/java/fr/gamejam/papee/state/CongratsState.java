package fr.gamejam.papee.state;

import fr.gamejam.papee.engine.buttons.GButton;
import fr.gamejam.papee.engine.graphics.GGraphics;
import fr.gamejam.papee.util.GDefines;

public class CongratsState extends State {
    public CongratsState() {
        GButton menu = new GButton("MENU", getWindow().getWidth()/2 - 80, 400, 32) {
            @Override
            public void onClick() {
                getWindow().setState(new MenuState());
                getWindow().run();
            }
        };

        getListUI().add(menu);
    }

    @Override
    public void render() {
        super.render();
        GGraphics.renderText("CONGRATS", getWindow().getWidth()/2 - (56 * 4), getWindow().getHeight() - 600, 56, GDefines.WHITE);
    }
}
