package fr.gamejam.papee.entity.environment.obstacles;

import fr.gamejam.papee.entity.environment.EnvironmentObject;

public abstract class Obstacle extends EnvironmentObject {
    public Obstacle(int ID, float x, float y, String name) {
        super(ID, x, y, 64, 64, true, name);
    }
}
