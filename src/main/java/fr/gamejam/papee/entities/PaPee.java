package fr.gamejam.papee.entities;

import fr.gamejam.papee.engine.objects.GObject;
import org.lwjgl.input.Keyboard;

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
}
