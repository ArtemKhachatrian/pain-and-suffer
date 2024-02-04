package org.painandsuffer.battle.statuses;

import org.painandsuffer.characters.Creature;

public class MagicShield extends Status {

    public static final int ROUNDS_DURATION = 2;
    public static final int PROTECTION_AMOUNT = 50;

    public MagicShield(Creature creature) {
        super(ROUNDS_DURATION, creature);
    }

    public void applyMagicProtection() {
        if (!isActive()) {
            getCreature().setMagicProtection(calculateNewProtectionAmount());
        }
    }

    private int calculateNewProtectionAmount() {
        return getCreature().getMagicProtection() + PROTECTION_AMOUNT;
    }

    private boolean isActive() {
        return getCreature().getStatuses().stream().anyMatch(obj -> obj.getClass().equals(MagicShield.class));
    }

    @Override
    protected boolean isExpired() {
        return getRoundsDuration() <= 0 || getCreature().getMagicProtection() <= 0;
    }
}
