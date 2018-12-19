package fr.gamejam.papee.engine.utils;

import fr.gamejam.papee.engine.graphics.GTexture;
import static fr.gamejam.papee.engine.graphics.GTexture.*;

public class GTextures {
    public static final GTexture DEFAULT_FONT = loadTexture(GDefines.FONTS + "default_font.png");

    public static final GTexture ICON_TEXTURE = loadTexture(GDefines.TEXTURES + "logo/logo.png");
    public static final GTexture VIAGRA_TEXTURE = loadTexture(GDefines.TEXTURES + "items/viagra.png");
    public static final GTexture BEER_TEXTURE = loadTexture(GDefines.TEXTURES + "items/beer.png");
    public static final GTexture WHISKY_TEXTURE = loadTexture(GDefines.TEXTURES + "items/whisky.png");
    public static final GTexture NITRO_TEXTURE = loadTexture(GDefines.TEXTURES + "items/nitro.png");
    public static final GTexture PEE_PUDDLE_TEXTURE = loadTexture(GDefines.TEXTURES + "obstacles/pee_puddle.png");
    public static final GTexture TILE_SET = loadTexture(GDefines.TEXTURES + "obstacles/obstacles_tileset.png");
    public static final GTexture TILE_SET_2 = loadTexture(GDefines.TEXTURES + "obstacles/ui_pieces.png");
    public static final GTexture FIRE_PARTICLE = loadTexture(GDefines.TEXTURES + "particles/fire.png");
    public static final GTexture TOILETS = loadTexture(GDefines.TEXTURES + "obstacles/toilets.png");
    public static final GTexture UI_BLADDER_1 = loadTexture(GDefines.TEXTURES + "ui/bladder_1.png");
    public static final GTexture UI_BLADDER_3 = loadTexture(GDefines.TEXTURES + "ui/bladder_2.png");
    public static final GTexture UI_BLADDER_2 = loadTexture(GDefines.TEXTURES + "ui/bladder_3.png");
    public static final GTexture PLAYER = loadTexture(GDefines.TEXTURES + "player/player.png");
    public static final GTexture PLAYER_NITRO = loadTexture(GDefines.TEXTURES + "player/player_nitro.png");
    public static final GTexture CROSS_MINIMAP = loadTexture(GDefines.TEXTURES + "/minimap_cross.png");
    public static final GTexture CHECK_MINIMAP = loadTexture(GDefines.TEXTURES + "/check_minimap.png");
    public static final GTexture GUI_MINIMAP = loadTexture(GDefines.TEXTURES + "/gui_minimap.png");

    public static final GTexture GUI_BLADDER = loadTexture(GDefines.TEXTURES + "/gui_bladder.png");
}
