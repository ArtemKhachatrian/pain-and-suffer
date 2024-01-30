package org.painandsuffer.items;

import org.painandsuffer.characters.Creature;

public interface TargetableItem extends Item{
    void useOnTarget(Creature creature);
}
