package lock;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class WaitTest {
    public static void main(String[] args) throws InterruptedException {
        TaskQueueWithWait taskQueue = new TaskQueueWithWait();
        ArrayList<Thread> arrayList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            String s = taskQueue.getTask();
                            System.out.println("execute task: " + s);
                        } catch (InterruptedException e) {
                            return;
                        }
                    }
                }
            });
            t.start();
            arrayList.add(t);
        }

        Thread add = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    // 放入 task
                    String s = "t-" + Math.random();
                    System.out.println("add task: " + s);
                    taskQueue.addTask(s);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        add.start();
        add.join();
        Thread.sleep(100);
        for (Thread t : arrayList) {
            t.interrupt();
        }
    }
}


