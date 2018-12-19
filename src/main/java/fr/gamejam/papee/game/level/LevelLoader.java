package fr.gamejam.papee.game.level;

import fr.gamejam.papee.engine.objects.GObject;
import fr.gamejam.papee.engine.utils.GDefines;
import fr.gamejam.papee.engine.utils.Registry;
import fr.gamejam.papee.game.tile.Tile;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.IOException;
import java.io.InputStream;

public class LevelLoader {

    private String path;
    public static Registry registry = new Registry();

    private Tile[][] tiles;

    public LevelLoader(String path) {
        this.path = path;
        loadLevel(path);
    }

    public void loadLevel(String path) {
        JsonArray layer = initJSONFile(path).getJsonArray("layers");
        int id;
        int mapWidth = layer.getJsonObject(0).getInt("width");
        int mapHeight = layer.getJsonObject(0).getInt("height");

        GDefines.MAP_WIDTH = mapWidth;
        GDefines.MAP_HEIGHT = mapHeight;

        this.tiles = new Tile[mapWidth][mapHeight];

        for (int i = 0; i < mapHeight; i++) {
            for (int j = 0; j < mapWidth; j++) {
                id = layer.getJsonObject(0).getJsonArray("data").getInt(i * mapWidth + j);

                GObject ctArgs = null;
                //Tile t = new Tile(id - 1, i * 16, j * 16, true);
                try {
                    Class c = registry.get(id);
                    //Constructor constructor = c.getConstructor(new Class[]{int.class,float.class,float.class});
                    //ctArgs = (GObject) constructor.newInstance(id, i * 32, j * 32);
                    Tile t;
                    if(id - 1 == 6 || id - 1 == 21 || id - 1 == 36 || id - 1 == 51) {
                        t = new Tile(id - 1, j * GDefines.TILE_WIDTH, i * GDefines.TILE_HEIGHT, false);
                    } else {
                        t = new Tile(id - 1, j * GDefines.TILE_WIDTH, i * GDefines.TILE_HEIGHT, true);
                    }
                    tiles[j][i] = t;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public JsonObject initJSONFile(String path) {
        JsonObject jsonObject;
        InputStream res = LevelLoader.class.getResourceAsStream(path);
        JsonReader reader = Json.createReader(res);
        jsonObject = reader.readObject();
        reader.close();
        try {
            res.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    public Tile[][] getTiles() {
        return tiles;
    }
}
