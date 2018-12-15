package fr.gamejam.papee.map;

import fr.gamejam.papee.engine.utils.GDefines;
import fr.gamejam.papee.entities.PaPee;
import fr.gamejam.papee.game.level.Tile;

public class Map {
    private PaPee papee;
    private Tile[][] tiles;

    public Map(PaPee papee, Tile[][] tiles) {
        this.papee = papee;
        this.tiles = tiles;
    }

    public PaPee getPapee() {
        return papee;
    }

    public void setPapee(PaPee papee) {
        this.papee = papee;
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    public void setTiles(Tile[][] tiles) {
        this.tiles = tiles;
    }

    public void update() {
        int startX = 0;
        int startY = 0;
        int endX = GDefines.MAP_WIDTH;
        int endY = GDefines.MAP_HEIGHT;

        int papeeX = (int) papee.getX();
        int papeeY = (int) papee.getY();

        for (int x = startX; x < endX; x++) {
            for (int y = startY; y < endY; y++) {
                tiles[x][y].update();
            }
        }

        papee.update();
    }

    public void render() {
        for (int x = 0; x < GDefines.MAP_WIDTH; x++) {
            for (int y = 0; y < GDefines.MAP_HEIGHT; y++) {
                tiles[x][y].render();
            }
        }

        papee.render();
    }
}
