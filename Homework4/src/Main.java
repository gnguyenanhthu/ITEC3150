import java.util.ArrayList;
public class Main {

    public static void main(String[] args) {
        InitializedArray list = new InitializedArray();
        SharedSum sharedSum = new SharedSum();
        Thread[] threads = new Thread[5];
        int threadNumber = 0;
        for (int i = 0; i < 10000000; i+=2000000) {
            threads[threadNumber] = new Thread(new Worker(list.getList(), i, i + 1999999, sharedSum));
            threads[threadNumber].start();
            ++threadNumber;
        }

        for (int i = 0; i < 5; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("All threads finished.");
        System.out.println("Final Sum = " + sharedSum.getSum());
    }
}

class SharedSum {
    private long sum;

    public SharedSum() {
        this.sum = 0;
    }

    public synchronized void addToSum(long num) {
            this.sum += num;
    }

    public synchronized long getSum() {
        return this.sum;
    }
}

class Worker implements Runnable
{
    private int start;
    private int end;
    private ArrayList<Integer> list;

    private SharedSum sharedSum;

    public Worker(ArrayList<Integer> list, int start, int end, SharedSum sharedSum)
    {
        super();
        this.start = start;
        this.list = list;
        this.end = end;
        this.sharedSum = sharedSum;
    }

    public void run()
    {
        String threadName = Thread.currentThread().getName();

        long localSum = 0;
        for (int i = start; i <= end; i++) {
            localSum += list.get(i);
        }

        sharedSum.addToSum(localSum);

        System.out.println(threadName + " finished.");
        System.out.println(threadName + " sum = " + localSum);
    }
}