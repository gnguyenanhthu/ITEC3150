package com.company;

import java.util.Date;

public class LambdaStuff {

    public static void main(String[] args) {

        long nowSystem = System.currentTimeMillis();

        System.out.println("current time is " + nowSystem);

        Date nowDate = new Date();
        System.out.println("current date is " + nowDate);
        System.out.println("current date is " + nowDate.getTime());

        long delta = nowDate.getTime() - nowSystem;
        System.out.println("the delta is " + delta + " msecs.");

    }
}
