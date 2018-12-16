package fr.gamejam.papee.entities.environment;

import fr.gamejam.papee.engine.Game;
import fr.gamejam.papee.engine.fx.GParticle;
import fr.gamejam.papee.engine.graphics.GTexture;
import fr.gamejam.papee.engine.utils.GDefines;
import fr.gamejam.papee.entities.PaPee;
import org.lwjgl.util.vector.Vector2f;

import java.util.function.Function;

public class Effect {
    private int effectTime;
    private IEffect startEffect;
    private IEffect stopEffect;
    private PaPee papee;
    private boolean generateParticle;
    private GTexture particleName;

    public Effect(int effectTime, GTexture particleName) {
        setEffectTime(effectTime);
        this.particleName = particleName;
        if(particleName != null) {
            setGenerateParticle(true);
        } else {
            setGenerateParticle(false);
        }

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

    public void applyEffect(PaPee paPee, IEffect startEffect) {
        applyEffect(paPee, startEffect, null);
    }

    public void startEffect() {
        if (startEffect == null) {
            stopEffect = null;
        } else {

            startEffect.effect(papee);
        }
    }

    public void stopEffect() {
        if (stopEffect != null) {
            stopEffect.effect(papee);
        }
    }

    public boolean isGenerateParticle() {
        return generateParticle;
    }

    public void setGenerateParticle(boolean generateParticle) {
        this.generateParticle = generateParticle;
    }

    public GTexture getParticleName() {
        return particleName;
    }
}
