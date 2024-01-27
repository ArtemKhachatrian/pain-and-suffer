package org.painandsuffer.battle;

import org.painandsuffer.characters.Adventurer;


public class AdventurerFactory {
    public static Adventurer createAdventurer(String name, AdventurerClass adventurerClass) {
        Object createdAdventurer = createAdventurerByClass(name, adventurerClass);
        return createdAdventurer instanceof Adventurer ? (Adventurer) createdAdventurer : null;
    }

    private static Object createAdventurerByClass(String name, AdventurerClass adventurerClass) {
        try {
            return Class.forName("org.painandsuffer.characters.".concat(adventurerClass.toString())).getDeclaredConstructor(String.class).newInstance(name);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}

