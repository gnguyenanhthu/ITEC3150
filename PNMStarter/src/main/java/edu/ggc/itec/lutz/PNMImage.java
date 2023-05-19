package edu.ggc.itec.lutz;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class PNMImage {

    private String format;
    private String comment;
    private int depth;
    private Type type;


    public static enum Type {ASCII, BINARY}

    ;
    private static char LINE_FEED = '\n'; // could also use (char)0XA or (char)10


    private Pixel[][] pixels;

    public PNMImage(String format, String comment, int depth, Pixel[][] pixels) {
        this.format = format;
        this.comment = comment;
        this.depth = depth;
        this.pixels = pixels;
        if (format.equals("P1") || format.equals("P2") || format.equals("P3")) {
            this.type = Type.ASCII;
        } else if (format.equals("P4") || format.equals("P5") || format.equals("P6")) {
            this.type = Type.BINARY;
        } else {
            throw new IllegalArgumentException("Invalid type");
        }
    }

    public static PNMImage readPNM(String fileName) throws FileNotFoundException {
        File input = new File(fileName);
        Scanner scanner = new Scanner(input);

        String format = scanner.nextLine();
        String comment = scanner.nextLine();
        String[] sizes = scanner.nextLine().split(" ");

        //width -> height -> depth
        int width = Integer.parseInt(sizes[0]);
        int height = Integer.parseInt(sizes[1]);
        int depth = Integer.parseInt(scanner.nextLine());

        Pixel[][] pixels = new Pixel[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int r = scanner.nextInt();
                int g = scanner.nextInt();
                int b = scanner.nextInt();
                Pixel pixel = new Pixel(r, g, b);
                pixels[i][j] = pixel;
            }
        }
        scanner.close();
        return new PNMImage(format, comment, depth, pixels);
    }

    public static PNMImage readBinaryPNM(String fileName) throws IOException {
        DataInputStream input = new DataInputStream(new FileInputStream(fileName));

        String format = input.readLine();
        String comment = input.readLine();
        String[] sizes = input.readLine().split(" ");

        int width = Integer.parseInt(sizes[0]);
        int height = Integer.parseInt(sizes[1]);
        String depthString = input.readLine();
        int depth = Integer.parseInt(depthString);

        byte[] bytes = new byte[width * height * 3 + 1];
        input.read(bytes, 0, width * height * 3);
        int index = 0;
        Pixel[][] pixels = new Pixel[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int r = Integer.parseInt(Integer.toHexString(bytes[index++] & 0xff), 16);
                int g = Integer.parseInt(Integer.toHexString(bytes[index++] & 0xff), 16);
                int b = Integer.parseInt(Integer.toHexString(bytes[index++] & 0xff), 16);
                Pixel pixel = new Pixel(r, g, b);
                pixels[i][j] = pixel;
            }
        }
        input.close();
        return new PNMImage(format, comment, depth, pixels);
    }


    public static void writePNM(String outputFile, PNMImage image) throws FileNotFoundException {
        File output = new File(outputFile);
        PrintWriter writer = new PrintWriter(outputFile);
        writer.println(image.format);
        writer.println("# " + image.comment);
        writer.printf("%d %d%n", image.getWidth(), image.getHeight());
        writer.println(image.depth);
        for (Pixel[] row : image.getPixels()) {
            boolean first = true;
            for (Pixel pix : row) {
                if (!first) writer.print(" ");
                first = false;
                writer.printf("%3d %3d %3d", pix.getRed(), pix.getGreen(), pix.getBlue());
            }
            writer.printf("%n");
        }
        writer.close();
    }

    public static void writeBinaryPNM(String canonicalPath, PNMImage image) throws IOException {
        OutputStream output = new FileOutputStream(canonicalPath);
        output.write(image.format.getBytes());
        output.write("\n".getBytes());
        output.write(image.comment.getBytes());
        output.write("\n".getBytes());
        output.write((String.valueOf(image.getWidth()) + " " + String.valueOf(image.getHeight()) + "\n").getBytes());
        output.write((String.valueOf(image.depth) + "\n").getBytes());
        for (Pixel[] row : image.getPixels()) {
            for (Pixel pix : row) {
                output.write(pix.getRed());
                output.write(pix.getGreen());
                output.write(pix.getBlue());
            }
        }
        output.flush();
        output.close();
    }

    public PNMImage stack(Pixel alphaColor, PNMImage foreground) {
        Pixel[][] result = new Pixel[getHeight()][getWidth()];
        for (int row = 0; row < getHeight(); row++)
            for (int column = 0; column < getWidth(); column++) {
                boolean masked = foreground.getPixel(row, column).equals(alphaColor);
                result[row][column] = !masked ? foreground.getPixel(row, column)
                        : getPixel(row, column);
            }
        return new PNMImage(format, comment, depth, result);
    }

    private static void writeStringtoBinaryFile(DataOutputStream dos, String string)
            throws IOException {
        for (int i = 0; i < string.length(); i++)
            dos.writeByte(string.charAt(i));
        dos.writeByte('\n');
    }

    private int getHeight() {
        return pixels.length;
    }

    private int getWidth() {
        return pixels[0].length;
    }

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();
        for (Pixel[] row : pixels) {
            boolean first = true;
            for (Pixel pix : row) {
                if (!first)
                    result.append(", ");
                else
                    first = false;
                result.append(pix.toString());
            }
            result.append("\n");
        }
        return result.toString();
    }

    @Override
    public boolean equals(Object object) {
        PNMImage other = (PNMImage) object;
        return Arrays.deepEquals(pixels, other.getPixels()) &&
                format.equals(other.format) &&
                depth == other.depth;
    }

    public Pixel getPixel(int row, int col) {
        return pixels[row][col];
    }

    public int getDepth() {
        return depth;
    }

    public String getFormat() {
        return format;
    }

    public Type getType() {
        return type;
    }

    public Pixel[][] getPixels() {
        return pixels;
    }
}
