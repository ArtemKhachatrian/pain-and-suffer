package org.painandsuffer.items.armour.gloves;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChainGlovesTest {
    @Test
    public void whenChainGlovesCreatedWithDefaultDefendAndArmourDurability_thenLeatherGlovesCreatedWithDefend3AndArmourDurability50(){
        ChainGloves chainGloves = new ChainGloves();
        int chainGlovesDefend = 5;
        int chainGlovesDurability = 60;
        assertNotNull(chainGloves);
        assertEquals(chainGloves.getDefence(),chainGlovesDefend);
        assertEquals(chainGloves.getArmourDurability(),chainGlovesDurability);
    }

    @Test
    public void whenChainGlovesCreatedWithDefaultAndOverride_thenLeatherGlovesHasNewDefenceAndArmourDurability(){
        ChainGloves chainGloves = new ChainGloves();
        chainGloves.setDefence(10);
        chainGloves.setArmourDurability(150);
        assertNotNull(chainGloves);
        assertEquals(chainGloves.getDefence(),10);
        assertEquals(chainGloves.getArmourDurability(),150);
    }

    @Test
    public void whenChainGlovesUseDescription_thenDescriptionAppears(){
        ChainGloves chainGloves = new ChainGloves();
        String chainGlovesDescription = chainGloves.description();
        assertNotNull(chainGloves);
    }

}