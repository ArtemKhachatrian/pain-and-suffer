package org.painandsuffer.items.armour;

import org.painandsuffer.items.armour.chest.ChestArmour;

public class ArmourSet {
    private ChestArmour chestArmour;

    private ArmourSet(ChestArmour chestArmour) {
        this.chestArmour = chestArmour;
    }

    public static ArmourSetBuilder builder() {
        return new ArmourSetBuilder();
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
