package other;

public class SynchronizeDemo05 {
    public static void main(String[] args) {
        SyncThread02 syncTread1 = new SyncThread02();
        SyncThread02 syncThread2 = new SyncThread02();

        Thread thread1 = new Thread(syncTread1, "SyncThread1");
        Thread thread2 = new Thread(syncThread2, "SyncThread2");
        thread1.start();
        thread2.start();
    }

    public static class SyncThread02 implements Runnable {
        private static int count;

        public SyncThread02() {
            count = 0;
        }

        public static void method() {
            synchronized (SyncThread02.class) {
                for (int i = 0; i < 5; i++) {
                    try {
                        System.out.println(Thread.currentThread().getName() + ":" + (count++));
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        @Override
        public void run() {
            method();
        }
    }
}
