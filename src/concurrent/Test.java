package concurrent;

public class Test {
    public static void main(String[] args) {
        SynchronizedDemo demo1 = new SynchronizedDemo();
        demo1.method1();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//               SynchronizedDemo demo1 = new SynchronizedDemo();
//               demo1.method1();
//            }
//        }).start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//               SynchronizedDemo demo2 = new SynchronizedDemo();
//               demo2.method1();
//            }
//        }).start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                SynchronizedDemo demo3 = new SynchronizedDemo();
//                demo3.method1();
//            }
//        }).start();
    }
}
