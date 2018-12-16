package fr.gamejam.papee;

import fr.gamejam.papee.engine.Menu;
import fr.gamejam.papee.engine.game.GGame;

public class Program {
    public static String STATE = "game";

    public static void main(String[] args) {
        GGame menu = new Menu();
        GGame.window.start(menu);
    }
}
