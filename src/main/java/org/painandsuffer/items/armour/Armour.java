package org.painandsuffer.items.armour;

import org.painandsuffer.items.Equipable;
import org.painandsuffer.items.Item;

public abstract class Armour implements Item, Equipable {
    private int defend;
    private int armourDurability;

    public Armour(int defend, int armourDurability) {
        setDefend(defend);
        setArmourDurability(armourDurability);
    }

    public int getDefend() {
        return defend;
    }

    public void setDefend(int defend) {
        this.defend = defend;
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

}


