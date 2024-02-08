package org.painandsuffer.characters.adventurers;

import org.painandsuffer.battle.statuses.ProtectiveStance;
import org.painandsuffer.characters.Creature;
import org.painandsuffer.items.armour.ArmourSet;
import org.painandsuffer.items.weapons.Weapon;

public class Warrior extends Adventurer {

    public Warrior(String name, int health, int defence, int magicProtection, int evasionRate, int damage,
                   int criticalRate, Weapon weapon, ArmourSet armourSet) {
        super(name, health, defence, magicProtection, evasionRate, damage == 0 ? 10:damage,30, weapon, armourSet);
    }

    public static Warrior.Builder builder() {
        return new Builder();
    }

    @Override
    public void defend() {
        ProtectiveStance protectiveStanceStatus = new ProtectiveStance(this);
        this.getStatuses().add(protectiveStanceStatus);
        protectiveStanceStatus.increaseDefence();
    }

    public static class Builder extends Adventurer.Builder<Warrior> {
        @Override
        public Warrior build() {
            setAdventurerDefaults();
            return new Warrior(name, health, defence, magicProtection, evasionRate, damage,criticalRate, weapon, armourSet);
        }
    }
}
