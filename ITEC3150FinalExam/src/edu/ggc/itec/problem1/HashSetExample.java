package edu.ggc.itec.problem1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HashSetExample {

    public static void main(String[] args) {

        List sdList = List.of("ITEC 2201", "ITEC 2140", "ITEC 2150", 
                "ITEC 3150", "ITEC 3860", "ITEC 3870", "ITEC 4260",
                "ITEC 4860");
        List ssList = List.of("ITEC 2201", "ITEC 2140", "ITEC 2150", 
                "ITEC 3150", "ITEC 3600", "ITEC 4330", "ITEC 4810");
        Set<String> softdev = new HashSet<String>(sdList);
        Set<String> syssec = new HashSet<String>(ssList);

        // TODO report common courses
        Set<String> common = new HashSet<>();
        for (String i : softdev){
            if (syssec.contains(i)){
                common.add(i);
            }
        }
        System.out.println("Common Course");
        System.out.println(common);

        // TODO report courses exclusive to SD
        Set<String> sdExclusive = new HashSet<>();
        for (String i : softdev){
            if (!common.contains(i)){
                sdExclusive.add(i);
            }
        }
        System.out.println("\nCourses Exclusive to Software Development");
        System.out.println(sdExclusive);

    }

}
