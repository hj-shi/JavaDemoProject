package classloader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) {

        ClassLoader classLoader = Test.class.getClassLoader();
        while (classLoader != null) {
            System.out.println("shi- mClassLoader" + classLoader.toString());
            classLoader = classLoader.getParent();
        }

        // 注释1
        CustomClassLoader customClassLoader = new CustomClassLoader("/Users/shi/Desktop");

        try {
            // 注释2
            Class<?> aClass = customClassLoader.findClass("cn.edu.whu.lib.Hello");

            if (aClass != null) {
                try {
                    Object o = aClass.newInstance();
                    System.out.println("classLoader: " + o.getClass().getClassLoader());

                    Method say = aClass.getDeclaredMethod("say", null);
                    // 注释3
                    say.invoke(o, null);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
