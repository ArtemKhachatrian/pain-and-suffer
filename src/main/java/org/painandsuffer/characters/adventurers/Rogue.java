package org.painandsuffer.characters.adventurers;

import org.painandsuffer.battle.statuses.Evasive;
import org.painandsuffer.characters.Creature;
import org.painandsuffer.items.armour.ArmourSet;
import org.painandsuffer.items.weapons.Weapon;

public class Rogue extends Adventurer {

    public Rogue(String name, int health, int defence, int magicProtection, int evasionRate, int damage,
                 int criticalRate, Weapon weapon, ArmourSet armourSet) {
        super(name, health, defence, magicProtection, evasionRate, damage == 0 ? 5:damage,criticalRate, weapon, armourSet);
    }

    public static Rogue.Builder builder() {
        return new Rogue.Builder();
    }

    @Override
    public void attack(Creature target) {
        provideDoubleAttack(target);
    }

    public void provideDoubleAttack(Creature target){
        super.attack(target);
        super.attack(target);
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
