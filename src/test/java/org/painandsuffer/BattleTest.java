package org.painandsuffer;

import org.junit.jupiter.api.Test;
import org.painandsuffer.battle.Battle;
import org.painandsuffer.characters.adventurers.Adventurer;
import org.painandsuffer.characters.adventurers.Mage;
import org.painandsuffer.characters.adventurers.Warrior;
import org.painandsuffer.items.armor.chest.Robe;
import org.painandsuffer.items.weapon.Fists;
import org.painandsuffer.items.weapon.Sword;

import static org.junit.jupiter.api.Assertions.*;

class BattleTest {
    @Test
    public void whenCharacterAttacked_thenShouldLoseHP(){
        Adventurer warrior = new Warrior("MegaPiharb");
        Adventurer mage = new Mage("AnalDestroyer");
        int initialHealth = mage.getHealth();
        warrior.attack(mage);
        int damagedHealth = mage.getHealth();
        assertTrue(initialHealth > damagedHealth);
        assertEquals(100,initialHealth);
    }

    @Test
    public void whenCharacterAttackedWithSword_thenShouldLoseHP(){
        Adventurer warrior = new Warrior("MegaPiharb", new Sword());
        Adventurer mage = new Mage("AnalDestroyer");
        int initialHealth = mage.getHealth();
        warrior.attack(mage);
        int damagedHealth = mage.getHealth();
        assertTrue(initialHealth > damagedHealth);
        assertEquals(100,initialHealth);
        assertTrue(damagedHealth>20);
    }

    @Test
    public void whenCharacterAttackedWithArmor_thenShouldLoseHP(){
        Adventurer warrior = new Warrior("MegaPiharb", new Sword());
        Adventurer mage = new Mage("AnalDestroyer", new Robe());
        int initialHealth = mage.getHealth();
        warrior.attack(mage);
        int damagedHealth = mage.getHealth();
        assertTrue(initialHealth > damagedHealth);
        assertEquals(100,initialHealth);
    }

    @Test
    public void whenBattleStartsWithCounter(){
        Battle battle = new Battle();
        Adventurer warrior = new Warrior("MegaPiharb", new Fists());
        Adventurer mage = new Mage("AnalDestroyer", new Robe());
        battle.providePvP(warrior,mage);
        assertTrue(battle.getRoundCounter()>0);
    }


}
