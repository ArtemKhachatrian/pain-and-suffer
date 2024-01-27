package org.painandsuffer.characters;

import org.painandsuffer.items.armor.Armor;
import org.painandsuffer.items.armor.Cloth;
import org.painandsuffer.items.weapon.Fists;
import org.painandsuffer.items.weapon.Weapon;

import java.util.Random;


public abstract class Adventurer {
    private String name;
    private int health = 100;
    private Weapon weapon = new Fists();
    private Armor armor = new Cloth();


    static final Random random = new Random();

    public Adventurer(String name) {
        setName(name);
    }

    public Adventurer(String name, Weapon weapon, Armor armor) {
        this.name = name;
        this.weapon = weapon;
        this.armor = armor;
    }

    public Adventurer(String name, Weapon weapon) {
        this.name = name;
        this.weapon = weapon;
    }

    public Adventurer(String name, Armor armor) {
        this.name = name;
        this.armor = armor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isBlank()) {
            System.out.println("Incorrect name");
            return;
        }
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health <= 0) {
            System.out.println("Lol " + getName() + " died");
            this.health = 0;
            return;
        }
        this.health = health;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }


    public void attack(Adventurer target){
        int damage = randomDiceRoll() + getWeapon().damageIncrease();
        int armor = target.getArmor().getDefend();
        int damageDecreasedByArmor = damage > armor ? damage - armor : 0;
        target.setHealth(target.getHealth() - damageDecreasedByArmor);
        System.out.println("You attacked " + target.getName() + " for " + damage + " damage");
    }

    public void defend() {
        int defend = 5;

        System.out.println("Your defend" + randomDiceRoll());
    }

    public int randomDiceRoll(int origin, int bound) {
        return random.nextInt(origin, bound);
    }

    public int randomDiceRoll() {
        return random.nextInt(1, 20);
    }


}
