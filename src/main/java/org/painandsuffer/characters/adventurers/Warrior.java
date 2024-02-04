package org.painandsuffer.characters.adventurers;

import org.painandsuffer.battle.statuses.ProtectiveStance;
import org.painandsuffer.characters.Creature;
import org.painandsuffer.items.armour.ArmourSet;
import org.painandsuffer.items.weapons.Weapon;

public class Warrior extends Adventurer {

    public Warrior(String name, int health, int defence, int magicProtection, int evasionRate, int damage, Weapon weapon, ArmourSet armourSet) {
        super(name, health, defence, magicProtection, evasionRate, damage, weapon, armourSet);
    }

    public static Warrior.Builder builder() {
        return new Builder();
    }

    @Override
    public void attack(Creature target) {
        boolean isMissed = randomDiceRoll(1, 1000) > target.getEvasionRate();
        if (isMissed) {
            boolean isCritical = randomDiceRoll(1, 1000) > 75;
            int damage = randomDiceRoll(1, 10) + getWeapon().getDamage();
            damage = isCritical ? damage * 2 : damage;
            int armour = target.getDefence();
            int damageDecreasedByArmour = damage > armour ? damage - armour : 0;
            target.setHealth(target.getHealth() - damageDecreasedByArmour);
            if (isCritical) System.out.println("Your attack is CRITICAL!");
            System.out.println("You attacked " + target.getName() + " for " + damage + " damage");
        } else System.out.println("LOL YOU MISSED!");
    }

    @Override
    public void defend() {
        ProtectiveStance protectiveStanceStatus = new ProtectiveStance(this);
        this.getStatuses().add(protectiveStanceStatus);
        protectiveStanceStatus.increaseDefence();
    }

    public static class Builder extends Adventurer.Builder<Warrior> {
        @Override
        public Warrior build() {
            setAdventurerDefaults();
            return new Warrior(name, health, defence, magicProtection, evasionRate, damage, weapon, armourSet);
        }
    }
}
