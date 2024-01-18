package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {
    @Test
    void testPoint() {
        Point point = new Point(7, 23);
        assertEquals(point.getX(), 7);
        assertEquals(point.getY(), 23);
        point.setX(37);
        point.setY(51);
        assertEquals(point.getX(), 37);
        assertEquals(point.getY(), 51);
    }

    @Test
    void testIsInArray() {
        Point point = new Point(1, 7);
        ArrayList<Point> array = new ArrayList<>();
        assertFalse(point.isInArray(array));
        array.add(new Point(1, 7));
        assertTrue(point.isInArray(array));
    }
}