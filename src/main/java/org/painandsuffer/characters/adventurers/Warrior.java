package org.painandsuffer.characters.adventurers;

import org.painandsuffer.battle.status.ProtectiveStance;
import org.painandsuffer.items.armour.ArmourSet;
import org.painandsuffer.items.weapon.Weapon;

public class Warrior extends Adventurer {

    public Warrior(String name, Weapon weapon, ArmourSet armourSet) {
        super(name, weapon, armourSet);
    }

    public static Warrior.Builder builder() {
        return new Builder();
    }

    @Override
    public void defend() {
        ProtectiveStance protectiveStanceStatus = new ProtectiveStance(this);
        this.getStatuses().add(protectiveStanceStatus);
        protectiveStanceStatus.increaseArmour();
    }

    public static class Builder extends Adventurer.Builder<Warrior> {
        @Override
        public Warrior build() {
            armourSet = buildArmourSet();
            return new Warrior(name, weapon, armourSet);
        }
    }
}
