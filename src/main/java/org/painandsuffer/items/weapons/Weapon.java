package org.painandsuffer.items.weapons;

import org.painandsuffer.characters.Creature;
import org.painandsuffer.items.Equipable;
import org.painandsuffer.items.Item;

public abstract class Weapon implements Item, Equipable {

    private final int damage;
    private final int durability;

    public Weapon(int damage, int durability) {
        this.damage = damage;
        this.durability = durability;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Weapon weapon)) return false;

        return damage == weapon.damage;
    }

    @Override
    public int hashCode() {
        int result = damage;
        result = 31 * result + durability;
        return result;
    }

    @Override
    public String description() {
        return "This is just a weapon";
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public void equipItem(Creature creature) {
        creature.setWeapon(this);
    }
}
