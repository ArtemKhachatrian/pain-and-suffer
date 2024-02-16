package org.painandsuffer.items.armour.chest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RobeTest {
    @Test
    public void whenRobeCreatedWithDefaultDefendAndArmourDurability_thenRobeCreatedWithDefend5AndArmourDurability100(){
        Robe robe = new Robe();
        int robeDefend = 5;
        int robeDurability = 100;
        assertNotNull(robe);
        assertEquals(robe.getDefence(),robeDefend);
        assertEquals(robe.getArmourDurability(),robeDurability);
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
        String robeDescription = robe.description();
        assertNotNull(robe);
    }

}