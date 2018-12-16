package fr.gamejam.papee.map;

import fr.gamejam.papee.engine.Game;
import fr.gamejam.papee.engine.objects.GObject;
import fr.gamejam.papee.engine.utils.GDefines;
import fr.gamejam.papee.entities.PaPee;
import fr.gamejam.papee.entities.environment.EnvironmentObject;
import fr.gamejam.papee.entities.environment.items.Item;
import fr.gamejam.papee.game.level.Tile;
import org.lwjgl.opengl.Display;

import java.util.Iterator;

import static org.lwjgl.opengl.GL11.*;

public class Map {
    private PaPee papee;
    private Tile[][] tiles;

    private float xScroll, yScroll;

    private static final int xMaxTiles = (GDefines.WIDTH / GDefines.TILE_WIDTH);
    private static final int yMaxTiles = (GDefines.HEIGHT / GDefines.TILE_HEIGHT);

    private int[] bounds = new int[] {
            0,
            0,
            -GDefines.MAP_WIDTH * GDefines.TILE_WIDTH + Display.getWidth(),
            -GDefines.MAP_HEIGHT * GDefines.TILE_HEIGHT + Display.getHeight()
    };

    public Map(PaPee papee, Tile[][] tiles) {
        this.papee = papee;
        this.tiles = tiles;

        this.xScroll = this.bounds[0];
        this.yScroll = this.bounds[1];
    }

    public void translateView(float xa, float ya) {
        this.xScroll = xa;
        this.yScroll = ya;

        if (xScroll > this.bounds[0]) xScroll = this.bounds[0];
        if (xScroll < this.bounds[2]) xScroll = this.bounds[2];
        if (yScroll > this.bounds[1]) yScroll = this.bounds[1];
        if (yScroll < this.bounds[3]) yScroll = this.bounds[3];
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

    private int startX = 0;
    private int endX = 0;
    private int startY = 0;
    private int endY = 0;

    private void calculateBounds() {
        int papeeX = papee.getPosX();
        int papeeY = papee.getPosY();

        startX = papeeX - (xMaxTiles / 2) - 3;
        endX = papeeX + (xMaxTiles / 2) + 3;

        startY = papeeY - (yMaxTiles / 2) - 3;
        endY = papeeY + (yMaxTiles / 2) + 3;
    }

    public void update() {
        calculateBounds();

        float xa = -papee.getX() + Display.getWidth() / 2 - 8;
        float ya = -papee.getY() + Display.getHeight() / 2 - 8;

        translateView(xa, ya);

        for (int x = startX; x < endX; x++) {
            for (int y = startY; y < endY; y++) {
                try {
                    tiles[x][y].update();
                } catch (ArrayIndexOutOfBoundsException ex) {
                    // ignore
                }
            }
        }

        for (GObject o : Game.objects) {
            if (o instanceof EnvironmentObject) {
                EnvironmentObject obj = ((EnvironmentObject) o);
                obj.update();
            }
        }

        papee.update();
    }

    public void render() {
        glPushMatrix();
        glTranslatef(xScroll, yScroll, 0);

        for (int x = startX; x < endX; x++) {
            for (int y = startY; y < endY; y++) {
                try {
                    tiles[x][y].render();
                } catch (ArrayIndexOutOfBoundsException ex) {
                    // ignore
                }
            }
        }

        for (GObject o : Game.objects) {
            if (o instanceof EnvironmentObject) {
                EnvironmentObject obj = ((EnvironmentObject) o);
                obj.render();
            }
        }

        papee.render();
        glPopMatrix();
    }
}
