package org.painandsuffer.characters.adventurers;

import org.painandsuffer.battle.status.Evasive;
import org.painandsuffer.characters.Creature;
import org.painandsuffer.items.armour.ArmourSet;
import org.painandsuffer.items.armour.chest.ChestArmour;
import org.painandsuffer.items.weapon.Weapon;

public class Rogue extends Adventurer {
    private Rogue(String name, Weapon weapon, ArmourSet armourSet) {
        super(name, weapon, armourSet);
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public void attack(Creature target) {
        boolean isMissed = randomDiceRoll(1, 1000) > target.getEvasionRate();
        if (isMissed) {
            int armour = target.getArmour();
            int firstAttackDamage = damageDecreasedByArmour(getLeftHandAttackDamage(), armour);
            int secondAttackDamage = damageDecreasedByArmour(getRightHandAttackDamage(), armour);
            provideDoubleAttack(target, firstAttackDamage, secondAttackDamage);
            System.out.println("You attacked " + target.getName() + " for " + firstAttackDamage + " damage with first attack");
            System.out.println("You attacked " + target.getName() + " for " + secondAttackDamage + " damage with second attack");
        }
    }

    private int getLeftHandAttackDamage() {
        return randomDiceRoll() + getWeapon().getDamageIncrease();
    }

    private int getRightHandAttackDamage() {
        return randomDiceRoll(1, 15) + getWeapon().getDamageIncrease();
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
            armourSet = buildArmourSet();
            return new Rogue(name, weapon, armourSet);
        }
    }
}
