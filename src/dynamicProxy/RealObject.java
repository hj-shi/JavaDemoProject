package dynamicProxy;

public class RealObject implements MyInterface {
    @Override
    public void doSomething() {
        System.out.println("doSomething");
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("SomethingElse: " + arg);
    }
}
