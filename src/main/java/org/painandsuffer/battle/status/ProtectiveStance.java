package org.painandsuffer.battle.status;

import org.painandsuffer.characters.Creature;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class ProtectiveStance extends Status {
    public static final BigDecimal ArmourMultiplier = new BigDecimal("1.3");
    public static final int ROUNDS_DURATION = 3;

    public ProtectiveStance(Creature creature) {
        super(ROUNDS_DURATION, creature);
    }

    @Override
    public void removeIfExpired() {
        super.removeIfExpired();
        if (isExpired()) getCreature().setArmour(calculateDecreasedArmourValue());
    }

    public void increaseArmour() {
        getCreature().setArmour(calculateIncreasedArmourValue());
    }

    private int calculateIncreasedArmourValue() {
        BigDecimal bigDecimalArmour = new BigDecimal(getCreature().getArmour());
        return bigDecimalArmour
                .multiply(ArmourMultiplier)
                .round(new MathContext(0, RoundingMode.HALF_UP))
                .intValue();
    }

    private int calculateDecreasedArmourValue() {
        BigDecimal bigDecimalArmour = new BigDecimal(getCreature().getArmour());
        return bigDecimalArmour
                .divide(ArmourMultiplier)
                .round(new MathContext(0, RoundingMode.HALF_UP))
                .intValue();
    }

}
