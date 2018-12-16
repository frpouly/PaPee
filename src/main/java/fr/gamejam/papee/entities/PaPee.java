package fr.gamejam.papee.entities;

import fr.gamejam.papee.engine.Game;
import fr.gamejam.papee.engine.objects.GObject;
import fr.gamejam.papee.engine.utils.GDefines;
import fr.gamejam.papee.entities.environment.Effect;
import fr.gamejam.papee.entities.environment.EnvironmentObject;
import fr.gamejam.papee.entities.environment.items.Item;
import fr.gamejam.papee.game.level.Tile;
import fr.gamejam.papee.map.Map;
import org.lwjgl.input.Keyboard;

import java.awt.*;
import java.util.Iterator;

public class PaPee extends GObject {
    //0.93f
    private float drag = 0.93f;
    private float speed = 1f, dx = 0.0f, dy = 0.0f;
    private Map map;
    private Bladder bladder;

    public PaPee(float x, float y, Bladder bladder) {
        super(0, x, y, 32, 32, true);
        this.bladder = bladder;
    }

    private void move() {
        if(Keyboard.isKeyDown(Keyboard.KEY_Z)) {
            dy -= speed;
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_Q)) {
            dx -= speed;
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_S)) {
            dy += speed;
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_D)) {
            dx += speed;
        }

        if(isCollisionWithWall()) {
            dx = -dx;
            dy = -dy;
        }

        x += dx;
        y += dy;

        dx *= drag;
        dy *= drag;
    }

    private boolean isCollisionWithWall() {
        Tile[][] tmp = map.getTiles();

        if (!this.getBounds().intersects(new Rectangle(sizeX, sizeY, tmp[getPosX()][getPosY()].getSizeX(), tmp[getPosX()][getPosY()].getSizeX())) && tmp[getPosX()][getPosY()].isRigid()) {
            return true;
        }
        return false;
    }

    @Override
    public void update() {
        getBladder().increasePeeLevel();

        move();
        manageCollision();
        manageEffect();
    }

    @Override
    public void render() {
        super.render();
        bladder.render();
    }

    public int getPosX() {
        return (int) (getX() / GDefines.OBJECT_WIDTH);
    }

    public int getPosY() {
        return (int) (getY() / GDefines.OBJECT_HEIGHT);
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

    public Bladder getBladder() {
        return bladder;
    }

    public void setBladder(Bladder bladder) {
        this.bladder = bladder;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
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

    private  void manageEffect() {
        Iterator<Effect> iterator = Game.effects.iterator();

        while(iterator.hasNext()) {
            Effect effect = iterator.next();
            if(effect.getEffectTime() <= 0) {
                effect.stopEffect();
                iterator.remove();
            } else {
                effect.setEffectTime(effect.getEffectTime() - 1);
            }
        }
    }
}
