package fr.gamejam.papee.engine.objects;

import fr.gamejam.papee.engine.game.GGame;
import fr.gamejam.papee.engine.graphics.GGraphics;
import fr.gamejam.papee.engine.graphics.GTexture;
import fr.gamejam.papee.engine.utils.GDefines;

import java.awt.*;

public class GObject {

    protected int ID;
    protected float x;
    protected float y;
    protected int sizeX;
    protected int sizeY;
    protected boolean rigid;
    protected GTexture texture;

    /**
     * @param ID    the ID of the object
     * @param x     the x position
     * @param y     the y position
     * @param sizeX the sizeX
     * @param sizeY the sizeY
     * @param rigid the boolean that indicate if the object is rigid or no
     *              Game object with dimensions ID and rigidity
     */
    public GObject(int ID, float x, float y, int sizeX, int sizeY, boolean rigid) {
        this.ID = ID;
        this.x = x;
        this.y = y;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.rigid = rigid;
        GGame.objects.add(this);
    }

    /**
     * Update the game object
     */
    public void update() {
    }

    /**
     * Render the game object
     */
    public void render() {
        if (texture != null) {
            GGraphics.renderImage(texture, x, y, sizeX, sizeY, GDefines.WHITE);
        } else {
            GGraphics.renderQuad(x, y, sizeX, sizeY, GDefines.WHITE);
        }
    }

    /**
     * @param o the object that would be included in the checking of the collision
     * @return true if o collide with this object false if not
     */
    public boolean isCollision(GObject o) {
        if (this.getBounds().intersects(o.getBounds())) {
            return true;
        }
        return false;
    }

    /**
     * @return true if this object is out of the bounds of the state
     */
    public boolean isOutOfWindowBound() {
        if (!this.getBounds().intersects(new Rectangle(sizeX, sizeY, GDefines.WIDTH - 2 * sizeX, GDefines.HEIGHT - 2 * sizeY))) {
            return true;
        }
        return false;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getSizeX() {
        return sizeX;
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }

    public boolean isRigid() {
        return rigid;
    }

    public void setRigid(boolean rigid) {
        this.rigid = rigid;
    }

    public GTexture getTexture() {
        return texture;
    }

    public GObject setTexture(GTexture texture) {
        this.texture = texture;
        return this;
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, sizeX, sizeY);
    }
}
