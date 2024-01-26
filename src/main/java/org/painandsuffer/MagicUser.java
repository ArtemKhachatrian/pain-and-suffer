package org.painandsuffer;

import org.painandsuffer.characters.Adventurer;

import java.util.Random;

public interface MagicUser {
    Random random = new Random();
   void useMagic(Adventurer target);

     default int randomDiceRoll() {
        return random.nextInt(1, 20);
    }



}
