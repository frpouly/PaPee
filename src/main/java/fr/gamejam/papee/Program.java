package fr.gamejam.papee;

import fr.gamejam.papee.engine.utils.GDefines;
import fr.gamejam.papee.engine.state.MenuState;
import fr.gamejam.papee.engine.state.State;
import org.lwjgl.opengl.GL11;

public class Program {
    public static void main(String[] args) {
        State menu = new MenuState();

        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glEnable(GL11.GL_LIGHT0);
        GL11.glEnable(GL11.GL_LIGHT1);
        GL11.glEnable(GL11.GL_COLOR_MATERIAL);

        GL11.glLight(GL11.GL_LIGHT0, GL11.GL_DIFFUSE, GDefines.floatBuffer(0.8f, 0.8f, 0.4f, 1f));
        GL11.glLight(GL11.GL_LIGHT0, GL11.GL_AMBIENT, GDefines.floatBuffer(0f, 0f, 0f, 1f));
        GL11.glLight(GL11.GL_LIGHT1, GL11.GL_DIFFUSE, GDefines.floatBuffer(1f, 1f, 1f, 1f));
        GL11.glLight(GL11.GL_LIGHT1, GL11.GL_AMBIENT, GDefines.floatBuffer(0f, 0f, 0f, 1f));

        State.getWindow().start(menu);
    }
}
