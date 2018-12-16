package fr.gamejam.papee.engine.ui;

import fr.gamejam.papee.engine.animation.GAnimation;
import fr.gamejam.papee.engine.graphics.GGraphics;
import fr.gamejam.papee.engine.graphics.GTexture;
import fr.gamejam.papee.entities.Bladder;
import fr.gamejam.papee.entities.PaPee;

public class UIBladder implements UI {

    private Bladder bladder;
    private GAnimation animation;

    public UIBladder(PaPee papee) {
        this(papee.getBladder());
    }

    public UIBladder(Bladder bladder) {
        this.bladder = bladder;
        this.animation = GAnimation.UI_BLADDER;
    }

    @Override
    public void update() {
        animation.update();
    }

    @Override
    public void render() {

        GGraphics.renderOffsetImage(GTexture.GUI_BLADDER, bladder.getX(), bladder.getY(), bladder.getSizeX(), bladder.getSizeY(), new float[] { 1f, 1f, 1f, 1f }, 0, 15, 20, 58);
        GGraphics.renderQuad(bladder.getX() + 18, bladder.getY() + 20 + (bladder.getPeeMaxLevel() - bladder.getPeeLevel()) * bladder.getScaleY(), bladder.getSizeX() - 36, bladder.getPeeLevel() * bladder.getScaleY(), new float[] { 1f, 1f, 0f, 0.8f });

    }
}
