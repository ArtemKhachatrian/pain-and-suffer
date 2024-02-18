package org.painandsuffer.battle.statuses;

import org.junit.jupiter.api.Test;
import org.painandsuffer.battle.Battle;
import org.painandsuffer.characters.adventurers.Mage;
import org.painandsuffer.characters.adventurers.Rogue;
import org.painandsuffer.characters.adventurers.Warrior;

import static org.junit.jupiter.api.Assertions.*;

class EvasiveTest {

    @Test
    public void whenRogueUseEvasive_thenEvasiveRateIsBigger(){
        Rogue rogue = new Rogue.Builder().build();
        int basicRogueEvasion = rogue.getEvasionRate();
        rogue.defend();
        int changedRogueEvasion = rogue.getEvasionRate();
        assertNotNull(rogue);
        assertTrue(basicRogueEvasion < changedRogueEvasion);
    }

    @Test
    public void whenRogueUseEvasive_thenAfter2RoundsEvasiveWillBeOut(){
        Rogue rogue = new Rogue.Builder().build();
        int rogueDefaultEvasiveRate = rogue.getEvasionRate();
        Mage enemy = new Mage.Builder().build();
        Battle battle = new Battle();
        rogue.defend();
        int rogueEvasiveRateWithEvasive = rogue.getEvasionRate();
        battle.providePvP(rogue,enemy);
        assertNotNull(rogue);
        assertNotNull(enemy);
        assertTrue(rogueDefaultEvasiveRate < rogueEvasiveRateWithEvasive);
    }

}