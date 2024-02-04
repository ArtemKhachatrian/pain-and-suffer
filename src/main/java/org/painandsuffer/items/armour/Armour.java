package org.painandsuffer.items.armour;

import org.painandsuffer.items.Equipable;
import org.painandsuffer.items.Item;

public abstract class Armour implements Item, Equipable {
    private int defence;
    private int armourDurability;

    public Armour(int defence, int armourDurability) {
        setDefence(defence);
        setArmourDurability(armourDurability);
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getArmourDurability() {
        return armourDurability;
    }

    public void setArmourDurability(int armourDurability) {
        this.armourDurability = armourDurability;
    }

    public String description() {
        return "This is just an armor";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Armour armour)) return false;

        if (defence != armour.defence) return false;
        return armourDurability == armour.armourDurability;
    }

    @Override
    public int hashCode() {
        int result = defence;
        result = 31 * result + armourDurability;
        return result;
    }
}


