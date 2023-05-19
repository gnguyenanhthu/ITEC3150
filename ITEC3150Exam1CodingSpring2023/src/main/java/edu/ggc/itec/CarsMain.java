package edu.ggc.itec;
import java.util.*;
import java.io.*;

public class CarsMain {

    public static void main(String[] args) {

        // TODO implement according to the specification
        LinkedList<Car> cars = new LinkedList<Car>();
        File carInfo = new File("carinfo.txt");
        Scanner scan;
        try {
            scan = new Scanner(carInfo);
            while (scan.hasNext()) {
                String values = scan.nextLine();
                String carInfoArray[] = values.split(",");
                String carMake = carInfoArray[0];
                String carModel = carInfoArray[1];
                int carYear = Integer.parseInt(carInfoArray[2]);
                double carWeight = Double.parseDouble(carInfoArray[3]);
                String carUnit = carInfoArray[4];
                cars.add(new Car(carMake,carModel,carYear,carWeight,carUnit));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error opening the accounts file");
            throw new RuntimeException(e);
        }
        scan.close();
        System.out.println("Unsorted List: ");
        for (Car a : cars){
            System.out.println(a);
        }

        Collections.sort(cars);

        System.out.println("\nSorted List: ");
        for (Car a : cars){
            System.out.println(a);
        }

    }
}
