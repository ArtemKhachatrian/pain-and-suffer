package org.painandsuffer.characters;


import org.painandsuffer.items.armor.Armor;
import org.painandsuffer.items.weapon.Weapon;

public class Rogue extends Adventurer {

    public Rogue(String name, Weapon weapon, Armor armor) {
        super(name, weapon, armor);
    }

    public Rogue(String name, Weapon weapon) {
        super(name, weapon);
    }

    public Rogue(String name, Armor armor) {
        super(name, armor);
    }

    public Rogue(String name){
        super(name);

    }
    @Override
    public void attack(Adventurer target){
        int damage = randomDiceRoll() + getWeapon().damageIncrease();
        target.setHealth(target.getHealth()-damage);
        System.out.println("Your attack" + damage);
    }

    @Override
    public void defend() {
        System.out.println("Your defend"+ randomDiceRoll());
    }
}
