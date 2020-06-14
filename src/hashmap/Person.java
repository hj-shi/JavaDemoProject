package hashmap;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * 重写的equals方法会经过三个步骤的比较，1. 比较内存地址 2. 判断两个对象的类型是否一致 3. 判断对象的属性是否相等
     * @param obj
     * @return
     */
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (!(obj instanceof Person)) {
//            return false;
//        }
//
//        Person other = (Person) obj;
//        if (this.age != other.age) {
//            return false;
//        }
//
//        return this.name.equals(other.name);
//    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age;
        return result;
    }
}
