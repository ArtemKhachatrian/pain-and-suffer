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

    public Mage(String name, int health, int defence, int magicProtection, int evasionRate, int damage, Weapon weapon, ArmourSet armourSet, int mana) {
        super(name, health, defence, magicProtection, evasionRate, damage, weapon, armourSet);
        this.mana = mana;
    }

    public static Mage.Builder builder() {
        return new Mage.Builder();
    }

    public void setMana(int mana) {
        if (mana >= 0) {
            System.out.println("Your out of mana ");
        } else this.mana = mana;
    }

    @Override
    public void attack(Creature target) {
        boolean isMissed = randomDiceRoll(1, 1000) > target.getEvasionRate();
        if (isMissed) {
            int damage = randomDiceRoll(1, 20) + getWeapon().getDamage();
            int armour = target.getDefence();
            if (damage >= 5) {
                damage -= 5;
            }
            if (damage > getMagicProtection()) {
                int damageDecreasedByArmour = damage > armour ? damage - armour : 0;
                target.setHealth(target.getHealth() + getMagicProtection() - damageDecreasedByArmour);
                System.out.println("You attacked " + target.getName() + " for " + damage + " damage");
            } else {
                target.setMagicProtection(target.getMagicProtection() - damage);
                System.out.println("You attacked " + target.getName() + "Magic shield for " + damage + " damage");
            }
        }
    }

    @Override
    public void defend() {
        MagicShield magicShield = new MagicShield(this);
        this.getStatuses().add(magicShield);
        magicShield.applyMagicProtection();

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

        public Creature.Builder<Mage> mana(int mana) {
            this.mana = mana;
            return this;
        }

        @Override
        public Mage build() {
            setAdventurerDefaults();
            return new Mage(name, health, defence, magicProtection, evasionRate, damage, weapon, armourSet, mana);
        }
    }
}
