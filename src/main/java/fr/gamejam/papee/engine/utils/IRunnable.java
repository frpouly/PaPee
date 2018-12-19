package fr.gamejam.papee.engine.utils;

public interface IRunnable extends IUpdatable, IRenderable {
    void init();
    void dispose();
}
