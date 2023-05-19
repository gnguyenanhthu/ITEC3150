package com.company;

import java.util.Date;

public class LambdaExperiment {

    public static void main(String[] args) {

        // define an interface that let me add multiple functions with the same name

//        DateMath subtracter = new DateMath() {
//            @Override
//            public Date formula(Date d, int value) {
//                Date result = new Date(d.getTime() - value * 1000);
//                return result;
//            }
//        };

        DateMath subtracter = (d, value) -> new Date(d.getTime() - value * 1000);
        DateMath adder =(d, value) -> new Date(d.getTime() + value * 1000);
        DateMath divider = (d, value) -> new Date(d.getTime() / value);
        DateMath multiplier = (d, value) -> new Date(d.getTime() * value);

//
//        DateMath adder = new DateMath() {
//            @Override
//            public Date formula(Date d, int value) {
//                Date result = new Date(d.getTime() + value * 1000);
//                return result;
//            }
//        };

        Date now = new Date();
        Date past = subtracter.formula(now, 60);
        System.out.println("Past   : " + past);
        System.out.println("Now    : " + now);
        Date future = adder.formula(now, 60);
        System.out.println("Future : " + future);

        Date divided = divider.formula(now, 2);
        System.out.println("Divided : " + divided); // 1996?

        Date multiplied = multiplier.formula(now, 2);
        System.out.println("Multiplied : " + multiplied); // ?? 2074 



    }
}

@FunctionalInterface
interface DateMath { // single abstract method (SAM), or functional interface
    Date formula(Date d, int value);
}


