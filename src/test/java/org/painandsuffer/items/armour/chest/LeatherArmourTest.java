package org.painandsuffer.items.armour.chest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeatherArmourTest {
    @Test
    public void whenLeatherArmourCreatedWithDefaultDefendAndArmourDurability_thenLeatherArmourCreatedWithDefend10AndArmourDurability100(){
        LeatherArmour leatherArmour = new LeatherArmour();
        int clothDefend = 10;
        int clothDurability = 100;
        assertNotNull(leatherArmour);
        assertEquals(leatherArmour.getDefence(),clothDefend);
        assertEquals(leatherArmour.getArmourDurability(),clothDurability);
    }

    @Test
    public void whenLeatherArmourCreatedWithDefaultAndOverride_thenLeatherArmourHasNewDefenceAndArmourDurability(){
        LeatherArmour leatherArmour = new LeatherArmour();
        leatherArmour.setDefence(15);
        leatherArmour.setArmourDurability(150);
        assertNotNull(leatherArmour);
        assertEquals(leatherArmour.getDefence(),15);
        assertEquals(leatherArmour.getArmourDurability(),150);
    }

    @Test
    public void whenLeatherArmourUseDescription_thenDescriptionAppears(){
        LeatherArmour leatherArmour = new LeatherArmour();
        String clothDescription = leatherArmour.description();
        assertNotNull(leatherArmour);
    }

}