package fr.gamejam.papee.engine.game;

public abstract class GGame {

    public GGame() {}

    /**
     * Called every frame (updating position ...)
     */
    public abstract void update();

    /**
     * Called every frame (rendering objects ...)
     */
    public abstract void render();
}
