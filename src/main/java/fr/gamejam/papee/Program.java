package fr.gamejam.papee;

import fr.gamejam.papee.engine.Menu;
import fr.gamejam.papee.engine.Game;
import fr.gamejam.papee.engine.components.GWindow;
import fr.gamejam.papee.engine.game.GGame;
import fr.gamejam.papee.engine.utils.GDefines;

public class Program {
    public static void main(String[] args) {
        GGame menu = new Menu();
        GGame.window.start(menu);
    }
}
