package fr.gamejam.papee.entities;

import fr.gamejam.papee.engine.graphics.GGraphics;
import fr.gamejam.papee.engine.graphics.GTexture;
import fr.gamejam.papee.util.GDefines;
import fr.gamejam.papee.util.IRunnable;

import java.awt.*;

public class Entity implements IRunnable {
    protected int ID;
    protected float x;
    protected float y;
    protected int sizeX;
    protected int sizeY;
    protected boolean rigid;
    protected GTexture texture;

    public Entity(int ID, float x, float y, int sizeX, int sizeY, boolean rigid) {
        this(ID, x, y, sizeX, sizeY, rigid, null);
    }

    public Entity(int ID, float x, float y, int sizeX, int sizeY, boolean rigid, GTexture texture) {
        this.ID = ID;
        this.x = x;
        this.y = y;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.rigid = rigid;
        this.texture = texture;
    }

    @Override
    public void init() {

    }

    @Override
    public void update() {
    }

    @Override
    public void render() {
        if (texture != null) {
            GGraphics.renderImage(texture, x, y, sizeX, sizeY, GDefines.WHITE);
        } else {
            GGraphics.renderQuad(x, y, sizeX, sizeY, GDefines.WHITE);
        }
    }

    @Override
    public void dispose() {

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

    public Entity setTexture(GTexture texture) {
        this.texture = texture;
        return this;
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, sizeX, sizeY);
    }
}
