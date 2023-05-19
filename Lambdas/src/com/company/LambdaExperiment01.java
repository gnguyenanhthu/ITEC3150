package com.company;

import java.util.Date;

public class LambdaExperiment01 {

    public static void main(String[] args) {

        long nowSystem = System.currentTimeMillis();
        System.out.println("now: " + nowSystem);

        long laterSystem = System.currentTimeMillis();
        System.out.println("later: " + laterSystem);

        long diff = laterSystem - nowSystem;
        System.out.println("difference: " + diff);

        Date nowDate = new Date();
        System.out.println("nowDate: " + nowDate);
        System.out.println("nowDate: " + nowDate.getTime());

        Date future = new Date(nowDate.getTime() + (10 * 1000));
        System.out.println("future: " + future);


        // two params, Date and int value, define my function
        // subtraction
        // addition

        // division, take the long value and divide
    }
}
