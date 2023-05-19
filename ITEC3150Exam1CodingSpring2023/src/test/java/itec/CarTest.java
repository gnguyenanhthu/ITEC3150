package itec;

import edu.ggc.itec.Car;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CarTest {

    @Test
    public void sortedTest() {

        //unsorted
        Car c1 = new Car("Ford", "Mustang", 1964, 2445,"Lb");
        Car c2 = new Car("Ford", "T", 1919, 1200,"Lb");
        Car c3 =new Car("Ford", "A", 1927, 2265,"Lb");
        List<Car> cars = Arrays.asList(c1, c2, c3);

        Collections.sort(cars); // cars List is sorted, in place

        // expected sorted
        List<Car> expected = cars = Arrays.asList(c2, c3, c1);

        assertTrue(expected.equals(cars));

    }

    @Test public void unsortedTest() {

        //unsorted
        Car c1 = new Car("Ford", "Mustang", 1964, 2445,"Lb");
        Car c2 = new Car("Ford", "T", 1919, 1200,"Lb");
        Car c3 =new Car("Ford", "A", 1927, 2265,"Lb");
        List<Car> cars = Arrays.asList(c1, c2, c3);

        Collections.sort(cars); // cars List is sorted, in place

        // expected sorted
        List<Car> expected = Arrays.asList(c1, c2, c3);

        assertFalse(expected.equals(cars)); // cars should not equal expected!

    }

}