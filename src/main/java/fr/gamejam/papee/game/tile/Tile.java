package fr.gamejam.papee.game.tile;

import fr.gamejam.papee.engine.graphics.GGraphics;
import fr.gamejam.papee.util.GTextures;
import fr.gamejam.papee.util.GDefines;
import fr.gamejam.papee.entity.Entity;

public class Tile extends Entity {
    public Tile(int ID, float x, float y, boolean rigid) {
        super(ID, x, y, GDefines.TILE_WIDTH, GDefines.TILE_HEIGHT, rigid);
        setTexture(GTextures.TILE_SET);
    }

    @Override
    public void render() {
        GGraphics.renderOffsetImage(texture, x, y, sizeX, sizeY, GDefines.WHITE, (ID % 5) * 16, (ID / 5) * 16, 16, 16);
    }
}
