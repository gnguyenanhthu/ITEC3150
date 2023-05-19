package itec;

import edu.ggc.itec.TimeCapsule;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TimeCapsuleTest {
    
    @Test
    public void test() throws IOException, ClassNotFoundException {
        File scratch = new File ("timecapsuletest.bin");
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(scratch));

        TimeCapsule capsule = new TimeCapsule("J2SE 1.3 was a bomb!", 2000);
        output.writeObject(capsule);
        output.close();

        ObjectInputStream input = new ObjectInputStream(new FileInputStream(scratch));

        TimeCapsule result = null; 
        while (true) {
            try {
                result = (TimeCapsule) input.readObject();
            } catch (EOFException eofe) {
                break;
            }
        }
        
        assertEquals(capsule, result);

        input.close();
        scratch.delete(); // cleanup

    }

}