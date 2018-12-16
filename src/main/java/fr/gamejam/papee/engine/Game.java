package fr.gamejam.papee.engine;

import fr.gamejam.papee.engine.buttons.GButton;
import fr.gamejam.papee.engine.fx.GParticle;
import fr.gamejam.papee.engine.game.GGame;
import fr.gamejam.papee.engine.graphics.GTexture;
import fr.gamejam.papee.engine.ui.UI;
import fr.gamejam.papee.engine.ui.UIBladder;
import fr.gamejam.papee.engine.ui.UIMiniMap;
import fr.gamejam.papee.engine.utils.GDefines;
import fr.gamejam.papee.entities.Bladder;
import fr.gamejam.papee.entities.PaPee;
import fr.gamejam.papee.entities.environment.Effect;
import fr.gamejam.papee.entities.environment.EnvironmentObject;
import fr.gamejam.papee.entities.environment.items.Item;
import fr.gamejam.papee.entities.environment.items.ItemBeer;
import fr.gamejam.papee.entities.environment.items.ItemNitro;
import fr.gamejam.papee.entities.environment.items.ItemViagra;
import fr.gamejam.papee.entities.environment.obstacles.PeePuddle;
import fr.gamejam.papee.entities.environment.obstacles.Toilets;
import fr.gamejam.papee.game.level.LevelLoader;
import fr.gamejam.papee.map.Map;
import org.lwjgl.util.vector.Vector2f;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game extends GGame {
    public static ArrayList<Effect> effects = new ArrayList<Effect>();


    private Map map;
    private Item itemViagra;

    private List<UI> listUI = new ArrayList<>();

    public Game() {


        objects.clear();

        LevelLoader l = new LevelLoader("/levels/level_3.json");
        itemViagra = new ItemViagra(1,600, 200);

        ItemNitro nitro = new ItemNitro(5, 500, 500);
        PaPee papee = new PaPee(1200, 1000, new Bladder(10, 100));
        Toilets toilets = new Toilets(2, 10000, 5000);

        map = new Map(papee, l.getTiles());

        for (int i = 0; i < 250; i++) {
            int x = 0;
            int y = 0;
            do {
                x = (int)(Math.random() * GDefines.MAP_WIDTH);
                y = (int)(Math.random() * GDefines.MAP_HEIGHT);
            } while(map.getTiles()[x][y].isRigid());
            new PeePuddle(1, x * GDefines.OBJECT_WIDTH, y * GDefines.OBJECT_HEIGHT);
        }

        for (int i = 0; i < 50; i++) {
            int x = 0;
            int y = 0;
            do {
                x = (int)(Math.random() * GDefines.MAP_WIDTH);
                y = (int)(Math.random() * GDefines.MAP_HEIGHT);
            } while(map.getTiles()[x][y].isRigid());
            new ItemNitro(1, x * GDefines.OBJECT_WIDTH, y * GDefines.OBJECT_HEIGHT);
        }

        for (int i = 0; i < 100; i++) {
            int x = 0;
            int y = 0;
            do {
                x = (int)(Math.random() * GDefines.MAP_WIDTH);
                y = (int)(Math.random() * GDefines.MAP_HEIGHT);
            } while(map.getTiles()[x][y].isRigid());
            new ItemBeer(1, x * GDefines.OBJECT_WIDTH, y * GDefines.OBJECT_HEIGHT);
        }

        for (int i = 0; i < 50; i++) {
            int x = 0;
            int y = 0;
            do {
                x = (int)(Math.random() * GDefines.MAP_WIDTH);
                y = (int)(Math.random() * GDefines.MAP_HEIGHT);
            } while(map.getTiles()[x][y].isRigid());
            new ItemViagra(1, x * GDefines.OBJECT_WIDTH, y * GDefines.OBJECT_HEIGHT);
        }

        papee.setMap(map);

        listUI.add(new UIBladder(papee.getBladder()));
        listUI.add(new UIMiniMap(papee, toilets));

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

    @Override
    public void update() {
        map.update();

        // Check if Bladder is full
        if(map.getPapee().getBladder().isFull())
        {
            GGame.window.start(new GameOver());
        }
        if(map.getPapee().isWon())
        {
            GGame.window.start(new Congrats());
        }

        for (UI ui : listUI) {
            ui.update();
        }
    }

    @Override
    public void render() {
        map.render();

        for (UI ui : listUI) {
            ui.render();
        }
    }
}