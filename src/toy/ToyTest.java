package toy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

interface HasBatteries {}
interface Waterproof {}
interface Shoots {}

class Toy {
    Toy() {
    }
    Toy(int i) {

    }

}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots {
    FancyToy() {
        super(1);
    }
}

public class ToyTest {
    static void printInfo(Class cc) {
        System.out.println("Class name: " + cc.getName() + " is interface? [" + cc.isInterface() + "]");
        System.out.println("Simple name: " + cc.getSimpleName());
        System.out.println("Canonical name : " + cc.getCanonicalName());
    }

    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName("toy.FancyToy");
        } catch (ClassNotFoundException e) {
            System.out.println("Can't find FancyToy");
            System.exit(0);
        }

        printInfo(c);
        for (Class face : c.getInterfaces()) {
            printInfo(face);
        }

        /*Class up = c.getSuperclass();
        Object obj = null;
        try {
            obj = up.newInstance();
        } catch (InstantiationException e) {
            System.out.println("Cannot instantiate");
            System.exit(1);
        } catch (IllegalAccessException e) {
            System.out.println("Cannot access");
            System.exit(1);
        }

        printInfo(obj.getClass());*/
        Class<?> up = c.getSuperclass();
        Object obj = null;
        Constructor ctor = null;
        try {
            ctor = up.getDeclaredConstructor(int.class);
            obj = ctor.newInstance(1);
            System.out.println("行不行？");
            printInfo(obj.getClass());
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }



        /*Constructor[] ctors = up.getConstructors();
        for (Constructor ctor : ctors) {
            System.out.println("ctor: " + ctor.toString());
        }*/




    }
}
