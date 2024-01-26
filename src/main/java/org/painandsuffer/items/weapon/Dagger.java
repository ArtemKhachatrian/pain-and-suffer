package org.painandsuffer.items.weapon;


import org.painandsuffer.items.Item;

public class Dagger implements Item, Weapon {

    private  int durability = 100;


    @Override
    public void use() {

    }

    @Override
    public void description() {

    }

    @Override
    public int getDurability() {
        return durability;
    }

    @Override
    public void setDurability(int durability) {
        if (durability<=0){
            System.out.println("Your weapon is broken");
            this.durability = 0;
        }
        else {
            this.durability = durability;
        }

    }

    @Override
    public int damageIncrease() {
        return 10;

    }

    @Override
    public int weaponDurability() {
        return 0;
    }


}
