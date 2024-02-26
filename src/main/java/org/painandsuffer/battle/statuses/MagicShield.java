package org.painandsuffer.battle.statuses;

import org.painandsuffer.characters.Creature;

public class MagicShield extends Status {

    public static final int ROUNDS_DURATION = 2;
    public static final int PROTECTION_AMOUNT = 50;

    public MagicShield(Creature creature) {
        super(ROUNDS_DURATION, creature);
    }

    @Override
    public void applyEffect() {
        if (!isActive()) {
            getCreature().setMagicProtection(calculateNewProtectionAmount());
        }
    }

    @Override
    public void onExpired() {
        int magicProtectionReduced = getCreature().getMagicProtection() - PROTECTION_AMOUNT;
        getCreature().setMagicProtection(Math.max(magicProtectionReduced, 0));
    }


    private int calculateNewProtectionAmount() {
        return getCreature().getMagicProtection() + PROTECTION_AMOUNT;
    }

    private boolean isActive() {
        return getCreature().getStatuses().stream().anyMatch(obj -> obj.getClass().equals(MagicShield.class));
    }

    @Override
    public boolean isExpired() {
        return getRoundsDuration() <= 0 || getCreature().getMagicProtection() <= 0;
    }
}
