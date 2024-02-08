package org.painandsuffer.characters.adventurers;

import org.junit.jupiter.api.Test;
import org.painandsuffer.battle.statuses.ProtectiveStance;
import org.painandsuffer.items.armour.ArmourSet;
import org.painandsuffer.items.armour.chest.Chainmail;
import org.painandsuffer.items.armour.chest.ChestArmour;
import org.painandsuffer.items.armour.chest.Cloth;
import org.painandsuffer.items.armour.chest.LeatherArmour;
import org.painandsuffer.items.weapons.Dagger;
import org.painandsuffer.items.weapons.Fists;
import org.painandsuffer.items.weapons.Sword;
import org.painandsuffer.items.weapons.Weapon;

import java.math.BigDecimal;
import java.math.MathContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RogueTest {
    @Test
    public void whenRogueCreatedUsingBuilderWithOnlyBuild_thenCreateNewRogueWithNameTavAndFistsAsWeaponAndClothAsArmour() {
        Rogue rogue = Rogue.builder().build();
        assertNotNull(rogue);
        assertNotNull(rogue.getArmourSet());
        assertNotNull(rogue.getWeapon());
        assertEquals(new Fists(), rogue.getWeapon());
        assertEquals(new Cloth(), rogue.getArmourSet().getChestArmour());
        assertEquals("Tav", rogue.getName());
    }

    @Test
    public void whenRogueCreatedUsingBuilderWithSpecificName_thenNameShouldBeSetToRogue() {
        String name = "Artemis";
        Rogue rogue = Rogue.builder().name(name).build();
        assertNotNull(rogue);
        assertNotNull(rogue.getName());
        assertEquals(name, rogue.getName());
    }

    @Test
    public void whenRogueCreatedUsingBuilderWithDagger_thenWeaponShouldBeSetToRogue() {
        Weapon dagger = new Dagger();
        Rogue rogue = Rogue.builder().weapon(dagger).build();
        assertNotNull(rogue);
        assertNotNull(rogue.getWeapon());
        assertEquals(dagger, rogue.getWeapon());
    }

    @Test
    public void whenRogueCreatedUsingBuilderWithChestArmour_thenArmourSetWithChestArmourShouldBeCreatedAndSetToRogue() {
        ChestArmour leatherArmour = new LeatherArmour();
        Rogue rogue = Rogue.builder().armourSet(ArmourSet.builder().chestArmour(new LeatherArmour()).build()).build();
        assertNotNull(rogue);
        assertNotNull(rogue.getArmourSet());
        assertNotNull(rogue.getArmourSet().getChestArmour());
        assertEquals(leatherArmour, rogue.getArmourSet().getChestArmour());
    }

    @Test
    public void whenRogueHasAnyPieceOfArmourWithDefenceFromBuilder_thenRogueDefenceShouldBeIncreasedOnThatAmount() {
        ChestArmour leatherArmour = new LeatherArmour();
        int basicRogueDefence = Rogue.builder().build().getDefence();
        Rogue rogue = Rogue.builder().armourSet(ArmourSet.builder().chestArmour(new LeatherArmour()).build()).build();
        assertNotNull(rogue);
        assertNotNull(rogue.getArmourSet());
        assertNotNull(rogue.getArmourSet().getChestArmour());
        assertEquals(basicRogueDefence + leatherArmour.getDefence(), rogue.getDefence());
    }

    @Test
    public void whenArmourItemEquippedOnDefaultRogue_thenItemShouldBeEquippedAndRogueDefenceShouldBeIncreasedOnThatAmount() {
        ChestArmour leatherArmour = new LeatherArmour();
        Rogue rogue = Rogue.builder().build();
        int basicRogueDefence = rogue.getDefence();

        rogue.equipItem(leatherArmour);
        ChestArmour actualArmour = rogue.getArmourSet().getChestArmour();

        assertNotNull(rogue);
        assertNotNull(rogue.getArmourSet());
        assertNotNull(actualArmour);
        assertEquals(basicRogueDefence + leatherArmour.getDefence(), rogue.getDefence());
        assertEquals(leatherArmour, actualArmour);
    }

    @Test
    public void whenRogueWithDefaultArmorUseEvasion(){
        Rogue rogue = Rogue.builder().build();
        assertNotNull(rogue);
        int currentRogueEvasionRate = rogue.getEvasionRate();
        rogue.defend();
        int changedRogueEvasionRate = rogue.getEvasionRate();
        assertNotEquals(currentRogueEvasionRate,changedRogueEvasionRate);
        assertTrue(currentRogueEvasionRate<changedRogueEvasionRate);
    }

    @Test
    public void whenRogueWithDaggerUseAttackToTargetWithNoArmor_thenTargetShouldLoseHP(){
        Rogue rogue = Rogue.builder().weapon(new Dagger()).build();
        Rogue target = Rogue.builder().build();
        assertNotNull(rogue);
        assertNotNull(target);
        int currentTargetHP = target.getHealth();
        rogue.attack(target);
        int changedTargetHP = target.getHealth();
        assertNotEquals(currentTargetHP,changedTargetHP);
        assertTrue(currentTargetHP>changedTargetHP);
    }

    @Test
    public void whenRogueWithDefaultWeaponAttackTargetWithCriticalAttack_thenTargetShouldLoseHP(){
        Rogue rogue = Rogue.builder().build();
        Rogue target = Rogue.builder().build();
        target.setDefence(0);
        assertNotNull(rogue);
        assertNotNull(target);
        int currentTargetHP = target.getHealth();
        rogue.attack(target);
        int changedTargetHP = target.getHealth();
        assertNotEquals(currentTargetHP,changedTargetHP);
        assertTrue(currentTargetHP>changedTargetHP);
    }
}
