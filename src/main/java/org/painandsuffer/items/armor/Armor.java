package org.painandsuffer.items.armor;

import org.painandsuffer.characters.Creature;
import org.painandsuffer.items.Equipable;
import org.painandsuffer.items.Item;
import org.painandsuffer.items.SelfUsableItem;

public abstract class Armor implements Item, Equipable {
    private int defend;
    private int armorDurability;

    public Armor(int defend,int armorDurability){
        setDefend(defend);
        setArmorDurability(armorDurability);
    }

    public int getDefend() {
        return defend;
    }

    public void setDefend(int defend) {
        this.defend = defend;
    }

    public int getArmorDurability() {
        return armorDurability;
    }

    public void setArmorDurability(int armorDurability) {
        this.armorDurability = armorDurability;
    }

    public String description() {
        return "This is just an armor";
    }

}


