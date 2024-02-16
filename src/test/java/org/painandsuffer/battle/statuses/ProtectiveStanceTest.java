package org.painandsuffer.battle.statuses;

import org.junit.jupiter.api.Test;
import org.painandsuffer.battle.Battle;
import org.painandsuffer.characters.Creature;
import org.painandsuffer.characters.adventurers.Mage;
import org.painandsuffer.characters.adventurers.Warrior;

import static org.junit.jupiter.api.Assertions.*;

class ProtectiveStanceTest {

    @Test
    public void whenWarriorWithoutArmorUseProtectiveStance_thenWarriorProtectionWillBe4(){
        Warrior warrior = new Warrior.Builder().build();
        int warriorDefaultDefense = warrior.getDefence();
        warrior.defend();
        int warriorDefenseWithProtectiveStance = warrior.getDefence();
        assertEquals(3, warriorDefaultDefense);
        assertEquals(4,warriorDefenseWithProtectiveStance);
    }

    @Test
    public void whenWarriorUseProtectiveStance_thenAfter3RoundsProtectiveStanceWillBeOut(){
        Warrior warrior = new Warrior.Builder().build();
        int warriorDefaultDefence = warrior.getDefence();
        Mage enemy = new Mage.Builder().build();
        Battle battle = new Battle();
        warrior.defend();
        int warriorDefenceWithProtection = warrior.getDefence();
        battle.providePvP(warrior,enemy);
        assertNotNull(warrior);
        assertNotNull(enemy);
        assertTrue(warriorDefaultDefence < warriorDefenceWithProtection);
    }
}