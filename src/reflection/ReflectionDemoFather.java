package reflection;

public class ReflectionDemoFather {
    public int fatherPublicVar;
    private int fatherPrivateVar;

    private void privateMethod() {
        System.out.println("privateMethod");
    }

    public void publicMethod() {
        System.out.println("publicMethod");
    }
}
