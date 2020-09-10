package number;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    public static void main(String[] args) {
        Resolution resolution = new Resolution();
//        int result = resolution.numberOf1Between1AndN(101);
//        System.out.println(result);
//        System.out.println(result);
//        int[] array = new int[] {3, 32, 321};
//        int[] array = new int[] {333333333, 999999999, 444444442};
//        String result = resolution.minmumOfArray(array);
//        String result = resolution.PrintMinNumber(array);
//        System.out.println(result);

//        System.out.println('1' - '0');

//        int[] array = new int[] {2, -4, 3, 6, 3, 2, -5, -5};
//        int[] num1 = new int[1];
//        int[] num2 = new int[1];
//        resolution.findNumbersAppearOnes(array, num1, num2);
//        System.out.println("2个只出现一次的数字是：" + num1[0] + " 和 " + num2[0]);

//        Random random = new Random();
//        int result = random.nextInt(20);
//
//        for (int i = 0; i < 50; i++) {
//            System.out.print(resolution.randomInRange(5, 25) + " ");
//        }

//        int  result = resolution.reverse(2000000005);
//        System.out.println(result);

//        try {
//            double result = resolution.powerPro(2.0, 3);
//            System.out.println(result);
//
//            double result2 = resolution.powerPro(2.0, -3);
//            System.out.println(result2);
//
//            double result3 = resolution.powerPro(-2.0, -3);
//            System.out.println(result3);
//
//            double result4 = resolution.powerPro(0, 3);
//            System.out.println(result4);
//
//            double result5 = resolution.powerPro(-2, 6);
//            System.out.println(result5);
//
////            double result5 = resolution.powerPro(0, -3);
////            System.out.println(result5);
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println(e.getMessage());
//        }

        int[] numbers = new int[15];

        resolution.printOneToNRecurisively(numbers, 15);

    }
}
