package org.painandsuffer.items.armour;

import org.painandsuffer.items.armour.chest.ChestArmour;
import org.painandsuffer.items.armour.gloves.GlovesArmour;

public class ArmourSet {
    private ChestArmour chestArmour;
    private GlovesArmour glovesArmour;

    private ArmourSet(ChestArmour chestArmour) {
        this.chestArmour = chestArmour;
    }

    public static ArmourSetBuilder builder() {
        return new ArmourSetBuilder();
    }

    public int getBonusToArmour() {
        return chestArmour.getDefend() + glovesArmour.getDefend();
    }

    public ChestArmour getChestArmour() {
        return chestArmour;
    }

    public void setChestArmour(ChestArmour chestArmour) {
        this.chestArmour = chestArmour;
    }

    public static class ArmourSetBuilder {
        private ChestArmour chestArmour;

        public ArmourSetBuilder chestArmour(ChestArmour chestArmour) {
            this.chestArmour = chestArmour;
            return this;
        }

        public ArmourSet build() {
            return new ArmourSet(chestArmour);
        }
    }
}
