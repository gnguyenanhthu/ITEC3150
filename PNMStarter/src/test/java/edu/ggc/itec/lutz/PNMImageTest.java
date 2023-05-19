package edu.ggc.itec.lutz;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class PNMImageTest {

    private static Pixel RED = new Pixel(255,0,0),
            GREEN = new Pixel(0,255,0),
            BLUE = new Pixel(0,0,255),
            YELLOW = new Pixel(255,255,0),
            WHITE = new Pixel(255,255,255),
            BLACK = new Pixel(0,0,0),
            MAGENTA = new Pixel(255,0,255),
            GRAY = new Pixel(127, 127, 127);


    @Test
    void equalsPNM() {
        Pixel[][] aPixels = {{RED, GREEN},{BLUE, WHITE}};
        Pixel[][] bPixels = {{RED, GREEN},{BLUE, WHITE}};
        PNMImage a = new PNMImage("P3", "Junit 1", 255, aPixels);
        PNMImage b = new PNMImage("P3", "Junit 2", 255, bPixels);
        assertEquals(a,b);
    }

    @Test
    void notEqualsPNM() {
        Pixel[][] aPixels = {{RED, GREEN},{BLUE, WHITE}};
        Pixel[][] bPixels = {{RED, GREEN},{BLUE, YELLOW}};
        PNMImage a = new PNMImage("P3", "Junit1", 255, aPixels);
        PNMImage b = new PNMImage("P3", "Junit2", 255, bPixels);
        assertNotEquals(a,b);
    }

    @Test
    void readBinaryPNM() throws IOException {
        Pixel[][] expectedPixels = {{RED,GREEN,BLUE},{YELLOW,WHITE,BLACK}};
        PNMImage expectedImage = new PNMImage("P6", "RGB YWB", 255, expectedPixels);
        PNMImage simpleBinaryImage = PNMImage.readBinaryPNM("D:\\GGC\\Advanced Programming\\PNMStarter\\images\\simple-binary.pnm");
        assertEquals(expectedImage,simpleBinaryImage);
    }

    @Test
    void stack() {
        Pixel alpha = new Pixel(255,255, 255);
        try {
            PNMImage backg = PNMImage.readPNM("D:\\GGC\\Advanced Programming\\PNMStarter\\images\\test-background.pnm");
            PNMImage foreg = PNMImage.readPNM("D:\\GGC\\Advanced Programming\\PNMStarter\\images\\test-foreground.pnm");
            Pixel[][] expectedPixels = {
                    {WHITE,WHITE,WHITE,WHITE,WHITE},
                    {WHITE,BLUE,BLUE,YELLOW,WHITE},
                    {WHITE,MAGENTA,BLUE,BLUE,WHITE},
                    {WHITE,WHITE,WHITE,WHITE,WHITE},
            };
            PNMImage expectedImage = new PNMImage("P3", "RGB YWB", 255, expectedPixels);
            System.out.println(expectedImage);

            PNMImage composite = backg.stack(alpha, foreg);
            System.out.println(composite);

            assertEquals(expectedImage, composite);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void writePNM() throws IOException {
        Pixel[][] pixels = {{RED,GRAY,MAGENTA},{BLACK,YELLOW,WHITE}};
        File file = new File("D:\\GGC\\Advanced Programming\\PNMStarter\\images\\scratch-ascii.pnm");
        PNMImage image = new PNMImage("P3", "Junit", 255, pixels);
        System.out.println("writing " + file.getCanonicalPath());
        PNMImage.writePNM(file.getCanonicalPath(), image);

        PNMImage result = PNMImage.readPNM(file.getCanonicalPath());
        assertEquals(result, image);

        System.out.println("deleting " + file.getCanonicalPath());
        file.delete();

    }

    @Test
    void writeBinaryPNM() throws IOException {

        Pixel[][] pixels = {{RED,GRAY,MAGENTA},{BLACK,YELLOW,WHITE}};
        File file = new File("D:\\GGC\\Advanced Programming\\PNMStarter\\images\\scratch-binary.pnm");

        PNMImage image = new PNMImage("P6", "Junit", 255, pixels);
        PNMImage.writeBinaryPNM(file.getCanonicalPath(), image);

        PNMImage result = PNMImage.readBinaryPNM(file.getCanonicalPath());
        assertEquals(result, image);
        file.delete();
    }


    @Test
    void getPixel() {

        Pixel[][] aPixels = {{RED, GREEN},{BLUE, WHITE}};
        PNMImage a = new PNMImage("P3", "Junit 1", 255, aPixels);
        assertEquals(a.getPixel(0,0), RED);
        assertEquals(a.getPixel(1,0), BLUE);

        Pixel[][] bPixels = {{RED, GREEN},{BLUE, WHITE}};
        PNMImage b = new PNMImage("P3", "Junit 2", 255, bPixels);
        assertEquals(b.getPixel(0,1), GREEN);
        assertEquals(b.getPixel(1,1), WHITE);

    }

    @Test
    void stackImages() {
        Pixel alpha = new Pixel(161,183,74);
        try {
            PNMImage background = PNMImage.readPNM("D:\\GGC\\Advanced Programming\\PNMStarter\\images\\house32x32-ascii.pnm");
            PNMImage foreground = PNMImage.readPNM("D:\\GGC\\Advanced Programming\\PNMStarter\\images\\canoe32x32-ascii.pnm");
            PNMImage composited = background.stack(alpha, foreground);
            PNMImage.writePNM("D:\\GGC\\Advanced Programming\\PNMStarter\\images\\test-canoe-house32x32-ascii.pnm", composited);
            // TO DO - compare composited to a know good result
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void stackImagesBinary() {
        Pixel alpha = new Pixel(255,255,255);
        try {
            PNMImage background = PNMImage.readBinaryPNM("D:\\GGC\\Advanced Programming\\PNMStarter\\images\\sea-binary.pnm");
            PNMImage foreground = PNMImage.readBinaryPNM("D:\\GGC\\Advanced Programming\\PNMStarter\\images\\boat-binary.pnm");
            PNMImage composited = background.stack(alpha, foreground);
            PNMImage.writeBinaryPNM("D:\\GGC\\Advanced Programming\\PNMStarter\\images\\test-sea-boat-binary.pnm", composited);
            // TO DO - compare composited to a know good result
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}