package org.painandsuffer.characters.adventurers;

import org.junit.jupiter.api.Test;
import org.painandsuffer.items.armour.ArmourSet;
import org.painandsuffer.items.armour.chest.ChestArmour;
import org.painandsuffer.items.armour.chest.Cloth;
import org.painandsuffer.items.armour.chest.LeatherArmour;
import org.painandsuffer.items.armour.chest.Robe;
import org.painandsuffer.items.weapons.*;

import static org.junit.jupiter.api.Assertions.*;

class MageTest {

    @Test
    public void whenMageCreatedUsingBuilderWithOnlyBuild_thenCreateNewMageWithNameTavAndFistsAsWeaponAndClothAsArmour() {
        Mage mage = Mage.builder().build();
        assertNotNull(mage);
        assertNotNull(mage.getArmourSet());
        assertNotNull(mage.getWeapon());
        assertEquals(new Fists(), mage.getWeapon());
        assertEquals(new Cloth(), mage.getArmourSet().getChestArmour());
        assertEquals("Tav", mage.getName());
    }

    @Test
    public void whenMageCreatedUsingBuilderWithSpecificName_thenNameShouldBeSetToMage() {
        String name = "Artemis";
        Mage mage = Mage.builder().name(name).build();
        assertNotNull(mage);
        assertNotNull(mage.getName());
        assertEquals(name, mage.getName());
    }

    @Test
    public void whenMageCreatedUsingBuilderWithStaff_thenWeaponShouldBeSetToMage() {
        Staff staff = new Staff();
        Mage mage = Mage.builder().weapon(staff).build();
        assertNotNull(mage);
        assertNotNull(mage.getWeapon());
        assertEquals(staff, mage.getWeapon());
    }

    @Test
    public void whenMageCreatedUsingBuilderWithChestArmour_thenArmourSetWithChestArmourShouldBeCreatedAndSetToMage() {
        ChestArmour robe = new Robe();
        Mage mage = Mage.builder().armourSet(ArmourSet.builder().chestArmour(new Robe()).build()).build();
        assertNotNull(mage);
        assertNotNull(mage.getArmourSet());
        assertNotNull(mage.getArmourSet().getChestArmour());
        assertEquals(robe, mage.getArmourSet().getChestArmour());
    }

    @Test
    public void whenMageHasAnyPieceOfArmourWithDefenceFromBuilder_thenMageDefenceShouldBeIncreasedOnThatAmount() {
        ChestArmour robe = new Robe();
        int basicMageDefence = Mage.builder().build().getDefence();
        Mage mage = Mage.builder().armourSet(ArmourSet.builder().chestArmour(new Robe()).build()).build();
        assertNotNull(mage);
        assertNotNull(mage.getArmourSet());
        assertNotNull(mage.getArmourSet().getChestArmour());
        assertEquals(basicMageDefence + robe.getDefence(), mage.getDefence());
    }

    @Test
    public void whenArmourItemEquippedOnDefaultMage_thenItemShouldBeEquippedAndMageDefenceShouldBeIncreasedOnThatAmount() {
        ChestArmour robe = new Robe();
        Mage mage = Mage.builder().build();
        int basicMageDefence = mage.getDefence();

        mage.equipItem(robe);
        ChestArmour actualArmour = mage.getArmourSet().getChestArmour();

        assertNotNull(mage);
        assertNotNull(mage.getArmourSet());
        assertNotNull(actualArmour);
        assertEquals(basicMageDefence + robe.getDefence(), mage.getDefence());
        assertEquals(robe, actualArmour);
    }

    @Test
    public void whenMageWithDefaultArmorUseMagicShield(){
        Mage mage = Mage.builder().build();
        assertNotNull(mage);
        int currentMageMagicProtection = mage.getMagicProtection();
        mage.defend();
        int changedMageMagicProtection = mage.getMagicProtection();
        assertNotEquals(currentMageMagicProtection,changedMageMagicProtection);
        assertTrue(currentMageMagicProtection<changedMageMagicProtection);
    }

    @Test
    public void whenMageWithStaffUseAttackToTargetWithNoArmor_thenTargetShouldLoseHP(){
        Mage mage = Mage.builder().weapon(new Staff()).build();
        Mage target = Mage.builder().build();
        assertNotNull(mage);
        assertNotNull(target);
        int currentTargetHP = target.getHealth();
        mage.attack(target);
        int changedTargetHP = target.getHealth();
        assertNotEquals(currentTargetHP,changedTargetHP);
        assertTrue(currentTargetHP>changedTargetHP);
    }

    @Test
    public void whenMageWithDefaultWeaponAttackTargetWithCriticalAttack_thenTargetShouldLoseHP(){
        Mage mage = Mage.builder().build();
        Mage target = Mage.builder().build();
        target.setDefence(0);
        assertNotNull(mage);
        assertNotNull(target);
        int currentTargetHP = target.getHealth();
        mage.attack(target);
        int changedTargetHP = target.getHealth();
        assertNotEquals(currentTargetHP,changedTargetHP);
        assertTrue(currentTargetHP>changedTargetHP);
    }

    @Test
    public void whenMageWithDefaultWeaponAttackTargetWithUseMagic_thenTargetShouldLoseHPAndMageLoseMana(){
        Mage mage = Mage.builder().build();
        Mage target = Mage.builder().build();
        assertNotNull(mage);
        assertNotNull(target);
        int currentMageMana = mage.getMana();
        int currentTargetHP = target.getHealth();
        mage.useMagic(target);
        int changedMageMana = mage.getMana();
        int changedTargetHP = target.getHealth();
        assertNotEquals(currentMageMana,changedMageMana);
        assertTrue(currentMageMana>changedMageMana);
        assertNotEquals(currentTargetHP,changedTargetHP);
        assertTrue(currentTargetHP>changedTargetHP);
    }

    @Test
    public void whenMageWithDefaultArmorUseMagicShieldAndWarriorAttack_thenMagicShieldDamagedAndHPRemainsSame(){
        Mage mage = Mage.builder().build();
        Warrior warrior = Warrior.builder().weapon(new Sword()).build();
        assertNotNull(mage);
        assertNotNull(warrior);
        mage.setDefence(0);
        int currentMageHP = mage.getHealth();
        mage.defend();
        int currentMageMagicProtection = mage.getMagicProtection();
        warrior.attack(mage);
        int changedMagicProtection = mage.getMagicProtection();
        int changedMageHP = mage.getHealth();
        assertEquals(currentMageHP,changedMageHP);
        assertTrue(currentMageMagicProtection>changedMagicProtection);
        assertNotEquals(currentMageMagicProtection,changedMagicProtection);

    }

}