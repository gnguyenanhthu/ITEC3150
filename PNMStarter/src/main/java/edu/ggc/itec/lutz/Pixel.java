package edu.ggc.itec.lutz;

public class Pixel {
    private int red,green,blue;

    @Override
    public boolean equals(Object other) {
        Pixel o = (Pixel)other;
        return red == o.getRed() && green == o.getGreen() && blue == o.getBlue();
    }

    @Override
    public String toString() {
        return "[" + "r" + red + "/g" + green + "/b" + blue + ']';
    }

    public Pixel(int r, int g, int b) {
        this.red = r;
        this.green = g;
        this.blue = b;
    }

    public int getRed() {
        return red;
    }
    public int getGreen() {
        return green;
    }
    public int getBlue() {
        return blue;
    }

}
