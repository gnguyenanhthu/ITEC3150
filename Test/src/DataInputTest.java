import java.io.*;


public class DataInputTest {
    public static void main(String[] args)  {
        try {
            DataInputStream input = new DataInputStream(new FileInputStream("D:\\GGC\\Advanced Programming\\PNMStarter\\images\\simple-binary.pnm"));

            System.out.println(input.readUTF() + input.readUTF());
            System.out.println(input.readLine());
            //System.out.println(input.readLine());
            String[] sizes = input.readLine().split(" ");

            int width = Integer.parseInt(sizes[0]);
            int height = Integer.parseInt(sizes[1]);
            System.out.println(width);
            System.out.println(height);

            int depth = Integer.parseInt(input.readLine());
            System.out.println(depth);
            byte[] bytes = new byte[8];

            //byte[] bytes = new byte[width*height*3];
            //input.read(bytes, 0, width*height*3);

            /*for (byte b : bytes) {
                String str  = Integer.toHexString(b & 0xff);
                int r = Integer.parseInt(str,16);
                System.out.println(str);
                System.out.println(r);
            }*/

            /*for (int i = 0; i < bytes.length - 3; i+=3){
                int r = Integer.parseInt(Integer.toHexString(bytes[i] & 0xff),16);
                int b = Integer.parseInt(Integer.toHexString(bytes[i+1] & 0xff),16);
                int g = Integer.parseInt(Integer.toHexString(bytes[i+2] & 0xff),16);
                System.out.println(r + " " + g + " " + b);
            }*/
            /*for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    /*int r = input.readByte();
                    int g = input.readByte();
                    int b = input.readByte();
                    System.out.println(r + " " + g + " " + b);
                    char r = input.readChar();
                    char g = input.readChar();
                    char b = input.readChar();
                    System.out.println(r + " " + g + " " + b);
                }
            }*/

        }
        catch (IOException e)
        {
            System.out.println("Problem readingfile- ending program");
            System.exit(0);
        }
    }
}
