package org.painandsuffer.battle;

import org.junit.jupiter.api.Test;
import org.painandsuffer.characters.Adventurer;
import org.painandsuffer.characters.Mage;
import org.painandsuffer.characters.Warrior;

import static org.junit.jupiter.api.Assertions.*;

class AdventurerFactoryTest {

    @Test
    void whenCreateAdventurerWithClassWarrior_thenReturnWarrior() throws Exception {
        Adventurer adventurer = AdventurerFactory.createAdventurer("Artem", AdventurerClass.WARRIOR);
        assertInstanceOf(Adventurer.class, adventurer);
        assertInstanceOf(Warrior.class, adventurer);
    }

    @Test
    void whenCreateAdventurerWithClassMage_thenReturnMage() throws Exception {
        Adventurer adventurer = AdventurerFactory.createAdventurer("Artem", AdventurerClass.MAGE);
        assertInstanceOf(Adventurer.class, adventurer);
        assertInstanceOf(Mage.class, adventurer);
    }
}