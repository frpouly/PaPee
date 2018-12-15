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

    int papeeX = 0,
        papeeY = 0,
        xMaxTiles = 0,
        yMaxTiles = 0,
        startX = 0,
        endX = 0,
        startY = 0,
        endY = 0;

    private void calculateBounds() {
        papeeX = papee.getPosX();
        papeeY = papee.getPosY();

        xMaxTiles = (GDefines.WIDTH / GDefines.TILE_WIDTH);
        yMaxTiles = (GDefines.HEIGHT / GDefines.TILE_HEIGHT);

        startX = papeeX - (xMaxTiles / 2) - 3;
        endX = papeeX + (xMaxTiles / 2) + 3;

        startY = papeeY - (yMaxTiles / 2) - 3;
        endY = papeeY + (yMaxTiles / 2) + 3;
    }

    public void update() {
        calculateBounds();

        for (int x = startX; x < endX; x++) {
            for (int y = startY; y < endY; y++) {
                try {
                    tiles[x][y].update();
                } catch (ArrayIndexOutOfBoundsException ex) {
                    // ignore
                }
            }
        }

        papee.update();
    }

    public void render() {
        for (int x = startX; x < endX; x++) {
            for (int y = startY; y < endY; y++) {
                try {
                    tiles[x][y].render();
                } catch (ArrayIndexOutOfBoundsException ex) {
                    // ignore
                }
            }
        }

        papee.render();
    }
}
