package org.painandsuffer.items.weapons;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SwordTest {

    @Test
    public void whenSwordCreatedWithDefaultDamageAndDurability_thenSwordCreatedWithDamage15AndDurability100(){
        Sword sword = new Sword();
        int swordDamage = 15;
        int swordDurability = 100;
        assertNotNull(sword);
        assertEquals(sword.getDamage(),swordDamage);
        assertEquals(sword.getDurability(),swordDurability);
    }

    @Test
    public void whenSwordUseDescription_thenDescriptionAppears(){
        Sword sword = new Sword();
        String swordDescription = sword.description();
        assertNotNull(sword);
    }
}