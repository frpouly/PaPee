package fr.gamejam.papee.entities.papee;

import fr.gamejam.papee.game.Game;
import fr.gamejam.papee.engine.graphics.GGraphics;
import fr.gamejam.papee.engine.fx.GParticle;
import fr.gamejam.papee.engine.utils.GTextures;
import fr.gamejam.papee.engine.objects.GObject;
import fr.gamejam.papee.engine.utils.GDefines;
import fr.gamejam.papee.effect.Effect;
import fr.gamejam.papee.entities.environment.EnvironmentObject;
import fr.gamejam.papee.entities.environment.items.Item;
import fr.gamejam.papee.entities.environment.obstacles.PeePuddle;
import fr.gamejam.papee.game.tile.Tile;
import fr.gamejam.papee.game.map.Map;
import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector2f;

import java.util.Iterator;

import static org.lwjgl.opengl.GL11.*;

public class Papee extends GObject {
    public static final float BASE_SPEED = 1f;

    //0.93f
    private float drag = 0.899999f;
    private float speed = 1f, dx = 0.0f, dy = 0.0f;
    private Map map;
    private Bladder bladder;
    private boolean won;

    public Papee(float x, float y, Bladder bladder) {
        super(0, x, y, 64, 64, true);
        this.bladder = bladder;
        setTexture(GTextures.PLAYER);
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
        glPushMatrix();
        glTranslatef(getX() + 32f, getY() + 32f, 0);
        float angle = (float) Math.toDegrees(Math.atan2(dy, dx));
        glRotatef(angle, 0, 0, 1);
        GGraphics.renderImage(texture, -32, -32, 64, 64, GDefines.WHITE);
        glPopMatrix();
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

    public float getDx() {
        return dx;
    }

    public void setDx(float dx) {
        this.dx = dx;
    }

    public float getDy() {
        return dy;
    }

    public void setDy(float dy) {
        this.dy = dy;
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
        for(int i = 0; i < Game.objects.size(); i++) {
            GObject o = Game.objects.get(i);
            if (o instanceof EnvironmentObject) {
                EnvironmentObject obj = ((EnvironmentObject) o);

                if (isCollision(obj)) {
                    obj.effect(this);
                    if (o instanceof Item) {
                        Game.objects.remove(o);
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
                if(effect.isGenerateParticle()) {
                    for(int i = 0 ; i < 10; i++) {
                        GParticle p = new GParticle(1000, getX() + GDefines.OBJECT_WIDTH / 2, getY() + GDefines.OBJECT_HEIGHT / 2, 32);
                        Vector2f dir = new Vector2f(-getDx(), -getDy());
                        dir.normalise(dir);
                        p.setDirection(dir);
                        p.setTexture(effect.getParticleName());
                        p.setColor(GDefines.WHITE);
                        p.setSpeed(2);
                        p.setLifetime(0.1f);
                    }
                }
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
