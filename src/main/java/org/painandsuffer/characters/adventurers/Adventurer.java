package org.painandsuffer.characters.adventurers;

import org.painandsuffer.characters.Creature;
import org.painandsuffer.items.armour.ArmourSet;
import org.painandsuffer.items.armour.chest.Cloth;
import org.painandsuffer.items.weapons.Fists;
import org.painandsuffer.items.weapons.Weapon;

public abstract class Adventurer extends Creature {

    public Adventurer(String name, int health, int defence, int magicProtection, int evasionRate, int damage,
                      int criticalRate,Weapon weapon, ArmourSet armourSet) {
        super(name, health, defence, magicProtection, evasionRate, damage,criticalRate,weapon, armourSet);
        getArmourBonus();
    }

    public abstract static class Builder<T extends Adventurer> extends Creature.Builder<T> {
        protected void setAdventurerDefaults() {
            name = name == null ? "Tav" : name;
            health = health == 0 ? 100 : health;
            defence = defence == 0 ? 3 : defence;
            weapon = weapon == null ? new Fists() : weapon;
            armourSet = armourSet == null ? ArmourSet.builder().chestArmour(new Cloth()).build() : armourSet;
        }
    }
}
