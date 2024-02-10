package org.painandsuffer.items.armour.gloves;

import org.painandsuffer.characters.Creature;
import org.painandsuffer.items.armour.Armour;
import org.painandsuffer.items.armour.chest.ChestArmour;

public abstract class GlovesArmour extends Armour {

    public GlovesArmour(int defend, int armourDurability) {
        super(defend, armourDurability);
    }

    @Override
    public void equipItem(Creature creature) {
        GlovesArmour GlovesArmour = creature.getArmourSet().getGlovesArmour();
        creature.getArmourSet().setGlovesArmour(this);
        creature.setDefence(creature.getDefence() + (this.getDefence() - GlovesArmour.getDefence()));
    }
}
