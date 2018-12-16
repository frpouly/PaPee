package fr.gamejam.papee.engine.ui;

import fr.gamejam.papee.engine.graphics.GGraphics;
import fr.gamejam.papee.engine.graphics.GTexture;
import fr.gamejam.papee.engine.utils.GDefines;
import fr.gamejam.papee.entities.PaPee;
import org.lwjgl.opengl.Display;

public class UIMiniMap implements UI {

    private PaPee papee;

    /*
        Toilets : x, y
     */
    private float toiletX = 512;
    private float toiletY = 112;

    public UIMiniMap(PaPee papee) {
        this.papee = papee;
    }

    @Override
    public void update() {

    }

    @Override
    public void render() {
        GGraphics.renderImage(GTexture.GUI_MINIMAP, GDefines.WIDTH - 250,10, 240, 200, new float[] {1, 1, 1, 1});
        GGraphics.renderImage(GTexture.CROSS_MINIMAP, GDefines.WIDTH - 250 + 16 + papee.getPosX() * (240 - 34) / (GDefines.MAP_WIDTH + 16), 10 + 16 + papee.getPosY() * (200 - 32) / (GDefines.MAP_HEIGHT + 16), 10, 10, GDefines.WHITE);
        GGraphics.renderImage(GTexture.CHECK_MINIMAP, GDefines.WIDTH - 250 + 16 + toiletX * (240 - 34) / (GDefines.MAP_WIDTH + 16), 10 + 16 + toiletY * (200 - 32) / (GDefines.MAP_HEIGHT + 16), 10, 10, GDefines.WHITE);
        GGraphics.renderText("papee", GDefines.WIDTH - 250 + 16 + papee.getPosX() * (240 - 34) / (GDefines.MAP_WIDTH + 16) - 4 * 4, 10 + 16 + papee.getPosY() * (200 - 32) / (GDefines.MAP_HEIGHT + 16) - 8, 8, GDefines.BLACK);
        GGraphics.renderText("toilets", GDefines.WIDTH - 250 + 16 + toiletX * (240 - 34) / (GDefines.MAP_WIDTH + 16) - 6 * 4, 10 + 16 + toiletY * (200 - 32) / (GDefines.MAP_HEIGHT + 16) - 8, 8, GDefines.BLACK);

    }
}
