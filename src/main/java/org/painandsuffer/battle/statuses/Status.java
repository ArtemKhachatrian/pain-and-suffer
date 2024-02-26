package org.painandsuffer.battle.statuses;

import org.painandsuffer.characters.Creature;

public abstract class Status {
    private int roundsDuration;

    private final Creature creature;

    public Status(int roundsDuration, Creature creature) {
        this.roundsDuration = roundsDuration;
        this.creature = creature;
    }

    public abstract void applyEffect();

    public int getRoundsDuration() {
        return roundsDuration;
    }

    public void setRoundsDuration(int roundsDuration) {
        this.roundsDuration = roundsDuration;
    }

    public Creature getCreature() {
        return creature;
    }

    public boolean isExpired() {
        return roundsDuration < 1;
    }

    public void decreaseDuration(){
        setRoundsDuration(getRoundsDuration() - 1);
    }

    public abstract void onExpired();
}
