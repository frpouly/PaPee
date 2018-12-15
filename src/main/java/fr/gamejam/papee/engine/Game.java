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
import fr.gamejam.papee.game.level.LevelLoader;
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
        LevelLoader l = new LevelLoader("/levels/level_1.json");
        itemViagra = new ItemViagra(1,500, 500);
        papee = new PaPee(0, 0, new Bladder(10, 100));
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