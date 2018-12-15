package fr.gamejam.papee.engine.ui;

import fr.gamejam.papee.engine.graphics.GGraphics;
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
        GGraphics.renderQuad(bladder.getX(), bladder.getY(), bladder.getSizeX(), bladder.getSizeY(), new float[] { 1f, 1f, 1f, 0.8f });
        GGraphics.renderQuad(bladder.getX(), bladder.getY() + (bladder.getPeeMaxLevel() - bladder.getPeeLevel()) * bladder.getScaleY(), bladder.getSizeX(), bladder.getPeeLevel() * bladder.getScaleY(), new float[] { 1f, 1f, 0f, 0.8f });
    }
}
