package org.painandsuffer.characters.adventurers;

import org.painandsuffer.MagicUser;
import org.painandsuffer.items.armour.ArmourSet;
import org.painandsuffer.items.armour.chest.ChestArmour;
import org.painandsuffer.items.weapon.Weapon;

public class Mage extends Adventurer implements MagicUser {

    private int mana = 100;

    private Mage(String name, Weapon weapon, ArmourSet armourSet) {
        super(name, weapon, armourSet);
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        if (mana >= 0) {
            System.out.println("Your out of mana ");
        } else this.mana = mana;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public void attack(Adventurer target) {
        int damage = randomDiceRoll(1, 20) + getWeapon().getDamageIncrease();
        if (damage >= 5) {
            damage -= 5;
        }
        target.setHealth(target.getHealth() - damage);
        System.out.println("Your attack" + damage);
    }

    @Override
    public void defend() {
        int diceResult = randomDiceRoll(1, 10);
        if (diceResult >= 3) {
            diceResult -= 3;
        }

        System.out.println("Your defend" + diceResult);

    }

    @Override
    public void useMagic(Adventurer target) {
        int damage = randomDiceRoll();
        target.setHealth(target.getHealth() - damage);
        System.out.println("Your magic attack " + damage);
    }

    public static class Builder extends Adventurer.Builder<Mage>{

        @Override
        public Mage build() {
            armourSet = buildArmourSet();
            return new Mage(name,weapon,armourSet);
        }
    }
}
