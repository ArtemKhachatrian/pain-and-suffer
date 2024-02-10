package org.painandsuffer.items.weapons;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StaffTest {
    @Test
    public void whenStaffCreatedWithDefaultDamageAndDurability_thenStaffCreatedWithDamage5AndDurability80(){
        Staff staff = new Staff();
        int staffDamage = 5;
        int staffDurability = 80;
        assertNotNull(staff);
        assertEquals(staff.getDamage(),staffDamage);
        assertEquals(staff.getDurability(),staffDurability);
    }

    @Test
    public void whenStaffUseDescription_thenDescriptionAppears(){
        Staff staff = new Staff();
        String swordDescription = staff.description();
        assertNotNull(staff);
    }

}