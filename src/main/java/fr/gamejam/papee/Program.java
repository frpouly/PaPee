package fr.gamejam.papee;

import fr.gamejam.papee.engine.Game;
import fr.gamejam.papee.engine.components.GWindow;
import fr.gamejam.papee.engine.utils.GDefines;

public class Program {
    public static void main(String[] args) {
        GWindow window = new GWindow(GDefines.WIDTH, GDefines.HEIGHT, GDefines.TITLE);
        window.start(new Game());
    }
}
