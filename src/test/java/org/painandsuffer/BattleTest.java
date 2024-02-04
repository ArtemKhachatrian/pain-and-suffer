package org.painandsuffer;

import org.junit.jupiter.api.Test;
import org.painandsuffer.battle.Battle;
import org.painandsuffer.characters.adventurers.Adventurer;
import org.painandsuffer.characters.adventurers.Mage;
import org.painandsuffer.characters.adventurers.Rogue;
import org.painandsuffer.characters.adventurers.Warrior;
import org.painandsuffer.items.armour.ArmourSet;
import org.painandsuffer.items.armour.chest.Chainmail;
import org.painandsuffer.items.armour.chest.LeatherArmour;
import org.painandsuffer.items.armour.chest.Robe;
import org.painandsuffer.items.weapon.Dagger;
import org.painandsuffer.items.weapon.Fists;
import org.painandsuffer.items.weapon.Sword;
import org.painandsuffer.items.weapon.Weapon;

import static org.junit.jupiter.api.Assertions.*;

class BattleTest {
    @Test
    public void whenCharacterAttacked_thenShouldLoseHP(){
        Adventurer warrior = createNewWarrior();
        Adventurer mage = createNewMage();
        int initialHealth = mage.getHealth();
        warrior.attack(mage);
        int damagedHealth = mage.getHealth();
        assertTrue(initialHealth > damagedHealth);
        assertEquals(100,initialHealth);
    }

    @Test
    public void whenCharacterAttackedWithSword_thenShouldLoseHP(){
        Adventurer warrior = createNewWarriorWithSword();
        Adventurer mage = createNewMage();
        int initialHealth = mage.getHealth();
        warrior.attack(mage);
        int damagedHealth = mage.getHealth();
        assertTrue(initialHealth > damagedHealth);
        assertEquals(100,initialHealth);
        assertTrue(damagedHealth>20);
    }

    @Test
    public void whenCharacterAttackedWithArmour_thenShouldLoseHP(){
        Adventurer warrior = createNewWarrior();
        Adventurer mage = createNewMage();
        int initialHealth = mage.getHealth();
        warrior.attack(mage);
        int damagedHealth = mage.getHealth();
        assertTrue(initialHealth > damagedHealth);
        assertEquals(100,initialHealth);
    }

    @Test
    public void whenBattleStartsWithCounter(){
        Battle battle = new Battle();
        Adventurer warrior = createNewWarrior();
        Adventurer mage = createNewMage();
        battle.providePvP(warrior,mage);
        assertTrue(battle.getRoundCounter()>0);
    }

    private Warrior createNewWarrior(){
        return Warrior.builder().name("Ares").build();
    }

    private Warrior createNewWarriorWithSword(){
        return Warrior.builder().name("Ares").weapon(new Sword()).build();
    }

    private Rogue createNewRogue(){
        return Rogue.builder().name("Artemis").build();
    }
    private Mage createNewMage(){
        return Mage.builder().name("Alister").build();
    }

    @Test
    public void whenCharacterDefends(){
        Battle battle = new Battle();
        Adventurer warrior = createNewWarrior();
        Adventurer mage = createNewMage();
        warrior.getArmourSet().setChestArmour(new Chainmail());
        int armourWithoutDefend = warrior.getArmourSet().getBonusToArmour();
        warrior.defend();
        battle.providePvP(warrior,mage);
        int armourWithDefend = warrior.getArmourSet().getBonusToArmour();
        assertTrue(armourWithDefend > armourWithoutDefend);
    }

}
