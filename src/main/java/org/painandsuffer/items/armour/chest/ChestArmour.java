package org.painandsuffer.items.armour.chest;

import org.painandsuffer.characters.Creature;
import org.painandsuffer.items.armour.Armour;

public abstract class ChestArmour extends Armour {
    public ChestArmour(int defend, int armorDurability) {
        super(defend, armorDurability);
    }

    @Override
    public void equipItem(Creature creature) {
        ChestArmour previousChestArmour = creature.getArmourSet().getChestArmour();
        creature.getArmourSet().setChestArmour(this);
        creature.setDefence(creature.getDefence() + (this.getDefence() - previousChestArmour.getDefence()));
    }
}
