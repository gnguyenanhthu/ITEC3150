import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class containing an array of 10,000,000 integers that is initialized For use
 * in Homework 3 Multithreading. This is part of the shared data.
 */
public class InitializedArray {

    private  static final String BIGDATA = "bigdata.txt";

    private ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<Integer> getList() { return list; }

    public InitializedArray() {
        try {
            Scanner scanner = new Scanner(new File(BIGDATA));
            while (scanner.hasNext())
                list.add(scanner.nextInt());
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
