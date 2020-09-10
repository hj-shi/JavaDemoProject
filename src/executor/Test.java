package executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {
    private static ExecutorService executorService = Executors.newFixedThreadPool(20);
    private static volatile AtomicInteger atomicInteger = new AtomicInteger(0);
    private static volatile AtomicInteger atomicInteger2 = new AtomicInteger(0);

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        threadTest01();
    }


    public static void threadTest01() {
//        threadTest02();
        threadTest03();
    }

    public static void threadTest02() {
       long startTime = System.currentTimeMillis();
       for (int i = 0; i < 2000; i++) {
           executorService.execute(new Runnable() {
               @Override
               public void run() {
                   atomicInteger.incrementAndGet();
               }
           });
       }

       executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(System.currentTimeMillis() - startTime);
        System.out.println(atomicInteger);

    }

    public static void threadTest03() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 2000; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    atomicInteger2.incrementAndGet();
                }
            });
            thread.start();

            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(System.currentTimeMillis() - startTime);
        System.out.println(atomicInteger2);

    }

}

