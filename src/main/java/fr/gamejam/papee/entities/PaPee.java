package fr.gamejam.papee.entities;

import fr.gamejam.papee.engine.Game;
import fr.gamejam.papee.engine.objects.GObject;
import fr.gamejam.papee.entities.environment.EnvironmentObject;
import fr.gamejam.papee.entities.environment.items.Item;
import fr.gamejam.papee.entities.environment.items.ItemViagra;
import org.lwjgl.input.Keyboard;

import java.util.Iterator;
import java.util.List;

public class PaPee extends GObject {

    private float drag = 0.93f;
    private float speed = 1f, dx = 0.0f, dy = 0.0f;

    public PaPee(float x, float y) {
        super(0, x, y, 32, 32, true);
    }

    private void move() {
        if(Keyboard.isKeyDown(Keyboard.KEY_W)) {
            dy -= speed;
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_A)) {
            dx -= speed;
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_S)) {
            dy += speed;
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_D)) {
            dx += speed;
        }

        x += dx;
        y += dy;

        dx *= drag;
        dy *= drag;
    }

    @Override
    public void update() {
        move();
        manageCollision();
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getDrag() {
        return drag;
    }

    public void setDrag(float drag) {
        this.drag = drag;
    }

    private void manageCollision() {
        Iterator<GObject> iterator = Game.objects.iterator();

        while(iterator.hasNext()) {
            GObject o = iterator.next();
            if(o instanceof EnvironmentObject) {
                EnvironmentObject obj = ((EnvironmentObject)o);
                if(isCollision(obj)) {
                    obj.effect(this);
                    if(o instanceof Item) {
                        iterator.remove();
                    }
                }
            }
        }
    }
}
