package fr.gamejam.papee.engine.entity;

import fr.gamejam.papee.util.GDefines;
import fr.gamejam.papee.entities.Entity;

import java.awt.*;

public class Collision {
    public static boolean isCollision(Entity entity1, Entity entity2) {
        if (entity1 == null || entity2 == null) {
            return false;
        }

        return entity1.getBounds().intersects(entity2.getBounds());
    }

    public static boolean isOutOfWindowBound(Entity entity) {
        return !entity.getBounds().intersects(new Rectangle(entity.getSizeX(), entity.getSizeY(), GDefines.WIDTH - 2 * entity.getSizeX(), GDefines.HEIGHT - 2 * entity.getSizeY()));
    }
}
