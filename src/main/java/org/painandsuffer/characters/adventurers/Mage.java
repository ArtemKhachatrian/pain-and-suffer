package org.painandsuffer.characters.adventurers;

import lombok.Getter;
import org.painandsuffer.battle.statuses.CooldownStatus;
import org.painandsuffer.battle.statuses.MagicShield;
import org.painandsuffer.characters.Creature;
import org.painandsuffer.items.armour.ArmourSet;
import org.painandsuffer.items.weapons.Weapon;
import org.painandsuffer.magic.MagicUser;

@Getter
public class Mage extends Adventurer implements MagicUser {

    private static final int MANA_COST_PER_SPELL = 10;

    private int mana;

    public Mage(String name, int health, int defence, int magicProtection, int evasionRate, int damage,
                int criticalRate,Weapon weapon, ArmourSet armourSet, int mana) {
        super(name, health, defence, magicProtection, evasionRate, damage == 0 ? 2:damage,criticalRate, weapon, armourSet);
        this.mana = mana;
    }

    public static Mage.Builder builder() {
        return new Mage.Builder();
    }

    public void setMana(int mana) {
        if (mana <= 0) {
            this.mana = 0;
            System.out.println("Your out of mana ");
        } else this.mana = mana;
    }



    @Override
    public void defend() {
        MagicShield magicShield = new MagicShield(this);
        magicShield.applyEffect();
        this.getStatuses().add(magicShield);


    }

    @Override
    public void useMagic(Creature target) {
        if (!isOnCooldown() && mana >= MANA_COST_PER_SPELL) {
            int damage = randomDiceRoll(5, 30);
            target.setHealth(target.getHealth() - damage);
            setMana(getMana() - MANA_COST_PER_SPELL);
            addStatus(new CooldownStatus(1, this));
            System.out.println("Your magic attack " + damage);
        }
    }

    private boolean isOnCooldown() {
        return getStatuses().stream().anyMatch(obj -> obj.getClass().equals(CooldownStatus.class));
    }

    public static class Builder extends Adventurer.Builder<Mage> {
        private int mana = 100;



        @Override
        public Mage build() {
            setAdventurerDefaults();
            return new Mage(name, health, defence, magicProtection, evasionRate, damage,criticalRate, weapon, armourSet, mana);
        }
    }
}
