package fr.gamejam.papee.engine.ui;

import fr.gamejam.papee.engine.graphics.GGraphics;
import fr.gamejam.papee.util.GTextures;
import fr.gamejam.papee.util.GDefines;
import fr.gamejam.papee.entity.papee.Bladder;
import fr.gamejam.papee.game.level.Difficulty;

public class UIBladder extends UI {
    private Bladder bladder;
    //private GAnimation animation;

    public UIBladder(Bladder bladder) {
        super(bladder.getX(), bladder.getY(), bladder.getSizeX(), bladder.getSizeY(), null);
        this.bladder = bladder;
    //    this.animation = GAnimation.UI_BLADDER;
    }

    @Override
    public void update() {
    //    animation.update();
    }

    @Override
    public void render() {
        if (GDefines.DIFFICULTY.getLevel() < Difficulty.HARD.getLevel()) {
            GGraphics.renderOffsetImage(GTextures.GUI_BLADDER, bladder.getX(), bladder.getY(), bladder.getSizeX(), bladder.getSizeY(), new float[]{1f, 1f, 1f, 1f}, 0, 15, 20, 58);
            GGraphics.renderQuad(bladder.getX() + 18, bladder.getY() + 20 + (bladder.getPeeMaxLevel() - bladder.getPeeLevel()) * bladder.getScaleY(), bladder.getSizeX() - 36, bladder.getPeeLevel() * bladder.getScaleY(), new float[]{1f, 1f, 0f, 0.8f});
        }
    }
}
