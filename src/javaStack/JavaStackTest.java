package javaStack;

public class JavaStackTest {
    private int count = 0;

    public void testStack(int a, int b) {
        count++;
        int  c = 5;
        long d = 5l;
        long f=47777777777777777L;
        testStack(a, b);
    }

    public void test() {
        try {
            testStack(1000, 5022);
        } catch (Throwable e) {
            System.out.println(e);
            System.out.println("stack height: " + count);
        }
    }

    public static void main(String[] args) {
        new JavaStackTest().test();
    }

}
