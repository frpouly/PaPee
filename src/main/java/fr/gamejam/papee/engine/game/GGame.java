package fr.gamejam.papee.engine.game;

import fr.gamejam.papee.engine.buttons.GButton;
import fr.gamejam.papee.engine.components.GWindow;
import fr.gamejam.papee.engine.fx.GParticle;
import fr.gamejam.papee.engine.objects.GObject;
import fr.gamejam.papee.entities.environment.EnvironmentObject;

import java.util.ArrayList;

public abstract class GGame {

    public static ArrayList<GObject> objects = new ArrayList<GObject>();
    public static GWindow window;

    public GGame() {}

    /**
     * Called every frame (updating position ...)
     */
    public void update() {
        ///*
        for (int i = 0; i < objects.size(); i++) {
            GObject o = objects.get(i);
            o.update();
            if (o instanceof GParticle) {
                if (((GParticle) o).getLifetime() < 0) {
                    objects.remove(o);
                }
            }
        }
        //*/
    }

    /**
     * Called every frame (rendering objects ...)
     */
    public void render() {
        ///*
        for (int i = 0; i < objects.size(); i++) {
            GObject o = objects.get(i);
            if (!(o instanceof EnvironmentObject)) {
                o.render();
            }
        }
        //*/
    }
}
