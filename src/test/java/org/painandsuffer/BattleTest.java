package org.painandsuffer;

import org.junit.jupiter.api.Test;
import org.painandsuffer.characters.Adventurer;
import org.painandsuffer.characters.Mage;
import org.painandsuffer.characters.Warrior;
import org.painandsuffer.items.armor.Robe;
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
        Adventurer warrior = new Warrior("MegaPiharb", new Fists());
        Adventurer mage = new Mage("AnalDestroyer", new Robe());
        int initialHealth = mage.getHealth();
        warrior.attack(mage);
        int damagedHealth = mage.getHealth();
        assertTrue(initialHealth > damagedHealth);
        assertEquals(100,initialHealth);
    }
}