package org.painandsuffer.items.armour.chest;

import org.painandsuffer.characters.adventurers.Adventurer;
import org.painandsuffer.items.armour.Armour;

public abstract class ChestArmour extends Armour {
    public ChestArmour(int defend, int armorDurability) {
        super(defend, armorDurability);
    }

    @Override
    public void equipOnAdventurer(Adventurer adventurer) {
        adventurer.getArmourSet().setChestArmour(this);
    }
}
