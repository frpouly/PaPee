package fr.gamejam.papee.game;

public enum Difficulty {
    EASY(0),
    MEDIUM(1),
    HARD(2);

    private int level;

    Difficulty(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
