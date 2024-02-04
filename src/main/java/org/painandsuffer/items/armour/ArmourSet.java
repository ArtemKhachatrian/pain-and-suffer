package org.painandsuffer.items.armour;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.painandsuffer.items.armour.chest.ChestArmour;
import org.painandsuffer.items.armour.gloves.GlovesArmour;

@Getter
@Setter
@Builder
public class ArmourSet {
    private ChestArmour chestArmour;
    private GlovesArmour glovesArmour;

    public int getBonusToArmour() {
        int bonusToArmour = chestArmour != null ? chestArmour.getDefence() : 0;
        bonusToArmour += glovesArmour != null ? glovesArmour.getDefence() : 0;
        return bonusToArmour;
    }

}
