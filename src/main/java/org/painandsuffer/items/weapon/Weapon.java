package org.painandsuffer.items.weapon;

import org.painandsuffer.characters.adventurers.Adventurer;
import org.painandsuffer.items.Equipable;
import org.painandsuffer.items.Item;

public abstract class Weapon implements Item, Equipable {

    private final int damageIncrease;

    private final int durability;

    public Weapon(int damageIncrease, int durability) {
        this.damageIncrease = damageIncrease;
        this.durability = durability;
    }

    @Override
    public String description() {
        return "This is just a weapon";
    }

    public int getDamageIncrease() {
        return damageIncrease;
    }

    @Override
    public void equipOnAdventurer(Adventurer adventurer) {
        adventurer.setWeapon(this);
    }
}
