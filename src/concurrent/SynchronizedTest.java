package concurrent;

public class SynchronizedTest {
    public static void main(String[] args) {
        SynchronizedTest test = new SynchronizedTest();
        test.test1();
    }

    public synchronized void test1() {
    }

    public void test2() {
        synchronized (this) {

        }
    }
}
