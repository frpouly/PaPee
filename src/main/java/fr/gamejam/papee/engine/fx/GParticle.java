package fr.gamejam.papee.engine.fx;

import fr.gamejam.papee.engine.graphics.GGraphics;
import fr.gamejam.papee.entities.Entity;
import org.lwjgl.util.vector.Vector2f;

import java.util.Random;

public class GParticle extends Entity {
    private Vector2f direction;
    private float lifetime;

    private float[] color;

    private float speed;

    /**
     * @param ID the id of the particle
     * @param x the x position of the particle
     * @param y the y position of the particle
     * @param size the size of the particle
     */
    public GParticle(int ID, float x, float y, int size) {
        super(ID, x, y, size, size, false);
    }

    @Override
    public void update() {
        double gaussianX = new Random().nextGaussian();
        double gaussianY = new Random().nextGaussian();

        x += (direction.x + gaussianX) * speed;
        y += (direction.y + gaussianY) * speed;

        this.lifetime -= 0.01f;
    }

    @Override
    public void render() {
        if(texture != null) {
            GGraphics.renderImage(texture, x, y, sizeX, sizeY, color);
        } else {
            GGraphics.renderQuad(x, y, sizeX, sizeY, color);
        }
    }

    public float getLifetime() {
        return lifetime;
    }

    public void setLifetime(float lifetime) {
        this.lifetime = lifetime;
    }

    public Vector2f getDirection() {
        return direction;
    }

    /**
     * @param direction the direction of the particle
     * @return the particle
     */
    public GParticle setDirection(Vector2f direction) {
        this.direction = direction;
        return this;
    }

    public float[] getColor() {
        return color;
    }

    /**
     * @param color the color of the particle
     * @return the particle
     */
    public GParticle setColor(float[] color) {
        this.color = color;
        return this;
    }

    public float getSpeed() {
        return speed;
    }

    /**
     * @param speed the speed of the particle
     * @return the particle
     */
    public GParticle setSpeed(float speed) {
        this.speed = speed;
        return this;
    }
}
