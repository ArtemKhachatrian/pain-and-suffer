package org.painandsuffer.characters.adventurers;

import org.painandsuffer.battle.statuses.Evasive;
import org.painandsuffer.characters.Creature;
import org.painandsuffer.items.armour.ArmourSet;
import org.painandsuffer.items.weapons.Weapon;

public class Rogue extends Adventurer {

    public Rogue(String name, int health, int defence, int magicProtection, int evasionRate, int damage, Weapon weapon, ArmourSet armourSet) {
        super(name, health, defence, magicProtection, evasionRate, damage, weapon, armourSet);
    }

    public static Rogue.Builder builder() {
        return new Rogue.Builder();
    }

    @Override
    public void attack(Creature target) {
        boolean isMissed = randomDiceRoll(1, 1000) > target.getEvasionRate();
        if (isMissed) {
            int armour = target.getDefence();
            int firstAttackDamage = damageDecreasedByArmour(getLeftHandAttackDamage(), armour);
            int secondAttackDamage = damageDecreasedByArmour(getRightHandAttackDamage(), armour);
            provideDoubleAttack(target, firstAttackDamage, secondAttackDamage);
            System.out.println("You attacked " + target.getName() + " for " + firstAttackDamage + " damage with first attack");
            System.out.println("You attacked " + target.getName() + " for " + secondAttackDamage + " damage with second attack");
        }
    }

    private int getLeftHandAttackDamage() {
        return randomDiceRoll(1, 10) + getWeapon().getDamage();
    }

    private int getRightHandAttackDamage() {
        return randomDiceRoll(1, 15) + getWeapon().getDamage();
    }

    private int damageDecreasedByArmour(int damage, int armor) {
        return damage > armor ? damage - armor : 0;
    }

    private void provideDoubleAttack(Creature target, int firstDamage, int secondDamage) {
        target.setHealth(target.getHealth() - firstDamage - secondDamage);
    }

    @Override
    public void defend() {
        Evasive evasive = new Evasive(this);
        this.getStatuses().add(evasive);
        evasive.applyEvasive();
    }

    public static class Builder extends Adventurer.Builder<Rogue> {
        @Override
        public Rogue build() {
            setAdventurerDefaults();
            return new Rogue(name, health, defence, magicProtection, evasionRate, damage, weapon, armourSet);
        }
    }
}
