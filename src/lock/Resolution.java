package lock;

public class Resolution {

    public static void main(String[] args) {
//        TaskQueue taskQueue = new TaskQueue();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(taskQueue.getTask());
//            }
//        }).start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(5000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                taskQueue.addTask("task1");
//                taskQueue.addTask("task2");
//            }
//        }).start();

        Counter counter = new Counter();
        new Thread(new Runnable() {
            @Override
            public void run() {
                int[] result = counter.get();
                for (int i = 0; i < result.length; i++) {
                    System.out.println("线程1读取结果： " + result[i]);
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
//                for (int i = 0; i < 10000; i++) {
                System.out.println("开始写");
                    counter.inc(1);
//                }

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                int[] result = counter.get();
                for (int i = 0; i < result.length; i++) {
                    System.out.println("线程2读取结果： " + result[i]);
                }
            }
        }).start();
    }
}
