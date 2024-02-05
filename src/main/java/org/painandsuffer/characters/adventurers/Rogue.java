package org.painandsuffer.characters.adventurers;

import org.painandsuffer.battle.statuses.Evasive;
import org.painandsuffer.characters.Creature;
import org.painandsuffer.items.armour.ArmourSet;
import org.painandsuffer.items.weapons.Weapon;

public class Rogue extends Adventurer {

    public Rogue(String name, int health, int defence, int magicProtection, int evasionRate, int damage,
                 int criticalRate, Weapon weapon, ArmourSet armourSet) {
        super(name, health, defence, magicProtection, 30, damage,criticalRate, weapon, armourSet);
    }

    public static Rogue.Builder builder() {
        return new Rogue.Builder();
    }

    public void provideDoubleAttack(Creature target){
        attack(target);
        attack(target);
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
            return new Rogue(name, health, defence, magicProtection, evasionRate, damage,criticalRate, weapon, armourSet);
        }
    }
}
