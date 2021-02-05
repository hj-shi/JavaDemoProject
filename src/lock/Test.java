package lock;

import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    private final Lock lock = new ReentrantLock();
    private final Lock lock2 = new ReentrantLock();
    private int[] counts = new int[10];
    private int count;

    public void add(int n) {
        lock2.lock();
        try {
            for (int i = 0; i < 100000; i++) {
                count += n;
            }
        } finally {
            lock2.unlock();
        }
//        synchronized (this) {
//            for (int i = 0; i < 100000; i++) {
//                count += n;
//            }
//        }
    }

    public int getCount() {
        lock2.lock();
        try {
            return count;
        } finally {
            lock2.unlock();
        }
//        synchronized (this) {
//            return count;
//        }
    }

    public void inc(int index) {
        lock.lock();
        try {
            counts[index] += 1;
        } finally {
            lock.unlock();
        }
    }

    public int[] get() {
        lock.lock();
        try {
            return Arrays.copyOf(counts, counts.length);
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Test test = new Test();
//        for (int i = 0; i < 5; i++) {
//            int finalI = i;
//            Thread thread = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    test.inc(finalI);
//                }
//            });
//            thread.start();
//        }
//        for(int j = 0; j < test.counts.length; j++) {
//            System.out.println(test.counts[j]);
//        }
//        for (int i = 0; i < 5; i++) {
//            Thread thread = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    test.add(1);
//                }
//            });
//            thread.start();
//        }

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                test.add(1);
            }
        });
        thread.start();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(test.getCount());
            }
        });
        thread1.start();

    }
}
