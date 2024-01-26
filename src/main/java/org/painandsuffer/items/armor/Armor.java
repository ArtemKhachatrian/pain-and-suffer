package org.painandsuffer.items.armor;

public abstract class Armor {
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
}
