package org.painandsuffer.characters;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.painandsuffer.battle.statuses.Status;
import org.painandsuffer.items.Equipable;
import org.painandsuffer.items.armour.ArmourSet;
import org.painandsuffer.items.weapons.Weapon;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;


@Getter
@Setter
@AllArgsConstructor
public abstract class Creature {
    static final Random random = new Random();
    private final List<Status> statuses = new ArrayList<>();
    private String name;
    private int health;
    private int defence;
    private int magicProtection;
    private int evasionRate;
    private int damage;
    private int criticalRate;
    private Weapon weapon;
    private ArmourSet armourSet;

    protected void getArmourBonus() {
        setDefence(getDefence() + armourSet.getBonusToArmour());
    }

    public void attack(Creature target) {
        if (isMissed(target)) return;
        int damage = isCriticalDamage() ? getCurrentBaseDamage() * 2 : getCurrentBaseDamage();
        baseAttack(target, damage);
    }

    public void makeAction(Runnable action){
        progressStatuses();
        action.run();
    }

    public abstract void defend();

    public void equipItem(Equipable item) {
        item.equipItem(this);
    }

    public void setName(String name) {
        if (name.isBlank()) {
            System.out.println("Incorrect name");
            return;
        }
        this.name = name;
    }

    public void setHealth(int health) {
        if (health <= 0) {
            System.out.println("Lol " + getName() + " died");
            this.health = 0;
            return;
        }
        this.health = health;
    }

    public void addStatus(Status status) {
        statuses.add(status);
    }

    public void removeStatus(Status status) {
        statuses.remove(status);
    }

    private void progressStatus(Status status) {
        if (status.isExpired()) {
            removeStatus(status);
            status.onExpired();
        } else {
            status.decreaseDuration();
            status.applyEffect();
        }
    }

    public void progressStatuses() {
        Iterator<Status> statuses = this.getStatuses().iterator();
        while (statuses.hasNext()) {
            Status currentStatus = statuses.next();
            progressStatus(currentStatus);
            if (currentStatus.isExpired()) statuses.remove();
        }
    }

    public int randomDiceRoll(int origin, int bound) {
        if (origin >= bound) return 0;
        return random.nextInt(origin, bound);
    }

    private boolean isMissed(Creature creature) {
        if (checkEvasionRoll(creature)) {
            System.out.println(creature.getName() + " evades your attack!");
            return true;
        } else return false;
    }

    private boolean checkEvasionRoll(Creature creature) {
        return randomDiceRoll(1, 100) < creature.getEvasionRate();
    }

    private boolean isCriticalDamage() {
        if (checkCriticalRoll()) {
            System.out.println(getName() + "has critical attack");
            return true;
        } else return false;
    }

    private boolean checkCriticalRoll() {
        return randomDiceRoll(1, 100) < getCriticalRate();
    }

    private void baseAttack(Creature target, int damage) {
        if (isMagicProtectionGonnaBreak(target, damage)) {
            attackDestroyingMagicProtection(target, damage);
        } else {
            attackMagicProtection(target, damage);
        }
    }

    private int getCurrentBaseDamage() {
        return randomDiceRoll(1, getDamage()) + getWeapon().getDamage();
    }

    private boolean isMagicProtectionGonnaBreak(Creature target, int damageToTarget) {
        return damageToTarget > target.getMagicProtection();
    }

    private void attackDestroyingMagicProtection(Creature target, int damageToTarget) {
        int residualAttack = damageToTarget - target.getMagicProtection();
        int damageDecreasedByArmour = residualAttack > target.getDefence() ? residualAttack - target.getDefence() : 0;
        target.setHealth(getHealth() - damageDecreasedByArmour);
        System.out.println("You attacked " + target.getName() + " for " + damageDecreasedByArmour + " damage");
    }

    private void attackMagicProtection(Creature target, int damageToTarget) {
        target.setMagicProtection(target.getMagicProtection() - damageToTarget);
        System.out.println("You attacked " + target.getName() + ". Magic shield took " + damageToTarget + " damage");
    }

    public abstract static class Builder<T extends Creature> {
        protected String name;
        protected int health;
        protected int defence;
        protected int magicProtection;
        protected int evasionRate;
        protected int damage;
        protected int criticalRate;
        protected Weapon weapon;
        protected ArmourSet armourSet;

        public Builder<T> name(String name) {
            this.name = name;
            return this;
        }

        public Builder<T> health(int health) {
            this.health = health;
            return this;
        }

        public Builder<T> defence(int defence) {
            this.defence = defence;
            return this;
        }

        public Builder<T> magicProtection(int magicProtection) {
            this.magicProtection = magicProtection;
            return this;
        }

        public Builder<T> evasionRate(int evasionRate) {
            this.evasionRate = evasionRate;
            return this;
        }

        public Builder<T> damage(int damage) {
            this.damage = damage;
            return this;
        }

        public Builder<T> criticalRate(int criticalRate) {
            this.criticalRate = criticalRate;
            return this;
        }

        public Builder<T> weapon(Weapon weapon) {
            this.weapon = weapon;
            return this;
        }

        public Builder<T> armourSet(ArmourSet armourSet) {
            this.armourSet = armourSet;
            return this;
        }

        public abstract T build();
    }
}
