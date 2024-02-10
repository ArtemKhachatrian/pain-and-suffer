package org.painandsuffer.items.armour.chest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RobeTest {
    @Test
    public void whenRobeCreatedWithDefaultDefendAndArmourDurability_thenRobeCreatedWithDefend5AndArmourDurability100(){
        Robe robe = new Robe();
        int clothDefend = 5;
        int clothDurability = 100;
        assertNotNull(robe);
        assertEquals(robe.getDefence(),clothDefend);
        assertEquals(robe.getArmourDurability(),clothDurability);
    }

    @Test
    public void whenRobeCreatedWithDefaultAndOverride_thenRobeHasNewDefenceAndArmourDurability(){
        Robe robe = new Robe();
        robe.setDefence(10);
        robe.setArmourDurability(150);
        assertNotNull(robe);
        assertEquals(robe.getDefence(),10);
        assertEquals(robe.getArmourDurability(),150);
    }

    @Test
    public void whenRobeUseDescription_thenDescriptionAppears(){
        Robe robe = new Robe();
        String clothDescription = robe.description();
        assertNotNull(robe);
    }

}