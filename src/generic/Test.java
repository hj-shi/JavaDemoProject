package generic;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        double result = powerWithUnsignedExponent(2, 5);
        System.out.println(result);

        int a = 2147483647;
        System.out.println(a);
        int b = a + 1;
        System.out.println(b);

        BigDecimal bigDecimal = new BigDecimal(a);
        BigDecimal resulta = null;
        resulta = bigDecimal.add(new BigDecimal(2)).negate();
        System.out.println(resulta.toString());
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

class Fruit{
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
