package org.painandsuffer.characters.adventurers;

import org.painandsuffer.battle.status.ProtectiveStance;
import org.painandsuffer.items.armour.chest.ChestArmour;
import org.painandsuffer.items.weapon.Weapon;

public class Warrior extends Adventurer {

    public Warrior(String name, Weapon weapon, ChestArmour armor) {
        super(name, weapon, armor);
    }

    public Warrior(String name, Weapon weapon) {
        super(name, weapon);
    }

    public Warrior(String name, ChestArmour armor) {
        super(name, armor);
    }

    public Warrior(String name) {
        super(name);
    }

    @Override
    public void defend() {
        ProtectiveStance protectiveStanceStatus = new ProtectiveStance(this);
        this.getStatuses().add(protectiveStanceStatus);
        protectiveStanceStatus.increaseArmour();
    }
}
