package typeinfo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class SimpleDynamicProxyHandler implements InvocationHandler {
    private Object proxied;
    private int calledCount;

    public SimpleDynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        calledCount++;
        System.out.println(proxy);
        System.out.println("**** proxy: " + proxy.getClass() + ", method: " + method + ", args: " + args);
        if (args != null) {
            for (Object arg: args) {
                System.out.println(" " + arg);
            }
        }
        return method.invoke(proxied, args);
    }

    public int getCalledCount() {
        return calledCount;
    }
}

class SimpleDynamicProxy {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bolalalala");
    }

    public static void main(String[] args) {
        RealObject real = new RealObject();
        consumer(real);

        // 动态代理要来了
        SimpleDynamicProxyHandler simpleDynamicProxyHandler = new SimpleDynamicProxyHandler(real);
        Interface proxy = (Interface) Proxy.newProxyInstance(
                Interface.class.getClassLoader(),
                new Class[] { Interface.class },
                simpleDynamicProxyHandler);
        consumer(proxy);
        System.out.println("method called: " + simpleDynamicProxyHandler.getCalledCount() + " times");
    }
}
