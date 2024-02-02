package org.painandsuffer.battle.status;

import org.painandsuffer.characters.Creature;

public abstract class Status {
    private int roundsDuration;

    private Creature creature;

    public Status(int roundsDuration, Creature creature) {
        this.roundsDuration = roundsDuration;
        this.creature = creature;
    }

    public int getRoundsDuration() {
        return roundsDuration;
    }

    public void setRoundsDuration(int roundsDuration) {
        this.roundsDuration = roundsDuration;
    }

    public Creature getCreature() {
        return creature;
    }

    public void setCreature(Creature creature) {
        this.creature = creature;
    }

    protected boolean isExpired() {
        return roundsDuration < 1;
    }

    public void removeIfExpired() {
        if (isExpired()) creature.removeStatus(this);
    }
}
