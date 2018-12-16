package fr.gamejam.papee.engine.utils;

import fr.gamejam.papee.engine.objects.GObject;
import fr.gamejam.papee.entities.environment.obstacles.PeePuddle;
import fr.gamejam.papee.entities.environment.obstacles.Poop;

import java.util.HashMap;
import java.util.Map;

public class Registry {

    private Map<Integer, Class<? extends GObject>> list = new HashMap<>();

    public Registry() {
        this.register(101, PeePuddle.class);
        this.register(102, Poop.class);
    }

    public boolean isRegistered(int id) {
        return this.list.containsKey(id);
    }

    public void register(int ID, Class<? extends GObject> object) {
        this.list.put(ID, object);
    }

    public Class<? extends GObject> get(int ID) {
        return this.list.get(ID);
    }

    public Map<Integer, Class<? extends GObject>> getList() {
        return list;
    }
}
