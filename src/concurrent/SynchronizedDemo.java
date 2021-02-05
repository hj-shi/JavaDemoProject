package concurrent;

public class SynchronizedDemo {
    private static int result;

    public synchronized void method1() {
            // do something
            for (int i = 0; i < 10000; i++) {
                result++;
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(result);
    }

    public static synchronized void method() {
        System.out.println("调用了");
    }
}
