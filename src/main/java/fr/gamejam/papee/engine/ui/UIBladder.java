package fr.gamejam.papee.engine.ui;

import fr.gamejam.papee.engine.Game;
import fr.gamejam.papee.engine.animation.GAnimation;
import fr.gamejam.papee.engine.graphics.GGraphics;
import fr.gamejam.papee.engine.utils.GDefines;
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
        GGraphics.renderQuad(bladder.getX(), bladder.getY(), bladder.getSizeX(), bladder.getSizeY(), new float[] { 1f, 1f, 1f, 0.8f });
        GGraphics.renderQuad(bladder.getX(), bladder.getY() + (bladder.getPeeMaxLevel() - bladder.getPeeLevel()) * bladder.getScaleY(), bladder.getSizeX(), bladder.getPeeLevel() * bladder.getScaleY(), new float[] { 1f, 1f, 0f, 0.8f });

        GGraphics.renderImage(animation.current(), bladder.getX(), bladder.getY() + 128, 48, 48, GDefines.WHITE);
    }
}
