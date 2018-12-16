package fr.gamejam.papee.entities;

import fr.gamejam.papee.engine.Game;
import fr.gamejam.papee.engine.graphics.GTexture;
import fr.gamejam.papee.engine.objects.GObject;
import fr.gamejam.papee.engine.utils.GDefines;
import fr.gamejam.papee.entities.environment.Effect;
import fr.gamejam.papee.entities.environment.EnvironmentObject;
import fr.gamejam.papee.entities.environment.items.Item;
import fr.gamejam.papee.entities.environment.obstacles.PeePuddle;
import fr.gamejam.papee.game.level.Tile;
import fr.gamejam.papee.map.Map;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import java.util.Iterator;
import java.util.Random;

public class PaPee extends GObject {
    //0.93f
    private float drag = 0.899999f;
    private float speed = 1f, dx = 0.0f, dy = 0.0f;
    private Map map;
    private Bladder bladder;
    private boolean won;

    public PaPee(float x, float y, Bladder bladder) {
        super(0, x, y, 64, 64, true);
        this.bladder = bladder;
        setTexture(GTexture.PLAYER);
    }

    private void move() {
        if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
            dy -= speed;
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
            dx -= speed;
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
            dy += speed;
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
            dx += speed;
        }

        int xStep = (int) Math.abs(dx * 100);
        for (int i = 0; i < xStep; i++) {
            if (!getMap().isSolidTile(dx / xStep, 0f)) {
                x += dx / xStep;
            } else {
                dx = 0;
            }
        }
        int yStep = (int) Math.abs(dy * 100);
        for (int i = 0; i < yStep; i++) {
            if (!getMap().isSolidTile(0f, dy / yStep)) {
                y += dy / yStep;
            } else {
                dy = 0;
            }
        }

        dx *= drag;
        dy *= drag;
    }

    private boolean isCollisionWithWall() {
        Tile[][] tmp = map.getTiles();
        if (tmp[getPosX()][getPosY()].isRigid() || tmp[getPosX() + 1][getPosY()].isRigid() || tmp[getPosX()][getPosY() + 1].isRigid()) {
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
        pee();
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

    private boolean canPee() {
        return (int)(Math.random() * 300) == 0;
    }

    private void pee() {
        if(canPee()) {
            PeePuddle peePuddle = new PeePuddle(5, getX(), getY());
            getBladder().increasePeeLevel(-2);
        }
    }

    private void manageCollision() {
        Iterator<GObject> iterator = Game.objects.iterator();

        while (iterator.hasNext()) {
            GObject o = iterator.next();

            if (o instanceof EnvironmentObject) {
                EnvironmentObject obj = ((EnvironmentObject) o);

                if (isCollision(obj)) {
                    obj.effect(this);

                    if (o instanceof Item) {
                        iterator.remove();
                    }
                }
            }
        }
    }

    private void manageEffect() {
        Iterator<Effect> iterator = Game.effects.iterator();

        while (iterator.hasNext()) {
            Effect effect = iterator.next();
            if (effect.getEffectTime() <= 0) {
                effect.stopEffect();
                iterator.remove();
            } else {
                effect.setEffectTime(effect.getEffectTime() - 1);
            }
        }
    }

    public boolean isWon() {
        return won;
    }

    public void hasWon() {
        this.won = true;
    }
}
