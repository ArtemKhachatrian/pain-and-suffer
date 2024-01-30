package org.painandsuffer.characters.adventurers;
import org.painandsuffer.items.armor.chest.ChestArmor;
import org.painandsuffer.items.weapon.Weapon;

public class Warrior extends Adventurer {

    public Warrior(String name, Weapon weapon, ChestArmor armor) {
        super(name, weapon, armor);
    }

    public Warrior(String name, Weapon weapon) {
        super(name, weapon);
    }

    public Warrior(String name, ChestArmor armor) {
        super(name, armor);
    }

    public Warrior(String name) {
        super(name);
    }

    @Override
    public void defend() {
        System.out.println("Your defend"+ randomDiceRoll() + 10);
    }
}
