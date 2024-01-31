package org.painandsuffer.characters.adventurers;

import org.painandsuffer.characters.Creature;
import org.painandsuffer.items.Equipable;
import org.painandsuffer.items.armour.Armour;
import org.painandsuffer.items.armour.ArmourSet;
import org.painandsuffer.items.armour.chest.ChestArmour;
import org.painandsuffer.items.armour.chest.Cloth;
import org.painandsuffer.items.weapon.Fists;
import org.painandsuffer.items.weapon.Weapon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Adventurer extends Creature {
    static final Random random = new Random();
    private Weapon weapon = new Fists();
    private ChestArmour chestArmour = new Cloth();
    private ArmourSet armourSet;

    public Adventurer(String name) {
        setName(name);
    }

    public Adventurer(String name, Weapon weapon, ChestArmour chestArmour) {
        this.name = name;
        this.weapon = weapon;
        this.chestArmour = chestArmour;
    }

    public Adventurer(String name, Weapon weapon) {
        this.name = name;
        this.weapon = weapon;
    }

    public Adventurer(String name, ChestArmour chestArmour) {
        this.name = name;
        this.chestArmour = chestArmour;
    }

    private void increaseArmour() {

    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armour getChestArmour() {
        return chestArmour;
    }

    public void setChestArmour(ChestArmour chestArmour) {
        this.chestArmour = chestArmour;
    }

    public void attack(Adventurer target) {
        int damage = randomDiceRoll() + getWeapon().getDamageIncrease();
        int armour = target.getChestArmour().getDefend();
        int damageDecreasedByArmour = damage > armour ? damage - armour : 0;
        target.setHealth(target.getHealth() - damageDecreasedByArmour);
        System.out.println("You attacked " + target.getName() + " for " + damage + " damage");
    }

    public void defend() {
        int defend = 5;

        System.out.println("Your defend" + randomDiceRoll());
    }

    public void equipItem(Equipable item) {
        item.equipOnAdventurer(this);
    }

    public int randomDiceRoll(int origin, int bound) {
        return random.nextInt(origin, bound);
    }

    public int randomDiceRoll() {
        return random.nextInt(1, 20);
    }

}
