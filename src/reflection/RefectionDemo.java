package reflection;

public class RefectionDemo extends ReflectionDemoFather {
    public int pubVar;
    private int count;

    public RefectionDemo() {}

    public RefectionDemo(int count) {
        this.count = count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    private void privateMethod() {
        System.out.println("privateMethod");
    }
}
