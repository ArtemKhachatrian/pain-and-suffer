package org.painandsuffer.characters.adventurers;

import org.painandsuffer.characters.Creature;
import org.painandsuffer.magic.MagicUser;
import org.painandsuffer.battle.status.CooldownStatus;
import org.painandsuffer.battle.status.MagicShield;
import org.painandsuffer.battle.status.Status;
import org.painandsuffer.items.armour.ArmourSet;
import org.painandsuffer.items.weapon.Weapon;

public class Mage extends Adventurer implements MagicUser {

    private int mana = 100;



    private static final int MANA_COST_PER_SPELL = 10;

    private Mage(String name, Weapon weapon, ArmourSet armourSet) {
        super(name, weapon, armourSet);
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        if (mana >= 0) {
            System.out.println("Your out of mana ");
        } else this.mana = mana;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public void attack(Creature target) {
        int damage = randomDiceRoll(1, 20) + getWeapon().getDamageIncrease();
        int armour = target.getArmour();
        if (damage >= 5) {damage -= 5;}
        if (damage>getMagicProtection()){
            int damageDecreasedByArmour = damage > armour ? damage - armour : 0;
            target.setHealth(target.getHealth()+getMagicProtection() - damageDecreasedByArmour);
            System.out.println("You attacked " + target.getName() + " for " + damage + " damage");}
        else target.setMagicProtection(- damage);
        System.out.println("You attacked " + target.getName() + "Magic shield for " + damage + " damage");
    }

    @Override
    public void defend() {
        MagicShield magicShield = new MagicShield(this);
        this.getStatuses().add(magicShield);
        magicShield.applyMagicProtection();

    }

    @Override
    public void useMagic(Creature target) {

        if (!isOnCooldown() && mana >= MANA_COST_PER_SPELL){
            int damage = randomDiceRoll(5,30);
            target.setHealth(target.getHealth() - damage);
            setMana(getMana()-MANA_COST_PER_SPELL);
            addStatus(new CooldownStatus(1,this));
            System.out.println("Your magic attack " + damage);
        }


    }

    private boolean isOnCooldown(){
        return getStatuses().stream().anyMatch(obj -> obj.getClass().equals(CooldownStatus.class));
    }


    public static class Builder extends Adventurer.Builder<Mage>{

        @Override
        public Mage build() {
            armourSet = buildArmourSet();
            return new Mage(name,weapon,armourSet);
        }
    }
}
