package fr.gamejam.papee.game;

import fr.gamejam.papee.engine.window.Congrats;
import fr.gamejam.papee.engine.window.GameOver;
import fr.gamejam.papee.engine.fx.GParticle;
import fr.gamejam.papee.engine.game.GGame;
import fr.gamejam.papee.engine.objects.GObject;
import fr.gamejam.papee.engine.ui.UI;
import fr.gamejam.papee.engine.ui.UIBladder;
import fr.gamejam.papee.engine.ui.UIMiniMap;
import fr.gamejam.papee.engine.utils.GDefines;
import fr.gamejam.papee.entities.papee.Bladder;
import fr.gamejam.papee.entities.papee.Papee;
import fr.gamejam.papee.effect.Effect;
import fr.gamejam.papee.entities.environment.items.*;
import fr.gamejam.papee.entities.environment.obstacles.PeePuddle;
import fr.gamejam.papee.entities.environment.obstacles.Toilets;
import fr.gamejam.papee.game.level.LevelLoader;
import fr.gamejam.papee.game.map.Map;

import java.util.ArrayList;
import java.util.List;

public class Game extends GGame {
    public static ArrayList<Effect> effects = new ArrayList<Effect>();


    private Map map;
    private Item itemViagra;

    private List<UI> listUI = new ArrayList<>();

    public Game() {
        objects.clear();

        String[] levels = new String[]{
                "/levels/level_1.json",
                "/levels/level_2.json",
                "/levels/level_3.json"
        };

        LevelLoader l = new LevelLoader(levels[(int) (Math.random() * levels.length)]);
        Papee papee = new Papee(1200, 1000, new Bladder(10, 100));
        Toilets toilets = new Toilets(2, (int) (Math.random() * GDefines.TILE_WIDTH * GDefines.MAP_WIDTH), (int) (Math.random() * GDefines.TILE_HEIGHT * GDefines.MAP_HEIGHT));

        map = new Map(papee, l.getTiles());
        toilets.setMap(map);
        toilets.recreatePosition(); // C'est dégueu mais j'ai pas le temps de faire un truc potable

        for (int i = 0; i < GDefines.MAP_WIDTH / 4; i++) {
            int x = 0;
            int y = 0;
            do {
                x = (int) (Math.random() * GDefines.MAP_WIDTH);
                y = (int) (Math.random() * GDefines.MAP_HEIGHT);
            } while (map.getTiles()[x][y].isRigid());
            new PeePuddle(1, x * GDefines.OBJECT_WIDTH, y * GDefines.OBJECT_HEIGHT);
        }

        for (int i = 0; i < GDefines.MAP_WIDTH / 7; i++) {
            int x = 0;
            int y = 0;
            do {
                x = (int) (Math.random() * GDefines.MAP_WIDTH);
                y = (int) (Math.random() * GDefines.MAP_HEIGHT);
            } while (map.getTiles()[x][y].isRigid());
            new ItemNitro(1, x * GDefines.OBJECT_WIDTH, y * GDefines.OBJECT_HEIGHT);
        }

        for (int i = 0; i < GDefines.MAP_WIDTH / 6; i++) {
            int x = 0;
            int y = 0;
            do {
                x = (int) (Math.random() * GDefines.MAP_WIDTH);
                y = (int) (Math.random() * GDefines.MAP_HEIGHT);
            } while (map.getTiles()[x][y].isRigid());
            new ItemBeer(1, x * GDefines.OBJECT_WIDTH, y * GDefines.OBJECT_HEIGHT);
        }

        for (int i = 0; i < GDefines.MAP_WIDTH / 16; i++) {
            int x = 0;
            int y = 0;
            do {
                x = (int) (Math.random() * GDefines.MAP_WIDTH);
                y = (int) (Math.random() * GDefines.MAP_HEIGHT);
            } while (map.getTiles()[x][y].isRigid());
            new ItemWhisky(1, x * GDefines.OBJECT_WIDTH, y * GDefines.OBJECT_HEIGHT);
        }

        for (int i = 0; i < GDefines.MAP_WIDTH / 8; i++) {
            int x = 0;
            int y = 0;
            do {
                x = (int) (Math.random() * GDefines.MAP_WIDTH);
                y = (int) (Math.random() * GDefines.MAP_HEIGHT);
            } while (map.getTiles()[x][y].isRigid());
            new ItemViagra(1, x * GDefines.OBJECT_WIDTH, y * GDefines.OBJECT_HEIGHT);
        }

        papee.setMap(map);

        listUI.add(new UIBladder(papee.getBladder()));
        listUI.add(new UIMiniMap(papee, toilets));

    }

    @Override
    public void update() {
        map.update();

        // Check if Bladder is full
        if (map.getPapee().getBladder().isFull()) {
            GGame.window.start(new GameOver());
        }
        if (map.getPapee().isWon()) {
            GGame.window.start(new Congrats());
        }

        for (UI ui : listUI) {
            ui.update();
        }

        for (int i = 0; i < objects.size(); i++) {
            GObject o = objects.get(i);
            if ((o instanceof GParticle)) {
                o.update();
                if (((GParticle) o).getLifetime() < 0) {
                    objects.remove(o);
                }
            }
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