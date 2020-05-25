package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestOnly {
    public static void main(String[] args) throws Exception {
        // 正常实例化
        RefectionDemo refectionDemo = new RefectionDemo();
        refectionDemo.setCount(1);
        System.out.println(refectionDemo.getCount());

        // 反射
        Class clazz = Class.forName("reflection.RefectionDemo");
        Object object = clazz.newInstance();
        Method setCountMethod = clazz.getMethod("setCount", int.class);
        setCountMethod.invoke(object, 2);
        Method getCountMethod = clazz.getMethod("getCount");
        System.out.println(getCountMethod.invoke(object));

        // 获取 class
        clazz = Class.forName("reflection.RefectionDemo");
        clazz = RefectionDemo.class;
        clazz = new RefectionDemo().getClass();

        // 实例化
        object = clazz.newInstance();
        Constructor constructor = clazz.getConstructor(int.class);
        object = constructor.newInstance(3);

        // 构造器
        constructor = clazz.getConstructor(int.class);
        Constructor[] constructors = clazz.getConstructors();

        // 获取所有公共、默认和私有变量，但是不包括继承而来的变量
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("getDeclaredFields: " + field.getName());
        }

        // 获取所有的公共变量和继承而来的公共变量
        fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println("getFields: " + field.getName());
        }

        Field field = clazz.getField("pubVar");
        field.setInt(object, 4);
        System.out.println(field.get(object));

        field = clazz.getDeclaredField("count");
        field.setAccessible(true);
        field.setInt(object, 5);
        System.out.println(field.get(object));

        // 方法，获取所有公共、默认和私有方法，但是不包括集成而来的方法
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("getDeclaredMethods: " + method.getName());
        }

        methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println("getMethods: " + method.getName());
        }

        setCountMethod = clazz.getMethod("setCount", int.class);
        Method privateMethod = clazz.getDeclaredMethod("privateMethod");
        privateMethod.setAccessible(true);
        privateMethod.invoke(object);

    }
}
