package lock;

import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Counter {
    private final ReadWriteLock rwLock = new ReentrantReadWriteLock();
    private final Lock rLock = rwLock.readLock();
    private final Lock wLock = rwLock.writeLock();
    private int[] counts = new int[10000];

    public void inc(int index) {
        wLock.lock(); // 加写锁
        try {
            for (int i = 0; i < 10000; i++) {
                counts[i] += 1;
            }
        } finally {
            wLock.unlock(); // 释放写锁
        }
    }

    public int[] get() {
        rLock.lock(); // 加读锁
        try {
            return Arrays.copyOf(counts, counts.length);
        } finally {
            rLock.unlock(); // 释放读锁
        }
    }
}
