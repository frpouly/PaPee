package fr.gamejam.papee.map;

import fr.gamejam.papee.engine.Game;
import fr.gamejam.papee.engine.objects.GObject;
import fr.gamejam.papee.engine.utils.GDefines;
import fr.gamejam.papee.entities.PaPee;
import fr.gamejam.papee.entities.environment.EnvironmentObject;
import fr.gamejam.papee.game.level.Tile;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

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

    public boolean isSolidTile(float xa, float ya) {

        int x0 = (int) (papee.getX() + xa + 8) / GDefines.TILE_WIDTH;
        int x1 = (int) (papee.getX() + xa + 54) / GDefines.TILE_WIDTH;
        int y0 = (int) (papee.getY() + ya + 54) / GDefines.TILE_HEIGHT;
        int y1 = (int) (papee.getY() + ya) / GDefines.TILE_HEIGHT;

        if (getTiles()[x0][y0].isRigid()) return true;
        if (getTiles()[x1][y0].isRigid()) return true;
        if (getTiles()[x1][y1].isRigid()) return true;
        if (getTiles()[x0][y1].isRigid()) return true;

        return false;
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

        int usedXMaxTiles = (papeeX < Display.getWidth() / 2) ? xMaxTiles : xMaxTiles / 2;
        int usedYMaxTiles = (papeeY < Display.getHeight() / 2) ? yMaxTiles : yMaxTiles / 2;

        startX = papeeX - (usedXMaxTiles) - 3;
        endX = papeeX + (usedXMaxTiles) + 3;

        startY = papeeY - (usedYMaxTiles) - 3;
        endY = papeeY + (usedYMaxTiles) + 3;
    }

    public void update() {
        calculateBounds();

        float xa = -papee.getX() + Display.getWidth() / 2 - 8;
        float ya = -papee.getY() + Display.getHeight() / 2 - 8;

        translateView(xa, ya);

        for (int x = startX; x < endX; x++) {
            if (x < 0) continue;

            for (int y = startY; y < endY; y++) {
                if (y < 0) continue;

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
        GL11.glLight(GL11.GL_LIGHT0, GL11.GL_POSITION,
                GDefines.floatBuffer(papee.getX() + papee.getSizeX() / 2,
                        papee.getY() + papee.getSizeY() / 2, 48, 1));

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
