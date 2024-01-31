package org.painandsuffer.characters.adventurers;

import org.painandsuffer.characters.Creature;
import org.painandsuffer.items.Equipable;
import org.painandsuffer.items.armour.ArmourSet;
import org.painandsuffer.items.armour.chest.ChestArmour;
import org.painandsuffer.items.armour.chest.Cloth;
import org.painandsuffer.items.armour.gloves.GlovesArmour;
import org.painandsuffer.items.weapon.Fists;
import org.painandsuffer.items.weapon.Weapon;

import java.util.Random;

public abstract class Adventurer extends Creature {
    static final Random random = new Random();
    private Weapon weapon;
    private ArmourSet armourSet;

    public Adventurer(String name, Weapon weapon, ArmourSet armourSet) {
        this.name = name;
        this.weapon = weapon;
        this.armourSet = armourSet;
        applyArmourBonus();
    }

    private void applyArmourBonus() {
        setArmour(getArmour() + armourSet.getBonusToArmour());
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public ArmourSet getArmourSet() {
        return armourSet;
    }

    public void setArmourSet(ArmourSet armourSet) {
        this.armourSet = armourSet;
    }


    public void attack(Adventurer target) {
        int damage = randomDiceRoll() + getWeapon().getDamageIncrease();
        int armour = target.getArmour();
        int damageDecreasedByArmour = damage > armour ? damage - armour : 0;
       target.setHealth(target.getHealth() - damageDecreasedByArmour);
        System.out.println("You attacked " + target.getName() + " for " + damage + " damage");
    }

    public abstract void defend();

    public void equipItem(Equipable item) {
        item.equipOnAdventurer(this);
    }

    public int randomDiceRoll(int origin, int bound) {
        return random.nextInt(origin, bound);
    }

    public int randomDiceRoll() {
        return random.nextInt(1, 20);
    }

    public abstract static class Builder<T extends Adventurer> {
        protected String name = "Tav";
        protected Weapon weapon = new Fists();
        protected ChestArmour chestArmour = new Cloth();
        protected GlovesArmour glovesArmour;
        protected ArmourSet armourSet;

        public Builder<T> name(String name){
            this.name = name;
            return this;
        }
        public Builder<T> weapon(Weapon weapon){
            this.weapon = weapon;
            return this;
        }
        public Builder<T> chestArmour(ChestArmour chestArmour){
            this.chestArmour = chestArmour;
            return this;
        }

        public Builder<T> glovesArmour(GlovesArmour glovesArmour){
            this.glovesArmour = glovesArmour;
            return this;
        }

        public abstract T build();

        protected ArmourSet buildArmourSet(){
            return ArmourSet.builder().chestArmour(chestArmour).build();
        }
    }
}
