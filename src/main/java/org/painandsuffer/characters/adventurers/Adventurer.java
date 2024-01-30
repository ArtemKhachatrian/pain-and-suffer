package org.painandsuffer.characters.adventurers;

import org.painandsuffer.characters.Creature;
import org.painandsuffer.items.Equipable;
import org.painandsuffer.items.armor.Armor;
import org.painandsuffer.items.armor.chest.ChestArmor;
import org.painandsuffer.items.armor.chest.Cloth;
import org.painandsuffer.items.weapon.Fists;
import org.painandsuffer.items.weapon.Weapon;

import java.util.Random;


public abstract class Adventurer extends Creature {
    private Weapon weapon = new Fists();
    private ChestArmor chestArmor = new Cloth();


    static final Random random = new Random();

    public Adventurer(String name) {
        setName(name);
    }

    public Adventurer(String name, Weapon weapon, ChestArmor chestArmor) {
        this.name = name;
        this.weapon = weapon;
        this.chestArmor = chestArmor;
    }

    public Adventurer(String name, Weapon weapon) {
        this.name = name;
        this.weapon = weapon;
    }

    public Adventurer(String name, ChestArmor chestArmor) {
        this.name = name;
        this.chestArmor = chestArmor;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getChestArmor() {
        return chestArmor;
    }

    public void setChestArmor(ChestArmor chestArmor) {
        this.chestArmor = chestArmor;
    }


    public void attack(Adventurer target){
        int damage = randomDiceRoll() + getWeapon().getDamageIncrease();
        int armor = target.getChestArmor().getDefend();
        int damageDecreasedByArmor = damage > armor ? damage - armor : 0;
        target.setHealth(target.getHealth() - damageDecreasedByArmor);
        System.out.println("You attacked " + target.getName() + " for " + damage + " damage");
    }

    public void defend() {
        int defend = 5;

        System.out.println("Your defend" + randomDiceRoll());
    }

    public void equipItem(Equipable item){
        item.equipOnAdventurer(this);
    }

    public int randomDiceRoll(int origin, int bound) {
        return random.nextInt(origin, bound);
    }

    public int randomDiceRoll() {
        return random.nextInt(1, 20);
    }


}
