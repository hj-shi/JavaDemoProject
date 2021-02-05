package generic;

import org.omg.PortableInterceptor.INACTIVE;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.*;

public class Test {
    private static Map<String, Integer> map2 = new HashMap<>();
    public static void main(String[] args) {
//        double result = powerWithUnsignedExponent(2, 5);
//        System.out.println(result);

//        int a = 2147483647;
//        System.out.println(a);
//        int b = a + 1;
//        System.out.println(b);

//        BigDecimal bigDecimal = new BigDecimal(a);
//        BigDecimal resulta = null;
//        resulta = bigDecimal.add(new BigDecimal(2)).negate();
//        System.out.println(resulta.toString());

        List<String> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        System.out.println("list1.getClass() == " + list1.getClass());
        System.out.println("list2.getClass() == " + list2.getClass());
        list2.add(1);
        try {
            list2.getClass().getMethod("add", Object.class).invoke(list2, "shi");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
//
//        System.out.println(list1.getClass() == list2.getClass());
        for (int i = 0; i < list2.size(); i++) {
            System.out.println(list2.get(i));
        }

        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add("shi");

        ArrayList arrayList2 = new ArrayList<String>();
        arrayList2.add("1"); // 编译通过
        arrayList2.add(1);

        System.out.println("---------------------------0");
        try {
            Field list = TypeTest.class.getField("list");
            Type genericType = list.getGenericType();
            System.out.println("参数类型： " +  genericType.getTypeName());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        Type superType = (AppleContainer.class.getGenericSuperclass());
        System.out.println(superType);

        if (superType instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType)superType;
            System.out.println(Arrays.toString(parameterizedType.getActualTypeArguments()));
        }


        System.out.println("---------------------------");
        System.out.println(new FruitsContainer<Apple>().getClass().getGenericSuperclass());
        System.out.println(new FruitsContainer<Apple>(){}.getClass().getGenericSuperclass());
        System.out.println("---------------------------1");
        List<Integer> list = new ArrayList<>();
        Map<Integer, String> map = new HashMap<>();
        System.out.println(Arrays.toString(list.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(map.getClass().getTypeParameters()));

        System.out.println("---------------------------2");
        Map<String, Integer> map1 = new HashMap<String, Integer>(){};

        Type type = map1.getClass().getGenericSuperclass();
        ParameterizedType parameterizedType = ParameterizedType.class.cast(type);
        for (Type typeArgument: parameterizedType.getActualTypeArguments()) {
            System.out.println(typeArgument.getTypeName());
        }

        System.out.println("---------------------------3");
        List<? super Fruit> fruits = new ArrayList<>();
//        fruits.add(new Food());
//        fruits.add(new Fruit());
//        fruits.add(new Apple());
//
//        fruits = new ArrayList<Fruit>();
//        fruits = new ArrayList<Apple>();
//        fruits = new ArrayList<Food>();

        System.out.println("---------------------------4");

//        Type type2 = map2.getClass().getGenericSuperclass();
//        ParameterizedType parameterizedType2 = ParameterizedType.class.cast(type2);
//        for (Type typeArgument: parameterizedType2.getActualTypeArguments()) {
//            System.out.println(typeArgument.getTypeName());
//        }

        try {
            Field map2 = Test.class.getField("map2");
            Type genericType = map2.getGenericType();
            System.out.println("参数类型： " +  genericType.getTypeName());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }

    public static double powerWithUnsignedExponent(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        double result = powerWithUnsignedExponent(base, exponent >> 1);
        result *= result;
        if ((exponent & 0x1) == 1) {
            result *= base;
        }
        return result;
    }

    public static <T> void printMsg( T... args){
        for(T t : args){
            System.out.println("泛型测试: " + "t is " + t);
        }
    }

    public static void showKeyValue(Generic<Number> obj){
        System.out.println("泛型测试: " + "key value is " + obj.getKey());
    }

    static int add(Pair<? extends Number> p) {
        Number first = p.getFirst();
        Number last = p.getLast();
        p.setFirst(null);
//        p.setLast(new Integer(last.intValue() + 100));
        return p.getFirst().intValue() + p.getFirst().intValue();
    }
}

class Pair<T> {
    private T first;
    private T last;

    public Pair(T first, T last) {
        this.first = first;
        this.last = last;
    }

    public T getFirst() {
        return first;
    }
    public T getLast() {
        return last;
    }
    public void setFirst(T first) {
        this.first = first;
    }
    public void setLast(T last) {
        this.last = last;
    }
}

class Generic<T>{
    //key这个成员变量的类型为T,T的类型由外部指定
    private T key;

    public Generic(T key) { //泛型构造方法形参key的类型也为T，T的类型由外部指定
        this.key = key;
    }

    public T getKey(){ //泛型方法getKey的返回值类型为T，T的类型由外部指定
        return key;
    }
}

class Food {

}

class Fruit extends Food{
    @Override
    public String toString() {
        return "fruit";
    }
}

class Apple extends Fruit{
    @Override
    public String toString() {
        return "apple";
    }
}

class Person{
    @Override
    public String toString() {
        return "Person";
    }
}

class GenerateTest<T>{
    public void show_1(T t){
        System.out.println(t.toString());
    }

    //在泛型类中声明了一个泛型方法，使用泛型E，这种泛型E可以为任意类型。可以类型与T相同，也可以不同。
    //由于泛型方法在声明的时候会声明泛型<E>，因此即使在泛型类中并未声明泛型，编译器也能够正确识别泛型方法中识别的泛型。
    public <E> void show_3(E t){
        System.out.println(t.toString());
    }

    //在泛型类中声明了一个泛型方法，使用泛型T，注意这个T是一种全新的类型，可以与泛型类中声明的T不是同一种类型。
    public <T> void show_2(T t){
        System.out.println(t.toString());
    }
}

class HasF {
    public void f() {
        System.out.println("HasF.f()");
    }
}

class Manipulator<T extends HasF> {
    private T obj;
    public Manipulator(T x) {
        obj = x;
    }
    public void manipulate() {
        obj.f();
    }
}

class TypeTest<T> {
    public List<T> list;
}

class FruitsContainer<T extends Fruit> {
    public T t;
}

class AppleContainer extends FruitsContainer<Apple> {
    public AppleContainer appleContainer;
}
