package org.painandsuffer.battle.statuses;

import org.painandsuffer.characters.Creature;

public class CooldownStatus extends Status {
    public CooldownStatus(int roundsDuration, Creature creature) {
        super(roundsDuration, creature);
    }
}
