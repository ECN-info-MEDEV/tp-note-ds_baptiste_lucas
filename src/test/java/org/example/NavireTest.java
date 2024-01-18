package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NavireTest {
    @Test
    void testNavire() {
        Navire navire = new Navire(3);
        assertEquals(navire.getSize(), 3);
        assertEquals(navire.getName(), "Destroyer");
        assertEquals(navire.toString(), "D");
        navire = new Navire(4);
        assertEquals(navire.getSize(), 4);
        assertEquals(navire.getName(), "Cuirassé");
        assertEquals(navire.toString(), "C");
        navire = new Navire(5);
        assertEquals(navire.getSize(), 5);
        assertEquals(navire.getName(), "Porte-avions");
        assertEquals(navire.toString(), "P");
    }
}