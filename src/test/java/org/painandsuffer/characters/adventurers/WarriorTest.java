package org.painandsuffer.characters.adventurers;

import org.junit.jupiter.api.Test;
import org.painandsuffer.battle.statuses.ProtectiveStance;
import org.painandsuffer.items.armour.ArmourSet;
import org.painandsuffer.items.armour.chest.Chainmail;
import org.painandsuffer.items.armour.chest.ChestArmour;
import org.painandsuffer.items.armour.chest.Cloth;
import org.painandsuffer.items.weapons.Fists;
import org.painandsuffer.items.weapons.Sword;
import org.painandsuffer.items.weapons.Weapon;

import java.math.BigDecimal;
import java.math.MathContext;

import static org.junit.jupiter.api.Assertions.*;

class WarriorTest {

    @Test
    public void whenWarriorCreatedUsingBuilderWithOnlyBuild_thenCreateNewWarriorWithNameTavAndFistsAsWeaponAndClothAsArmour() {
        Warrior warrior = Warrior.builder().build();
        assertNotNull(warrior);
        assertNotNull(warrior.getArmourSet());
        assertNotNull(warrior.getWeapon());
        assertEquals(new Fists(), warrior.getWeapon());
        assertEquals(new Cloth(), warrior.getArmourSet().getChestArmour());
        assertEquals("Tav", warrior.getName());
    }

    @Test
    public void whenWarriorCreatedUsingBuilderWithSpecificName_thenNameShouldBeSetToWarrior() {
        String name = "Ares";
        Warrior warrior = Warrior.builder().name(name).build();
        assertNotNull(warrior);
        assertNotNull(warrior.getName());
        assertEquals(name, warrior.getName());
    }

    @Test
    public void whenWarriorCreatedUsingBuilderWithSword_thenWeaponShouldBeSetToWarrior() {
        Weapon sword = new Sword();
        Warrior warrior = Warrior.builder().weapon(sword).build();
        assertNotNull(warrior);
        assertNotNull(warrior.getWeapon());
        assertEquals(sword, warrior.getWeapon());
    }

    @Test
    public void whenWarriorCreatedUsingBuilderWithChestArmour_thenArmourSetWithChestArmourShouldBeCreatedAndSetToWarrior() {
        ChestArmour chainmail = new Chainmail();
        Warrior warrior = Warrior.builder().armourSet(ArmourSet.builder().chestArmour(new Chainmail()).build()).build();
        assertNotNull(warrior);
        assertNotNull(warrior.getArmourSet());
        assertNotNull(warrior.getArmourSet().getChestArmour());
        assertEquals(chainmail, warrior.getArmourSet().getChestArmour());
    }

    @Test
    public void whenWarriorHasAnyPieceOfArmourWithDefenceFromBuilder_thenWarriorDefenceShouldBeIncreasedOnThatAmount() {
        ChestArmour chainmail = new Chainmail();
        int basicWarriorDefence = Warrior.builder().build().getDefence();
        Warrior warrior = Warrior.builder().armourSet(ArmourSet.builder().chestArmour(new Chainmail()).build()).build();
        assertNotNull(warrior);
        assertNotNull(warrior.getArmourSet());
        assertNotNull(warrior.getArmourSet().getChestArmour());
        assertEquals(basicWarriorDefence + chainmail.getDefence(), warrior.getDefence());
    }

    @Test
    public void whenArmourItemEquippedOnDefaultWarrior_thenItemShouldBeEquippedAndWarriorDefenceShouldBeIncreasedOnThatAmount() {
        ChestArmour chainmail = new Chainmail();
        Warrior warrior = Warrior.builder().build();
        int basicWarriorDefence = warrior.getDefence();

        warrior.equipItem(chainmail);
        ChestArmour actualArmour = warrior.getArmourSet().getChestArmour();

        assertNotNull(warrior);
        assertNotNull(warrior.getArmourSet());
        assertNotNull(actualArmour);
        assertEquals(basicWarriorDefence + chainmail.getDefence(), warrior.getDefence());
        assertEquals(chainmail, actualArmour);
    }

    @Test
    public void whenWarriorCreatedWithoutArmourAndUsesDefend_thenDefenceShouldBeIncreasedOnExpectedAmount() {
        Warrior warrior = Warrior.builder().build();
        assertNotNull(warrior);
        int expectedDefence = new BigDecimal(warrior.getDefence()).multiply(ProtectiveStance.ARMOUR_MULTIPLIER)
                .round(new MathContext(ProtectiveStance.PRECISION, ProtectiveStance.ROUNDING_MODE))
                .intValue();
        warrior.defend();

        assertEquals(expectedDefence, warrior.getDefence());
    }

    @Test
    public void whenWarriorCreatedWithArmourAndUsesDefend_thenDefenceShouldBeIncreasedOnExpectedAmount() {
        Warrior warrior = Warrior.builder().armourSet(ArmourSet.builder().chestArmour(new Chainmail()).build()).build();
        assertNotNull(warrior);
        int expectedDefence = new BigDecimal(warrior.getDefence()).multiply(ProtectiveStance.ARMOUR_MULTIPLIER)
                .round(new MathContext(ProtectiveStance.PRECISION, ProtectiveStance.ROUNDING_MODE))
                .intValue();
        warrior.defend();

        assertEquals(expectedDefence, warrior.getDefence());
    }

    @Test
    public void whenWarriorWithDefaultWeaponAttacksTargetWithNoArmor_thenTargetShouldLoseHP() {
        Warrior warrior = Warrior.builder().armourSet(ArmourSet.builder().chestArmour(new Chainmail()).build()).build();
        assertNotNull(warrior);
        int expectedDefence = new BigDecimal(warrior.getDefence()).multiply(ProtectiveStance.ARMOUR_MULTIPLIER)
                .round(new MathContext(ProtectiveStance.PRECISION, ProtectiveStance.ROUNDING_MODE))
                .intValue();
        warrior.defend();

        assertEquals(expectedDefence, warrior.getDefence());
    }

    @Test
    public void whenWarriorWithSwordUseAttackToTargetWithNoArmor_thenTargetShouldLoseHP(){
        Warrior warrior = Warrior.builder().weapon(new Sword()).build();
        Warrior target = Warrior.builder().build();
        assertNotNull(warrior);
        assertNotNull(target);
        int currentTargetHP = target.getHealth();
        warrior.attack(target);
        int changedTargetHP = target.getHealth();
        assertNotEquals(currentTargetHP,changedTargetHP);
        assertTrue(currentTargetHP>changedTargetHP);
    }

    @Test
    public void whenWarriorWithDefaultWeaponAttackTargetWithCriticalAttack_thenTargetShouldLoseHP(){
        Warrior warrior = Warrior.builder().build();
        Warrior target = Warrior.builder().build();
        warrior.setCriticalRate(100);
        target.setDefence(0);
        assertNotNull(warrior);
        assertNotNull(target);
        int currentTargetHP = target.getHealth();
        warrior.attack(target);
        int changedTargetHP = target.getHealth();
        assertNotEquals(currentTargetHP,changedTargetHP);
        assertTrue(currentTargetHP>changedTargetHP);
    }

    @Test
    public void whenWarriorWithDefaultBuilderAndUseSetName_thenNameChanged(){
        Warrior warrior = new Warrior.Builder().build();
        warrior.setName("Robert");
        assertNotNull(warrior);
        assertSame("Robert", warrior.getName());
    }

}