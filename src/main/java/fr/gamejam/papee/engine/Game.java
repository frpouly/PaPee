package fr.gamejam.papee.engine;

import fr.gamejam.papee.engine.buttons.GButton;
import fr.gamejam.papee.engine.fx.GParticle;
import fr.gamejam.papee.engine.game.GGame;
import fr.gamejam.papee.engine.guis.GGui;
import fr.gamejam.papee.engine.objects.GObject;
import fr.gamejam.papee.engine.utils.GDefines;
import fr.gamejam.papee.entities.Bladder;
import fr.gamejam.papee.entities.PaPee;
import org.lwjgl.util.vector.Vector2f;

import java.util.ArrayList;
import java.util.Random;

public class Game extends GGame {

    public static ArrayList<GObject> objects = new ArrayList<GObject>();

    PaPee papee = new PaPee(0, 0);
    Bladder bladder = new Bladder(10, 100);

    public Game() {

    }

    public void update() {
        /*
            Updating all the game objects
         */
        for (int i = 0; i < objects.size(); i++) {
            GObject o = objects.get(i);
            o.update();
            if (o instanceof GParticle) {
                if (((GParticle) o).getLifetime() < 0) {
                    objects.remove(o);
                }
            }
        }
    }

    public void render() {
        /*
            Rendering all the game objects
         */
        for (int i = 0; i < objects.size(); i++) {
            GObject o = objects.get(i);
            o.render();
        }
    }
}
