package org.painandsuffer;

import org.junit.jupiter.api.Test;
import org.painandsuffer.battle.Battle;
import org.painandsuffer.characters.Creature;
import org.painandsuffer.characters.adventurers.Mage;
import org.painandsuffer.characters.adventurers.Rogue;
import org.painandsuffer.characters.adventurers.Warrior;
import org.painandsuffer.items.armour.chest.Chainmail;
import org.painandsuffer.items.weapons.Sword;

import static org.junit.jupiter.api.Assertions.*;

class BattleTest {
    @Test
    public void whenCharacterAttacked_thenShouldLoseHP() {
        Creature warrior = createNewWarrior();
        Creature mage = createNewMage();
        mage.setDefence(0);
        mage.setEvasionRate(0);
        int initialMageHealth = mage.getHealth();
        warrior.attack(mage);
        int damagedMageHealth = mage.getHealth();
        assertTrue(initialMageHealth > damagedMageHealth);
        assertNotEquals(initialMageHealth,damagedMageHealth);
    }

    @Test
    public void whenCharacterAttackedWithSword_thenShouldLoseHP() {
        Creature warrior = createNewWarriorWithSword();
        Creature mage = createNewMage();
        int initialHealth = mage.getHealth();
        warrior.attack(mage);
        int damagedHealth = mage.getHealth();
        assertTrue(initialHealth > damagedHealth);
        assertEquals(100, initialHealth);
        assertTrue(damagedHealth > 20);
    }

    @Test
    public void whenCharacterAttackedWithArmour_thenShouldLoseHP() {
        Creature warrior = createNewWarrior();
        Creature mage = createNewMage();
        int initialHealth = mage.getHealth();
        warrior.attack(mage);
        int damagedHealth = mage.getHealth();
        assertTrue(initialHealth > damagedHealth);
        assertEquals(100, initialHealth);
    }

    @Test
    public void whenBattleStartsWithCounter() {
        Battle battle = new Battle();
        Creature warrior = createNewWarrior();
        Creature mage = createNewMage();
        battle.providePvP(warrior, mage);
        assertTrue(battle.getRoundCounter() > 0);
    }

    private Warrior createNewWarrior() {
        return Warrior.builder().name("Ares").build();
    }

    private Warrior createNewWarriorWithSword() {
        return Warrior.builder().name("Ares").weapon(new Sword()).build();
    }

    private Rogue createNewRogue() {
        return Rogue.builder().name("Artemis").build();
    }

    private Mage createNewMage() {
        return Mage.builder().name("Alister").build();
    }



}
