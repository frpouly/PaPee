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
        System.out.println("NIQUE TES GRANDS MORTS");

        int papeeX = (int) papee.getX() / GDefines.OBJECT_WIDTH;
        int papeeY = (int) papee.getY() / GDefines.OBJECT_HEIGHT;

        int xMaxTiles = (GDefines.WIDTH / GDefines.TILE_WIDTH);
        int yMaxTiles = (GDefines.HEIGHT / GDefines.TILE_HEIGHT);

        int startX = papeeX - (xMaxTiles / 2);
        int endX = papeeX + (xMaxTiles / 2);

        int startY = papeeY + (yMaxTiles / 2);
        int endY = papeeY - (yMaxTiles / 2);

        System.out.println("xMaxTiles: " + xMaxTiles);
        System.out.println("papeeX: " + papeeX);
        System.out.println("startX: " + startX);
        System.out.println("endX: " + endX);
        /*
        System.out.println("yMaxTiles: " + yMaxTiles);
        System.out.println("papeeY: " + papeeY);
        System.out.println("startY: " + startY);
        System.out.println("endY: " + endY);
        */
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
        int papeeX = papee.getPosX();
        int papeeY = papee.getPosY();

        int xMaxTiles = (GDefines.WIDTH / GDefines.TILE_WIDTH);
        int yMaxTiles = (GDefines.HEIGHT / GDefines.TILE_HEIGHT);

        int startX = papeeX - (xMaxTiles / 2);
        int endX = papeeX + (xMaxTiles / 2);

        int startY = papeeY + (yMaxTiles / 2);
        int endY = papeeY - (yMaxTiles / 2);

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
