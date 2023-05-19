package edu.ggc.itec.lutz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PixelTest {

    @Test
    void testNotEquals() {
        Pixel a = new Pixel(1,1,1);
        Pixel b = new Pixel (12,14,71);
        assertNotEquals(a,b);
    }

    void testEquals() {
        Pixel a = new Pixel(12,14,71);
        Pixel b = new Pixel (12,14,71);
        assertEquals(a,b);
    }
}