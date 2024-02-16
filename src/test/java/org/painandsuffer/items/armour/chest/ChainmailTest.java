package org.painandsuffer.items.armour.chest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChainmailTest {
    @Test
    public void whenChainmailCreatedWithDefaultDefendAndArmourDurability_thenChainmailCreatedWithDefend15AndArmourDurability100(){
        Chainmail chainmail = new Chainmail();
        int chainmailDefend = 15;
        int chainmailDurability = 100;
        assertNotNull(chainmail);
        assertEquals(chainmail.getDefence(),chainmailDefend);
        assertEquals(chainmail.getArmourDurability(),chainmailDurability);
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
        String chainmailDescription = chainmail.description();
        assertNotNull(chainmail);
    }
}