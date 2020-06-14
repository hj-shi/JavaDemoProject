package stringOperation;

public class Test {
    public static void main(String[] args) {
        Resolution resolution = new Resolution();
//        resolution.printAllCharComposition("abc");
//        String testStr = "abcd";
//        resolution.permutation(testStr.toCharArray(), 0);
//        resolution.composition(testStr.toCharArray(), 3, 0);

//        String str1 = "123456666666677777777778888888888889999999999999999999999998";
//        String str2 = "123456666666677777777778888888888889999999999999999999999997";
//        int result = resolution.stringNumCompare(str1, str2);
//        if (result == 1) {
//            System.out.println(str1 + " > " + str2);
//        } else if (result == 0) {
//            System.out.println(str1 + " = " + str2);
//        } else {
//            System.out.println(str1 + " < " + str2);
//        }
//        resolution.sentenceConvert("i am student.");
//        String reverse = resolution.reverse("i am student.");
//        String reverse = resolution.reverseCentence("i am students.");
//        System.out.println(reverse);
//
//        System.out.println(Math.pow(2, 3));
//        int a = Integer.valueOf("sjks"); // 异常
//        int b = Integer.valueOf("-10"); // -10
//        int c = Integer.valueOf("+10"); // 10
//        int d = Integer.valueOf(" 10"); // 异常
//        int e = Integer.valueOf(null); // 异常
//        int[] arr = new int[] {0};
//        int f = Integer.valueOf(arr); // 编译不过，不是String可以不考虑
//        int g = Integer.valueOf("012");
//        System.out.println(g);

        // 测试
//        System.out.println(resolution.str2int(null)); // 异常， ok
//        System.out.println(resolution.str2int("")); // 异常，OK
//        System.out.println(resolution.str2int("+")); // 异常, ok
//        System.out.println(resolution.str2int("-")); // 异常, ok
//        System.out.println(resolution.str2int("222")); // 正数， ok
//        System.out.println(resolution.str2int("-180")); // 负数，OK
//        System.out.println(resolution.str2int("+235")); // 正数，OK
//        System.out.println(resolution.str2int("012")); // 以0开头的数, ok
//        System.out.println(resolution.str2int("000")); // 全是0，ok
        System.out.println(resolution.str2int("-000")); // -0，OK

    }
}
