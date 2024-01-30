package org.painandsuffer.items.armor.chest;

import org.painandsuffer.characters.adventurers.Adventurer;
import org.painandsuffer.items.armor.Armor;

public abstract class ChestArmor extends Armor {
    public ChestArmor(int defend, int armorDurability) {
        super(defend, armorDurability);
    }

    @Override
    public void equipOnAdventurer(Adventurer adventurer) {
        adventurer.setChestArmor(this);
    }
}
