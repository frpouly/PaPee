package fr.gamejam.papee.game;

import fr.gamejam.papee.engine.state.CongratsState;
import fr.gamejam.papee.engine.state.GameOverState;
import fr.gamejam.papee.engine.fx.GParticle;
import fr.gamejam.papee.engine.state.GState;
import fr.gamejam.papee.engine.ui.UI;
import fr.gamejam.papee.engine.ui.UIBladder;
import fr.gamejam.papee.engine.ui.UIMiniMap;
import fr.gamejam.papee.util.GDefines;
import fr.gamejam.papee.util.IRunnable;
import fr.gamejam.papee.entities.Entity;
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

public class Game implements IRunnable {
    public static List<Effect> effects = new ArrayList<>();
    public static List<Entity> entities = new ArrayList<>();
    private static boolean won = false;

    private Map map;
    private Papee papee;
    private Toilets toilets;
    private List<UI> listUI = new ArrayList<>();

    public Game() {
        entities.clear();

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
        //toilets.recreatePosition(); // C'est dégueu mais j'ai pas le temps de faire un truc potable

        entities.add(toilets);

        for (int i = 0; i < GDefines.MAP_WIDTH / 4; i++) {
            int x = 0;
            int y = 0;
            do {
                x = (int) (Math.random() * GDefines.MAP_WIDTH);
                y = (int) (Math.random() * GDefines.MAP_HEIGHT);
            } while (map.getTiles()[x][y].isRigid());
            Entity o = new PeePuddle(1, x * GDefines.OBJECT_WIDTH, y * GDefines.OBJECT_HEIGHT);
            entities.add(o);
        }

        for (int i = 0; i < GDefines.MAP_WIDTH / 7; i++) {
            int x = 0;
            int y = 0;
            do {
                x = (int) (Math.random() * GDefines.MAP_WIDTH);
                y = (int) (Math.random() * GDefines.MAP_HEIGHT);
            } while (map.getTiles()[x][y].isRigid());
            Entity o = new ItemNitro(1, x * GDefines.OBJECT_WIDTH, y * GDefines.OBJECT_HEIGHT);
            entities.add(o);
        }

        for (int i = 0; i < GDefines.MAP_WIDTH / 6; i++) {
            int x = 0;
            int y = 0;
            do {
                x = (int) (Math.random() * GDefines.MAP_WIDTH);
                y = (int) (Math.random() * GDefines.MAP_HEIGHT);
            } while (map.getTiles()[x][y].isRigid());
            Entity o = new ItemBeer(1, x * GDefines.OBJECT_WIDTH, y * GDefines.OBJECT_HEIGHT);
            entities.add(o);
        }

        for (int i = 0; i < GDefines.MAP_WIDTH / 16; i++) {
            int x = 0;
            int y = 0;
            do {
                x = (int) (Math.random() * GDefines.MAP_WIDTH);
                y = (int) (Math.random() * GDefines.MAP_HEIGHT);
            } while (map.getTiles()[x][y].isRigid());
            Entity o = new ItemWhisky(1, x * GDefines.OBJECT_WIDTH, y * GDefines.OBJECT_HEIGHT);
            entities.add(o);
        }

        for (int i = 0; i < GDefines.MAP_WIDTH / 8; i++) {
            int x = 0;
            int y = 0;
            do {
                x = (int) (Math.random() * GDefines.MAP_WIDTH);
                y = (int) (Math.random() * GDefines.MAP_HEIGHT);
            } while (map.getTiles()[x][y].isRigid());
            Entity o = new ItemViagra(1, x * GDefines.OBJECT_WIDTH, y * GDefines.OBJECT_HEIGHT);
            entities.add(o);
        }

        papee.setMap(map);

        listUI.add(new UIBladder(papee.getBladder()));
        listUI.add(new UIMiniMap(papee, toilets));
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public static boolean isWon() {
        return won;
    }

    public static void setWon(boolean won) {
        Game.won = won;
    }

    private void setToiletsPosition() {
        int x;
        int y;

        do {
            x = (int)(Math.random() * GDefines.MAP_WIDTH);
            y = (int)(Math.random() * GDefines.MAP_HEIGHT);
        } while(getMap().getTiles()[x][y].isRigid());

        toilets.setX(x * GDefines.OBJECT_WIDTH);
        toilets.setY(y * GDefines.OBJECT_HEIGHT);
    }

    @Override
    public void init() {
        setToiletsPosition();
    }

    @Override
    public void update() {
        map.update();

        // Check if Bladder is full
        if (map.getPapee().getBladder().isFull()) {
            GState.getWindow().start(new GameOverState());
        }
        if (isWon()) {
            GState.getWindow().start(new CongratsState());
        }

        for (UI ui : listUI) {
            ui.update();
        }

        for (int i = 0; i < entities.size(); i++) {
            Entity o = entities.get(i);
            o.update();
            if (o instanceof GParticle) {
                if (((GParticle) o).getLifetime() < 0) {
                    entities.remove(o);
                }
            }
        }

        // Iterator?
        for (Entity o : entities) {
            if ((o instanceof GParticle)) {
                o.update();
                if (((GParticle) o).getLifetime() < 0) {
                    entities.remove(o);
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

        for (Entity o : entities) {
            if ((o instanceof GParticle)) {
                o.render();
            }
        }
    }

    @Override
    public void dispose() {

    }
}