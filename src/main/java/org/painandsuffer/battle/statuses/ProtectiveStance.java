package org.painandsuffer.battle.statuses;

import org.painandsuffer.characters.Creature;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class ProtectiveStance extends Status {
    public static final BigDecimal ARMOUR_MULTIPLIER = new BigDecimal("1.3");
    public static final int ROUNDS_DURATION = 3;
    public static final RoundingMode ROUNDING_MODE = RoundingMode.HALF_UP;
    public static final int PRECISION = 1;

    public ProtectiveStance(Creature creature) {
        super(ROUNDS_DURATION, creature);
    }

    @Override
    public void removeIfExpired() {
        super.removeIfExpired();
        if (isExpired()) getCreature().setDefence(calculateDecreasedDefenceValue());
    }

    public void increaseDefence() {
        getCreature().setDefence(calculateIncreasedDefenceValue());
    }

    private int calculateIncreasedDefenceValue() {
        BigDecimal defence = new BigDecimal(getCreature().getDefence());
        return defence
                .multiply(ARMOUR_MULTIPLIER)
                .round(new MathContext(PRECISION, ROUNDING_MODE))
                .intValue();
    }

    private int calculateDecreasedDefenceValue() {
        BigDecimal defence = new BigDecimal(getCreature().getDefence());
        return defence
                .divide(ARMOUR_MULTIPLIER,ROUNDING_MODE)
                .intValue();
    }

}
