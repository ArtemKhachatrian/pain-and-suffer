package org.painandsuffer.items;

import org.painandsuffer.characters.Creature;

public interface SelfUsableItem extends Item {
    void useByYourself(Creature creature);
}
