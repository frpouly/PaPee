package fr.gamejam.papee.util;

import fr.gamejam.papee.entities.Entity;
import fr.gamejam.papee.entities.environment.obstacles.PeePuddle;
import fr.gamejam.papee.entities.environment.obstacles.Poop;

import java.util.HashMap;
import java.util.Map;

public class Registry {
    private Map<Integer, Class<? extends Entity>> list = new HashMap<>();

    public Registry() {
        this.register(101, PeePuddle.class);
        this.register(102, Poop.class);
    }

    public boolean isRegistered(int id) {
        return this.list.containsKey(id);
    }

    public void register(int ID, Class<? extends Entity> object) {
        this.list.put(ID, object);
    }

    public Class<? extends Entity> get(int ID) {
        return this.list.get(ID);
    }

    public Map<Integer, Class<? extends Entity>> getList() {
        return list;
    }
}
