package fr.gamejam.papee.game.level;

import fr.gamejam.papee.engine.graphics.GGraphics;
import fr.gamejam.papee.engine.graphics.GTexture;
import fr.gamejam.papee.engine.objects.GObject;
import fr.gamejam.papee.engine.utils.GDefines;

public class Tile extends GObject {

    public Tile(int ID, float x, float y, boolean rigid) {
        super(ID, x, y, 32, 32, rigid);
        setTexture(GTexture.TILE_SET);
    }

    @Override
    public void render() {
        GGraphics.renderOffsetImage(texture, x, y, sizeX, sizeY, GDefines.WHITE, (ID % 5) * 16, ((int) (ID / 5)) * 16, 16, 16);
    }
}
