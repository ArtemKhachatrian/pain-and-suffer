package org.painandsuffer.battle;

import org.painandsuffer.characters.Adventurer;

import java.lang.reflect.InvocationTargetException;

public class AdventurerFactory {
    public static Adventurer createAdventurer(String name, AdventurerClass adventurerClass)
            throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Object createdAdventurer = createAdventurerByClass(name, adventurerClass);
        return createdAdventurer instanceof Adventurer ? (Adventurer) createdAdventurer : null;
    }

    private static Object createAdventurerByClass(String name, AdventurerClass adventurerClass)
            throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return Class.forName("org.painandsuffer.characters.".concat(adventurerClass.toString())).getDeclaredConstructor(String.class).newInstance(name);
    }

}

