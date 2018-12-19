package fr.gamejam.papee.engine.state;

import fr.gamejam.papee.game.Game;

public class GameState extends State {
    private Game game;

    public GameState() {
        System.out.println("Construct!");
    }

    @Override
    public void init() {
        this.game = new Game();
    }

    @Override
    public void update() {
        super.update();

        game.update();
    }

    @Override
    public void render() {
        super.render();

        game.render();
    }
}
