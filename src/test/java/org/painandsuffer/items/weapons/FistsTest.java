package org.painandsuffer.items.weapons;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FistsTest { @Test
public void whenFistsCreatedWithDefaultDamageAndDurability_thenFistsCreatedWithDamage0AndDurability1000000(){
    Fists fists = new Fists();
    int fistsDamage = 0;
    int fistsDurability = 1000000;
    assertNotNull(fists);
    assertEquals(fists.getDamage(),fistsDamage);
    assertEquals(fists.getDurability(),fistsDurability);
}

    @Test
    public void whenFistsUseDescription_thenDescriptionAppears(){
        Fists fists = new Fists();
        String fistsDescription = fists.description();
        assertNotNull(fists);
    }

}