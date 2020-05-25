package typeinfo;

interface Interface {
    void doSomething();
    void somethingElse(String arg);
}

class RealObject implements Interface {

    @Override
    public void doSomething() {
        System.out.println("doSomething");
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("somethingElse " + arg);
    }
}

class SimpleProxy implements Interface {
    private Interface proxied;
    private int callCount;

    public SimpleProxy(Interface proxied) {
        this.proxied = proxied;
    }

    @Override
    public void doSomething() {
        callCount++;
        System.out.println("SimpleProxy doSomething");
        proxied.doSomething();
    }

    @Override
    public void somethingElse(String arg) {
        callCount++;
        System.out.println("SimpleProxy somethingElse " + arg);
        proxied.somethingElse(arg);
    }

    public int getCallCount() {
        return callCount;
    }
}

public class SimpleProxyDemo {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("banana");
    }
    public static void main(String[] args) {
        consumer(new RealObject());
        Interface simpleProxy = new SimpleProxy(new RealObject());
        consumer(simpleProxy);
        int count = ((SimpleProxy) simpleProxy).getCallCount();
        System.out.println("method called: " + count + " times");
    }
}
