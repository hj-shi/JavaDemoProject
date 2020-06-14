package stringOperation;

import java.util.Iterator;
import java.util.LinkedList;

public class Resolution {
    public LinkedList<Character> out = new LinkedList<>();
    public void printAllCharComposition(String str) {
        if (str == null) {
            System.out.println("字符串为null");
            return;
        }
        if (str.length() == 1) {
            System.out.print(str);
            return;
        }

        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char first = chars[i];
            if (i > 0) {
                // 交换
                char tmp = chars[0];
                chars[0] = first;
                chars[i] = tmp;
            }

            String subStr = String.valueOf(chars, 1, chars.length - 1);
            System.out.print(first); // 没打对，一个字母在前面对应后面的是多种情况，这里后面的情况不会打印first了
            printAllCharComposition(subStr);
            System.out.println(); // 打印完一种情况换行
            // 每一次迭代可以分为str.length种情况，这里该怎么返回呀？for 循环里面return？？？
            // 不返回string，每次打一个呢？
//            return first + printAllCharComposition(subStr);
        }
    }

    // （全排列）递归需要的一个参数是原字符数组，这样才能在最后一次递归的时候打出来完整的序列
    public void permutation(char[] str, int i) {
        if (i >= str.length) {
            return;
        }
        if (i == str.length -1 ) {
            System.out.println(String.valueOf(str));
        } else {
            for (int j = i; j < str.length; j++) {
                char tmp = str[j];
                str[j] = str[i];
                str[i] = tmp;

                permutation(str, i + 1);

                // 换回来防止对下一个情况产生影响
                tmp = str[j];
                str[j] = str[i];
                str[i] = tmp;
            }
        }

    }

    // （组合）打印字符数组长度为m的字符组合
    public void composition(char[] str, int m, int start) {
        if (m == 0) {
            // 已选出所有的字符
            Iterator<Character> iterator = out.iterator();
            while (iterator.hasNext()) {
                System.out.print(iterator.next());
            }
            System.out.println();
            return;
        }
        if (str.length - start == m) {
            // 字符数组里面剩余的元素和要选择的数目相同，全部选中
            Iterator<Character> iterator = out.iterator();
            while (iterator.hasNext()) {
                System.out.print(iterator.next());
            }
            System.out.print(String.valueOf(str, start, m));
            System.out.println();
            return;
        }

            // 选中第i个，从剩余集合中选择 m-1个
            out.offer(str[start]);
            composition(str,m - 1, start + 1);
            out.pollLast();

            // 不选中第i个，从剩余集合中选择 m个
            composition(str, m, start + 1);
    }

//    // 打印字符数组长度为m的字符组合
//    public String composition2(char[] str, int m, int start) {
//        if (m == 0) {
//            // 已选出所有的字符
//            System.out.println();
//            return "";
//        }
//        if (str.length - start == m) {
//            return String.valueOf(str, start, m);
//        }
//
//        // 选中第i个，从剩余集合中选择 m-1个
//        return str[start] + composition2(str,m - 1, start + 1);
//
//        // 不选中第i个，从剩余集合中选择 m个
//        composition(str, m, start + 1);  // 如果每次迭代返回一个 String, 怎么表示没有选中str[start]的情况？？
//    }

//    public int stringNumCompare(String strNum1, String strNum2) {
//        char[] charArray1 = strNum1.toCharArray();
//        char[] charArray2 = strNum2.toCharArray();
//
//        if (charArray1.length > charArray2.length) {
//            return 1;
//        } else if (charArray1.length == charArray2.length) {
//            int result = 0;
//            for (int i = 0; i < charArray1.length; i++) {
//                if (charArray1[i] > charArray2[i]) {
//                    result = 1;
//                    break;
//                } else if (charArray1[i] < charArray2[i]) {
//                    result = -1;
//                    break;
//                }
//            }
//            return result;
//        } else {
//            return -1;
//        }
//    }

    // word convert
    public void sentenceConvert(String sentence) {
        char[] chars = sentence.toCharArray();
        char[] result = new char[chars.length];
        int resultIndex = 0;
        int start = 0;
        int end = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (i == chars.length - 1) {
                end = i;
            }
            if (chars[i] == ' ') {
                start = i + 1;
                for (int j = start; j <= end; j++) {
                    result[resultIndex++] = chars[j];
                }
                end = i - 1;
                result[resultIndex++] = ' ';
            }
            if (i == 0) {
                start = 0;
                for (int j = start; j <= end; j++) {
                    result[resultIndex++] = chars[j];
                }
                end = i;
            }
        }

        System.out.println(String.valueOf(result));
    }

    public String reverse(String str) {
        String reversedStr = new StringBuilder(str).reverse().toString();
        String[] strArray = reversedStr.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < strArray.length; i++) {
            builder.append(new StringBuilder(strArray[i]).reverse());
            if (i < str.length() - 1 ) {
                builder.append(" ");
            }
        }
        return builder.toString();


    }

    public String reverseCentence(String string) {
        char[] chars = string.toCharArray();
        reverseWords(chars, 0, chars.length - 1);
        int start = 0;
        int end = 0;
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == ' ') {
                end = i  - 1;
                reverseWords(chars, start, end);
                start = i + 1;
            }

            if (i == chars.length - 1) {
                end = i;
                reverseWords(chars, start, end);
            }
        }
        return String.valueOf(chars);
    }

    private void reverseWords(char[] chars, int start, int end) {
        while (start < end) { // 这里不声明新的变量了直接用函数参数
            sweap(chars, start, end);
            start++;
            end--;
        }
    }

    private void sweap(char[] chars, int a, int b) {
        char tmp = chars[a];
        chars[a] = chars[b];
        chars[b] = tmp;
    }

    public int str2int(String str) throws NumberFormatException {
        if (str == null || str.length() == 0) {
            throw new NumberFormatException();
        }

        boolean isFirstPositiveOrNegativeChar = false;

        char[] chars = str.toCharArray();
        // 先判断第一位是不是正负号，及有效数字
        if (!isCharIsNumber(chars[0])) {
            // 不是有效数字，在看是不是正负号
            if (chars.length > 1 && (chars[0] == '+' || chars[0] == '-')) {
                isFirstPositiveOrNegativeChar = true;
            } else {
                throw new NumberFormatException();
            }
        } else {
            isFirstPositiveOrNegativeChar = false;
        }

        int result = 0;
        int x = 0;
        // 从最后往前处理每一位

        int firstNumberPos = isFirstPositiveOrNegativeChar ? 1 : 0;
        for (int i = chars.length - 1; i >= firstNumberPos; i--) {

            if (isCharIsNumber(chars[i])) {
                result += Math.pow(10, x++) * (chars[i] - '0');
            } else {
                throw new NumberFormatException();
            }
        }

        if (isFirstPositiveOrNegativeChar && chars[0] == '-') {
            // 正数怎么转换为负数？？直接加个负号？
            result = (-result);
        }
        return result;
    }

    private boolean isCharIsNumber(char a) {
        if (a >= '0' && a <= '9') {
            return true;
        }
        return false;
    }

}
