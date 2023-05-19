package com.example.exam2;

public class AggregateSum {

    // TODO - make this class thread-safe

    private long sum;

    public synchronized long getSum() {
        return sum;
    }

    public synchronized void add(long sum) {
        this.sum = this.sum + sum;
    }
}
