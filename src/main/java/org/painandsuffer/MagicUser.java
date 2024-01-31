package org.painandsuffer;

import org.painandsuffer.characters.adventurers.Adventurer;

import java.util.Random;

public interface MagicUser {
    Random random = new Random();

    void useMagic(Adventurer target);

    default int randomDiceRoll() {
        return random.nextInt(1, 20);
    }

}
