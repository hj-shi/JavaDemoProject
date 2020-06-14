package number;

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

        int[] array = new int[] {2, -4, 3, 6, 3, 2, -5, -5};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        resolution.findNumbersAppearOnes(array, num1, num2);
        System.out.println("2个只出现一次的数字是：" + num1[0] + " 和 " + num2[0]);

    }
}
