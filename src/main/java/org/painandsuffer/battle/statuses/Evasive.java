package org.painandsuffer.battle.statuses;

import org.painandsuffer.characters.Creature;

public class Evasive extends Status {
    public static final int ROUNDS_DURATION = 2;
    public static final int EVASION_AMOUNT = 50;

    public Evasive(Creature creature) {
        super(ROUNDS_DURATION, creature);
    }

    public void applyEvasive() {
        if (!isActive()) {
            getCreature().setEvasionRate(calculateNewEvasiveAmount());
        }
    }

    public int calculateNewEvasiveAmount() {
        return getCreature().getEvasionRate() + EVASION_AMOUNT;
    }

    private boolean isActive() {
        return getCreature().getStatuses().stream().anyMatch(obj -> obj.getClass().equals(MagicShield.class));
    }

}
