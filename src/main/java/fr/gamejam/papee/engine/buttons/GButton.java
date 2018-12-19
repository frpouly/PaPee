package fr.gamejam.papee.engine.buttons;

import fr.gamejam.papee.engine.graphics.GGraphics;
import fr.gamejam.papee.engine.ui.UI;
import fr.gamejam.papee.engine.utils.GDefines;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

public abstract class GButton extends UI {
    private String text;
    private int textSize;
    private boolean isMouseDown;
    private boolean visible;

    public GButton(String text, float x, float y, int size) {
        super(x, y, 0, 0, null);
        this.text = text;
        textSize = size;
        this.setSizeX(text.length() * textSize + textSize);
        this.setSizeY(textSize + textSize);
        this.setVisible(true);
    }

    public boolean isButtonDown() {
        if(getBounds().contains(Mouse.getX(), Display.getHeight() - Mouse.getY()) && Mouse.isButtonDown(0) && !isMouseDown) {
            isMouseDown = true;
            return true;
        }
        if(!Mouse.isButtonDown(0)) {
            isMouseDown = false;
        }
        return false;
    }

    /**
     * @return true if the button is overflew by the mouse false if not
     */
    public boolean isButtonHover() {
        if(getBounds().contains(Mouse.getX(), Display.getHeight() - Mouse.getY())) {
            return true;
        }
        return false;
    }

    @Override
    public void init() {

    }

    @Override
    public void update() {
        if(isButtonDown()) {
            onClick();
        }
    }

    @Override
    public void render() {
        if (isVisible()) {
            GGraphics.renderQuad(x, y, sizeX, sizeY, GDefines.WHITE);
            if (isButtonHover()) {
                GGraphics.renderQuad(x, y, sizeX, sizeY, GDefines.LIGHT_BLUE);
            }
            if (isButtonDown()) {
                GGraphics.renderQuad(x, y, sizeX, sizeY, GDefines.BLUE);
            }
            GGraphics.renderText(text, x + sizeX / 2 - text.length() * textSize / 2, y + sizeY / 2 - textSize / 2, textSize, GDefines.BLACK);
        }
    }

    @Override
    public void dispose() {

    }

    /**
     * Called when the buttion is clicked down
     */
    public abstract void onClick();

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
