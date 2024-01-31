package org.painandsuffer.characters.adventurers;

import org.painandsuffer.items.armour.ArmourSet;
import org.painandsuffer.items.armour.chest.ChestArmour;
import org.painandsuffer.items.weapon.Weapon;

public class Rogue extends Adventurer {


    public Rogue(String name, Weapon weapon, ArmourSet armourSet) {
        super(name, weapon, armourSet);
    }

    public static Builder builder() {
        return new Builder();
    }


    @Override
    public void attack(Adventurer target) {
        int damage = randomDiceRoll() + getWeapon().getDamageIncrease();
        target.setHealth(target.getHealth() - damage);
        System.out.println("Your attack" + damage);
    }

    @Override
    public void defend() {
        System.out.println("Your defend" + randomDiceRoll());
    }
    public static class Builder extends Adventurer.Builder{

        @Override
        public Rogue build() {
            return new Rogue(name,weapon,armourSet);
        }
    }
}
