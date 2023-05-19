package com.example.exam2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StreetsWithNames {

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {

        List<String> streets = read("streetnames.txt");
        System.out.println("list has " + streets.size() + " street names");
        AggregateSum agg = new AggregateSum();

        // TODO start 5 threads, each updates agg with it's count when done
        Thread[] threads = new Thread[5];
        int numberOfThread = 5;
        int numNamesPerThread = streets.size() / numberOfThread;
        for (int i = 0; i < numberOfThread; i++) {
            threads[i] = new Thread(new Worker(streets, i * numNamesPerThread, (i + 1) * numNamesPerThread, agg));
            threads[i].start();
        }

        for (int i = 0; i < 5; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("a total of " + agg.getSum() + " occurrences of 'Gwinnett' were found");
    }

    private static List<String> read(String filename) throws FileNotFoundException {
        List list = new ArrayList<>();
        Scanner scan = new Scanner(new File(filename));
        while (scan.hasNext())
            list.add(scan.nextLine());
        scan.close();
        return list;
    }
}

class Worker implements Runnable
{
    private int start;
    private int end;
    private List<String> list;

    private AggregateSum aggSum;

    public Worker(List<String> list, int start, int end, AggregateSum aggSum)
    {
        super();
        this.start = start;
        this.list = list;
        this.end = end;
        this.aggSum = aggSum;
    }

    public void run()
    {
        String threadName = Thread.currentThread().getName();

        long localSumStreets = 0;
        for (int i = start; i <= end; i++) {
            if(list.get(i).toLowerCase().contains("gwinnett"))
                ++localSumStreets;
        }

        aggSum.add(localSumStreets);

        System.out.println(threadName + " finished.");
        System.out.println(threadName + " sum streets = " + localSumStreets);
    }
}
