package singletonExtends;

public class ExtendsTest {
    public static void main(String[] args) {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                President a1President = AmericanPresident.getInstance();
                System.out.println("a1President hash: " + a1President.hashCode());
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                President a2President = AmericanPresident.getInstance();
                System.out.println("a2Presinent hash: " + a2President.hashCode());
            }
        });
        thread1.start();
        thread2.start();

//        President a1President = AmericanPresident.getInstance();
//        President a2President = AmericanPresident.getInstance();

        President f1President = FrancePresident.getInstance();
        President f2President = FrancePresident.getInstance();

//        System.out.println("a1President hash: " + a1President.hashCode());
//        System.out.println("a2Presinent hash: " + a2President.hashCode());


        System.out.println("f1President hash: " + f1President.hashCode());
        System.out.println("f2Presinent hash: " + f2President.hashCode());
    }
}
