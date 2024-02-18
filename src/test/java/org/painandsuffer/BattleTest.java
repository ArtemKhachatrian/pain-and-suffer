package org.painandsuffer;

import org.junit.jupiter.api.Test;
import org.painandsuffer.battle.Battle;
import org.painandsuffer.characters.Creature;
import org.painandsuffer.characters.adventurers.Mage;
import org.painandsuffer.characters.adventurers.Rogue;
import org.painandsuffer.characters.adventurers.Warrior;
import org.painandsuffer.items.armour.ArmourSet;
import org.painandsuffer.items.armour.chest.Chainmail;
import org.painandsuffer.items.armour.chest.LeatherArmour;
import org.painandsuffer.items.armour.chest.Robe;
import org.painandsuffer.items.armour.gloves.ChainGloves;
import org.painandsuffer.items.armour.gloves.LeatherGloves;
import org.painandsuffer.items.weapons.Dagger;
import org.painandsuffer.items.weapons.Staff;
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
        assertEquals(100, initialHealth);
        assertTrue(initialHealth > damagedHealth);
    }

    @Test
    public void whenBattleStartsWithCounter() {
        Battle battle = new Battle();
        Creature warrior = createNewWarrior();
        Creature mage = createNewMage();
        battle.providePvP(warrior, mage);
        assertTrue(battle.getRoundCounter() > 0);
    }

    @Test
    public void whenWarriorBuildWithAllFields(){
        Warrior warrior = Warrior.builder().name("Ares").health(200).defence(20).magicProtection(10).evasionRate(30).
                damage(20).criticalRate(7).weapon(new Sword()).armourSet(ArmourSet.builder().
                        chestArmour(new Chainmail()).
                        glovesArmour(new ChainGloves()).build()).build();
        String name = "Ares";

        assertNotNull(warrior);
        assertNotNull(warrior.getWeapon());
        assertNotNull(warrior.getArmourSet());
        assertEquals(name,warrior.getName());
        assertEquals(200,warrior.getHealth());
        assertEquals(40,warrior.getDefence());
        assertEquals(10,warrior.getMagicProtection());
        assertEquals(30,warrior.getEvasionRate());
        assertEquals(20,warrior.getDamage());
        assertEquals(7,warrior.getCriticalRate());
        assertEquals(20,warrior.getDamage());
    }

    @Test
    public void whenMageBuildWithAllFields(){
        Mage mage = Mage.builder().name("Ben").health(200).defence(20).magicProtection(10).evasionRate(30).
                damage(20).criticalRate(7).weapon(new Staff()).armourSet(ArmourSet.builder().
                        chestArmour(new Robe()).
                        glovesArmour(new LeatherGloves()).build()).build();
        String name = "Ben";

        assertNotNull(mage);
        assertNotNull(mage.getWeapon());
        assertNotNull(mage.getArmourSet());
        assertEquals(name,mage.getName());
        assertEquals(200,mage.getHealth());
        assertEquals(28,mage.getDefence());
        assertEquals(10,mage.getMagicProtection());
        assertEquals(30,mage.getEvasionRate());
        assertEquals(20,mage.getDamage());
        assertEquals(7,mage.getCriticalRate());
        assertEquals(20,mage.getDamage());
        assertEquals(100,mage.getMana());
    }

    @Test
    public void whenRogueBuildWithAllFields(){
        Rogue rogue = Rogue.builder().name("Catty").health(200).defence(20).magicProtection(10).evasionRate(30).
                damage(20).criticalRate(7).weapon(new Dagger()).armourSet(ArmourSet.builder().
                        chestArmour(new LeatherArmour()).
                        glovesArmour(new LeatherGloves()).build()).build();
        String name = "Catty";

        assertNotNull(rogue);
        assertNotNull(rogue.getWeapon());
        assertNotNull(rogue.getArmourSet());
        assertEquals(name,rogue.getName());
        assertEquals(200,rogue.getHealth());
        assertEquals(33,rogue.getDefence());
        assertEquals(10,rogue.getMagicProtection());
        assertEquals(30,rogue.getEvasionRate());
        assertEquals(20,rogue.getDamage());
        assertEquals(7,rogue.getCriticalRate());
        assertEquals(20,rogue.getDamage());
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
