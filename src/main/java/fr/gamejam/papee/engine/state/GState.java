package fr.gamejam.papee.engine.state;

import fr.gamejam.papee.engine.components.GWindow;
import fr.gamejam.papee.engine.ui.UI;
import fr.gamejam.papee.util.GDefines;
import fr.gamejam.papee.util.IRunnable;
import fr.gamejam.papee.game.Game;

import java.util.ArrayList;
import java.util.List;

public abstract class GState implements IRunnable {
    private static GWindow window;
    private List<UI> listUI;

    public GState() {
        this.listUI = new ArrayList<>();

        if (getWindow() == null)
            setWindow(new GWindow(GDefines.WIDTH, GDefines.HEIGHT, GDefines.TITLE));

        Game.setWon(false);
    }

    public static GWindow getWindow() {
        return window;
    }

    public static void setWindow(GWindow window) {
        GState.window = window;
    }

    public List<UI> getListUI() {
        return listUI;
    }

    public void setListUI(List<UI> listUI) {
        this.listUI = listUI;
    }

    @Override
    public void init() {
        for (UI ui : listUI) {
            ui.init();
        }
    }

    @Override
    public void update() {
        for (UI ui : listUI) {
            ui.update();
        }
    }

    @Override
    public void render() {
        for (UI ui : listUI) {
            ui.render();
        }
    }

    @Override
    public void dispose() {
        for (UI ui : listUI) {
            ui.dispose();
        }
    }
}
