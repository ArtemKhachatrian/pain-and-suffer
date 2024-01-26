package org.painandsuffer.characters;

import org.painandsuffer.MagicUser;
import org.painandsuffer.items.armor.Armor;
import org.painandsuffer.items.weapon.Weapon;


public class Mage extends Adventurer implements MagicUser {

    public Mage(String name, Weapon weapon, Armor armor) {
        super(name, weapon, armor);
    }

    public Mage(String name, Weapon weapon) {
        super(name, weapon);
    }

    public Mage(String name, Armor armor) {
        super(name, armor);
    }

    public Mage(String name){
        super(name);

    }
    @Override
    public void attack(Adventurer target){
        int damage = randomDiceRoll(1,20) + getWeapon().damageIncrease();
        if (damage>=5){
            damage -=5;
        }
        target.setHealth(target.getHealth()-damage);
        System.out.println("Your attack"+ damage);
    }

    @Override
    public void defend() {
        int diceResult = randomDiceRoll(1,10);
        if (diceResult>=3){
            diceResult -=3;
        }

        System.out.println("Your defend"+ diceResult);

    }

    @Override
    public void useMagic(Adventurer target) {
        int damage = randomDiceRoll();
        target.setHealth(target.getHealth()-damage);
        System.out.println("Your magic attack" + damage);
    }
}
