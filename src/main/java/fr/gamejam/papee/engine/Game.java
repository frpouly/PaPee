package fr.gamejam.papee.engine;

import fr.gamejam.papee.engine.buttons.GButton;
import fr.gamejam.papee.engine.components.GWindow;
import fr.gamejam.papee.engine.fx.GParticle;
import fr.gamejam.papee.engine.game.GGame;
import fr.gamejam.papee.engine.graphics.GTexture;
import fr.gamejam.papee.engine.guis.GGui;
import fr.gamejam.papee.engine.objects.GObject;
import fr.gamejam.papee.engine.utils.GDefines;
import fr.gamejam.papee.entities.Bladder;
import fr.gamejam.papee.entities.PaPee;
import fr.gamejam.papee.entities.environment.Effect;
import fr.gamejam.papee.entities.environment.items.Item;
import fr.gamejam.papee.entities.environment.items.ItemViagra;
import org.lwjgl.util.vector.Vector2f;

import java.util.ArrayList;
import java.util.Random;

public class Game extends GGame {

    public static ArrayList<Effect> effects = new ArrayList<Effect>();
    /*
        Test GUI
     */
    Item itemViagra;

    private PaPee papee;

    public Game()
    {
        objects.clear();
        itemViagra = new ItemViagra(1,500, 500);
        papee = new PaPee(0, 0, new Bladder(10, 100));
        new GButton("Create Particle", 800, 400, 16) {
            @Override
            public void onClick() {
                for (int i = 0; i < 10; i++) {
                    GParticle p = new GParticle(new Random().nextInt(5), x + sizeX / 2, y + sizeY / 2, 32);
                    p.setColor(GDefines.WHITE);
                    p.setSpeed(new Random().nextFloat());
                    p.setDirection(new Vector2f((float) new Random().nextGaussian() * 2, (float) new Random().nextGaussian() * 2));
                    p.setLifetime(new Random().nextFloat() * 2);
                    p.setTexture(GTexture.VIAGRA_TEXTURE);
                }
            }
        };
    }

    public void update() {
        super.update();
        papee.getBladder().increasePeeLevel();
        // Check if Bladder is full
        if(papee.getBladder().isFull())
        {
            GGame.window.start(new GameOver());
        }
    }
}
