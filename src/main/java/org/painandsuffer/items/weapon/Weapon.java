package org.painandsuffer.items.weapon;

public interface Weapon {
    default int damageIncrease(){
        return 0;
    };
    int weaponDurability();
}
