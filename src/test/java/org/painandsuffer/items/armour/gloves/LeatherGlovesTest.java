package org.painandsuffer.items.armour.gloves;

import org.junit.jupiter.api.Test;
import org.painandsuffer.items.armour.chest.Chainmail;

import static org.junit.jupiter.api.Assertions.*;

class LeatherGlovesTest {
    @Test
    public void whenLeatherGlovesCreatedWithDefaultDefendAndArmourDurability_thenLeatherGlovesCreatedWithDefend3AndArmourDurability50(){
        LeatherGloves leatherGloves = new LeatherGloves();
        int leatherGlovesDefend = 3;
        int leatherGlovesDurability = 50;
        assertNotNull(leatherGloves);
        assertEquals(leatherGloves.getDefence(),leatherGlovesDefend);
        assertEquals(leatherGloves.getArmourDurability(),leatherGlovesDurability);
    }

    @Test
    public void whenLeatherGlovesCreatedWithDefaultAndOverride_thenLeatherGlovesHasNewDefenceAndArmourDurability(){
        LeatherGloves leatherGloves = new LeatherGloves();
        leatherGloves.setDefence(10);
        leatherGloves.setArmourDurability(150);
        assertNotNull(leatherGloves);
        assertEquals(leatherGloves.getDefence(),10);
        assertEquals(leatherGloves.getArmourDurability(),150);
    }

    @Test
    public void whenLeatherGlovesUseDescription_thenDescriptionAppears(){
        LeatherGloves leatherGloves = new LeatherGloves();
        String leatherGlovesDescription = leatherGloves.description();
        assertNotNull(leatherGloves);
    }

}