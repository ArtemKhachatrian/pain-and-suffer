package org.painandsuffer.battle.statuses;

import org.junit.jupiter.api.Test;
import org.painandsuffer.battle.Battle;
import org.painandsuffer.characters.adventurers.Mage;
import org.painandsuffer.characters.adventurers.Warrior;

import static org.junit.jupiter.api.Assertions.*;

class MagicShieldTest {

    @Test
    public void whenMageWithDefaultArmorUseMagicShield_thenMageUpHisMagicProtection(){
        Mage mage = Mage.builder().build();
        Warrior warrior = Warrior.builder().build();
        int mageDefaultMagicProtection = mage.getMagicProtection();
        Battle battle = new Battle();
        mage.defend();
        int mageMagicProtectionWithMagicShield = mage.getMagicProtection();
        battle.providePvP(mage,warrior);
        assertNotNull(mage);
        assertNotNull(warrior);
        assertTrue(mageDefaultMagicProtection < mageMagicProtectionWithMagicShield);
    }

}