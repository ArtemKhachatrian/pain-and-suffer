package org.painandsuffer.characters.adventurers;


import org.painandsuffer.items.armor.chest.ChestArmor;
import org.painandsuffer.items.weapon.Weapon;

public class Rogue extends Adventurer {

    public Rogue(String name, Weapon weapon, ChestArmor armor) {
        super(name, weapon, armor);
    }

    public Rogue(String name, Weapon weapon) {
        super(name, weapon);
    }

    public Rogue(String name, ChestArmor armor) {
        super(name, armor);
    }

    public Rogue(String name){
        super(name);

    }
    @Override
    public void attack(Adventurer target){
        int damage = randomDiceRoll() + getWeapon().getDamageIncrease();
        target.setHealth(target.getHealth()-damage);
        System.out.println("Your attack" + damage);
    }

    @Override
    public void defend() {
        System.out.println("Your defend"+ randomDiceRoll());
    }
}
