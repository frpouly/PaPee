package fr.gamejam.papee.engine.ui;

import fr.gamejam.papee.engine.graphics.GGraphics;
import fr.gamejam.papee.engine.graphics.GTexture;
import fr.gamejam.papee.entities.Bladder;
import fr.gamejam.papee.entities.PaPee;

public class UIBladder implements UI {

    private Bladder bladder;

    public UIBladder(PaPee papee) {
        this(papee.getBladder());
    }

    public UIBladder(Bladder bladder) {
        this.bladder = bladder;
    }

    @Override
    public void update() {

    }

    @Override
    public void render() {
        GGraphics.renderQuad(bladder.getX() + 18, bladder.getY() + (bladder.getPeeMaxLevel() - bladder.getPeeLevel()) * bladder.getScaleY() + 18, bladder.getSizeX() - 36, bladder.getPeeLevel() * bladder.getScaleY(), new float[] { 1f, 1f, 0f, 0.8f });
        GGraphics.renderOffsetImage(GTexture.GUI_BLADDER, bladder.getX(), bladder.getY(), bladder.getSizeX(), bladder.getSizeY(), new float[] { 1f, 1f, 1f, 1f }, 0, 15, 20, 58);

        //GGraphics.renderQuad(bladder.getX(), bladder.getY(), bladder.getSizeX(), bladder.getSizeY(), new float[] { 1f, 1f, 1f, 0.8f });
            }
}
