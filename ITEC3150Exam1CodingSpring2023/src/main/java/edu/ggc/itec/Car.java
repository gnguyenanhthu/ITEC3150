package edu.ggc.itec;

public class Car implements Comparable<Car> {

    private String make;
    private String model;
    int firstProductionYear;
    private double weight;
    private String weightUnits;

    public Car(String make, String model, int firstProductionYear,
               double weight, String weightUnits) {
        super();
        this.make = make;
        this.model = model;
        this.firstProductionYear = firstProductionYear;
        this.weight = weight;
        this.weightUnits = weightUnits;
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", firstProductionYear=" + firstProductionYear +
                ", weight=" + weight +
                ", weightUnits='" + weightUnits + '\'' +
                '}';
    }


    /**
     *
     * use standard compareTo logic. for our Car class, first year of
     * production will be used to establish 'natural' ordering
     *
     * @param other the object to be compared.
     * @return year difference, negative if this < other and positive if
     *         this is greater than the other
     */
    @Override
    public int compareTo(Car other) {
        if (firstProductionYear < other.firstProductionYear)
            return firstProductionYear - other.firstProductionYear;
        else if (firstProductionYear > other.firstProductionYear)
            return firstProductionYear + other.firstProductionYear;
        else
            return 0;
    }
}
