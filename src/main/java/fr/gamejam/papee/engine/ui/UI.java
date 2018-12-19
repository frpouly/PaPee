package fr.gamejam.papee.engine.ui;

import fr.gamejam.papee.engine.graphics.GTexture;
import fr.gamejam.papee.engine.utils.IRunnable;

import java.awt.*;

public class UI implements IRunnable {
    protected float x;
    protected float y;
    protected int sizeX;
    protected int sizeY;
    protected GTexture texture;

    public UI(float x, float y, int sizeX, int sizeY, GTexture texture) {
        this.x = x;
        this.y = y;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.texture = texture;
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

    public GTexture getTexture() {
        return texture;
    }

    public void setTexture(GTexture texture) {
        this.texture = texture;
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, sizeX, sizeY);
    }

    @Override
    public void init() {

    }

    @Override
    public void update() {

    }

    @Override
    public void render() {

    }

    @Override
    public void dispose() {

    }
}
