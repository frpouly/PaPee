package fr.gamejam.papee.entities.environment;

import fr.gamejam.papee.engine.Game;
import fr.gamejam.papee.entities.PaPee;

import java.util.function.Function;

public class Effect {

    private int effectTime;
    private IEffect startEffect;
    private IEffect stopEffect;
    private PaPee papee;

    public Effect(int effectTime) {
        setEffectTime(effectTime);
        Game.effects.add(this);
    }

    public int getEffectTime() {
        return effectTime;
    }

    public void setEffectTime(int effectTime) {
        this.effectTime = (effectTime > 0) ? effectTime : 0;
    }

    public void applyEffect(PaPee paPee, IEffect startEffect, IEffect stopEffect) {
        this.papee = paPee;
        this.stopEffect = stopEffect;
        this.startEffect = startEffect;
    }

    public void startEffect() {
        startEffect.effect(papee);
    }

    public void stopEffect() {
        stopEffect.effect(papee);
    }
}
