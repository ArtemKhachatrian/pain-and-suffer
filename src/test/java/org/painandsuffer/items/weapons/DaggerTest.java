package org.painandsuffer.items.weapons;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DaggerTest {

    @Test
    public void whenDaggerCreatedWithDefaultDamageAndDurability_thenDaggerCreatedWithDamage10AndDurability100(){
        Dagger dagger = new Dagger();
        int daggerDamage = 10;
        int daggerDurability = 100;
        assertNotNull(dagger);
        assertEquals(dagger.getDamage(),daggerDamage);
        assertEquals(dagger.getDurability(),daggerDurability);
    }

    @Test
    public void whenDaggerUseDescription_thenDescriptionAppears(){
        Dagger dagger = new Dagger();
        String daggerDescription = dagger.description();
        assertNotNull(dagger);
    }

}