package dynamicProxy;

import java.lang.reflect.Proxy;

public class Test {

    public static void main(String[] args) {
        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");
        RealObject real = new RealObject();
        real.doSomething();
        real.somethingElse("hahahah");

        // 创建一个动态代理类
        MyInterface proxy = (MyInterface) Proxy.newProxyInstance(
                MyInterface.class.getClassLoader(),
                new Class[] { MyInterface.class },
                new DynamicProxyHandler(real));

        proxy.doSomething();
        proxy.somethingElse("shi");
    }
}
