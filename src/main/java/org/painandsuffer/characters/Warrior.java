package org.painandsuffer.characters;
import org.painandsuffer.items.armor.Armor;
import org.painandsuffer.items.weapon.Weapon;

public class Warrior extends Adventurer {

    public Warrior(String name, Weapon weapon, Armor armor) {
        super(name, weapon, armor);
    }

    public Warrior(String name, Weapon weapon) {
        super(name, weapon);
    }

    public Warrior(String name, Armor armor) {
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
