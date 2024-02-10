package org.painandsuffer.items.armour.chest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClothTest {
    @Test
    public void whenClothCreatedWithDefaultDefendAndArmourDurability_thenClothCreatedWithDefend0AndArmourDurability100(){
        Cloth cloth = new Cloth();
        int clothDefend = 0;
        int clothDurability = 100;
        assertNotNull(cloth);
        assertEquals(cloth.getDefence(),clothDefend);
        assertEquals(cloth.getArmourDurability(),clothDurability);
    }

    @Test
    public void whenClothCreatedWithDefaultAndOverride_thenClothHasNewDefenceAndArmourDurability(){
        Cloth cloth = new Cloth();
        cloth.setDefence(10);
        cloth.setArmourDurability(150);
        assertNotNull(cloth);
        assertEquals(cloth.getDefence(),10);
        assertEquals(cloth.getArmourDurability(),150);
    }

    @Test
    public void whenClothUseDescription_thenDescriptionAppears(){
        Cloth cloth = new Cloth();
        String clothDescription = cloth.description();
        assertNotNull(cloth);
    }

}