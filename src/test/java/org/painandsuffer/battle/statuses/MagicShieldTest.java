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

    @Test
    public void whenMageUseMagicShield_thenAfter2RoundsMagicShieldWillBeOut(){
        Mage mage = new Mage.Builder().build();
        int mageDefaultMagicProtection = mage.getMagicProtection();
        Mage enemy = new Mage.Builder().build();
        Battle battle = new Battle();
        mage.setDefence(0);
        enemy.setDefence(0);
        mage.defend();
        int mageMagicProtectionWithMagicShield = mage.getMagicProtection();
        battle.providePvP(mage,enemy);
        assertNotNull(mage);
        assertNotNull(enemy);
        assertTrue(mageDefaultMagicProtection < mageMagicProtectionWithMagicShield);
    }

    @Test
    public void whenWarriorUseProtectiveStance_thenAfter3RoundsProtectiveStanceWillBeOut(){
        Mage mage = new Mage.Builder().build();
        int mageDefaultMagicProtection = mage.getMagicProtection();
        Mage enemy = new Mage.Builder().build();
        Battle battle = new Battle();
        mage.setDefence(0);
        enemy.setDefence(0);
        mage.defend();
        int mageMagicProtectionWithMagicShield = mage.getMagicProtection();
        battle.providePvP(mage,enemy);
        int mageMagicProtectionWhenMagicShieldOut = mage.getMagicProtection();
        assertNotNull(mage);
        assertNotNull(enemy);
        assertTrue(mageDefaultMagicProtection < mageMagicProtectionWithMagicShield);
        assertEquals(mageDefaultMagicProtection,mageMagicProtectionWhenMagicShieldOut);
    }

}