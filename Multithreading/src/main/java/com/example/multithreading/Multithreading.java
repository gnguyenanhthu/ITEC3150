package com.example.multithreading;

//With the help of ChatGPT
public class Multithreading {

    public static void main(String[] args) {
        Thread t1 = new Thread(new PrintNumbers(100, 200, 200));
        Thread t2 = new Thread(new PrintNumbersReverse(300, 200, 100));

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All threads finished.");
    }

}

class PrintNumbers implements Runnable {

    private int start;
    private int end;
    private int delay;

    public PrintNumbers(int start, int end, int delay) {
        this.start = start;
        this.end = end;
        this.delay = delay;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();

        for (int i = start; i <= end; i++) {
            System.out.println(threadName + ": " + i);
            System.out.flush(); // flush output buffer after each print

            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(threadName + " finished.");
    }
}

class PrintNumbersReverse implements Runnable {

    private int start;
    private int end;
    private int delay;

    public PrintNumbersReverse(int start, int end, int delay) {
        this.start = start;
        this.end = end;
        this.delay = delay;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();

        for (int i = start; i >= end; i--) {
            System.out.println(threadName + ": " + i);
            System.out.flush(); // flush output buffer after each print

            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(threadName + " finished.");
    }
}
