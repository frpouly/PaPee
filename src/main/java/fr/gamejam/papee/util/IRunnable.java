package fr.gamejam.papee.util;

public interface IRunnable extends IUpdatable, IRenderable {
    void init();
    void dispose();
}
