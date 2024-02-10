package org.painandsuffer.items.armour.chest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChainmailTest {
    @Test
    public void whenChainmailCreatedWithDefaultDefendAndArmourDurability_thenChainmailCreatedWithDefend15AndArmourDurability100(){
        Chainmail chainmail = new Chainmail();
        int clothDefend = 15;
        int clothDurability = 100;
        assertNotNull(chainmail);
        assertEquals(chainmail.getDefence(),clothDefend);
        assertEquals(chainmail.getArmourDurability(),clothDurability);
    }

    @Test
    public void whenChainmailCreatedWithDefaultAndOverride_thenChainmailHasNewDefenceAndArmourDurability(){
        Chainmail chainmail = new Chainmail();
        chainmail.setDefence(10);
        chainmail.setArmourDurability(150);
        assertNotNull(chainmail);
        assertEquals(chainmail.getDefence(),10);
        assertEquals(chainmail.getArmourDurability(),150);
    }

    @Test
    public void whenChainmailUseDescription_thenDescriptionAppears(){
        Chainmail chainmail = new Chainmail();
        String clothDescription = chainmail.description();
        assertNotNull(chainmail);
    }
}