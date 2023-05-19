package com.company;

import java.util.Date;

public class Main {

    public static void main(String[] args) {

        DateMath subtracter = new DateMath() { // create inner class, using DateMath interface
            @Override                          // subtracts offset number of seconds from Date d
            public Date formula(Date d, int offset) {
                long dPrime = d.getTime()  - 1000 * offset;
                return new Date(dPrime);
            }
        };

        int sixtySecs = 60;
        Date now = new Date();
        Date past = subtracter.formula(now, sixtySecs);

//        DateMath adder = new DateMath() {
//            @Override
//            public Date formula(Date d, int offset) {
//                long dPrime = d.getTime()  + 1000 * offset;
//                return new Date(dPrime);
//            }
//        };

//        DateMath adder = (date, offset) -> {
//            long dPrime = date.getTime()  + 1000 * offset;
//            return new Date(dPrime);
//        };

        DateMath adder = (date, offset) -> new Date(date.getTime() + 1000 * offset);

        Date future = adder.formula(now, sixtySecs);

        System.out.println("Past    : " + past);
        System.out.println("Current : " + now);
        System.out.println("Future  : " + future);

    }
}

//interface DateMath { // single abstract method, or functional interface
//    Date formula(Date d, int value);
//}
