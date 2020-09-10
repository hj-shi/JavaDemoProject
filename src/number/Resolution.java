package number;


import java.util.ArrayList;
import java.util.Random;

public class Resolution {
    public int numberOf1Between1AndN(int number) {
        if (number <= 0) {
            return 0;
        }
        String strNumber = String.valueOf(number);
        System.out.println("number: " + strNumber);
        return numberOf1(strNumber.toCharArray(), 0);
    }

    public int numberOf1(char[] strN, int start){
        if (strN == null || strN[start] < '0' || strN[start] > '9' || strN[start] == '\0') {
            return 0;
        }

        int first = strN[start] - '0';
        int length = strN.length - start;

        if (length == 1 && first == 0) {
            return 0;
        }

        if (length == 1 && first > 0) {
            return 1;
        }

        // 最高位是为1
        int numFirstDigit = 0;
        if (first > 1) {
            numFirstDigit = powerBase10(length - 1);
        } else if (first == 1) {
            numFirstDigit = Integer.valueOf(String.valueOf(strN, start + 1, length - start - 1 )) + 1;
        }

        // 除最高位外其他为1的数目
        int numOtherDigits = first * (length -1) * powerBase10(length - 2);

        int numRecursively = numberOf1(strN, start + 1);

        return numFirstDigit + numOtherDigits + numRecursively;

    }

    public int powerBase10 (int n) {
        int result = 1;
        for (int i = 0; i < n; i++) {
            result *= 10;
        }
        return result;
    }


    // 数组排成最小数
    public String minmumOfArray(int[] arrar) {
        if (arrar.length == 1) {
            return  String.valueOf(arrar[0]);
        }

        int minHead = getMinmumHead(arrar, 1);
        // 在原数组中去除一个minHead，剩余元素中做递归
        boolean removed = false;
        int[] newArray = new int[arrar.length - 1];
        int newArrayIndex = -1;
        for (int i = 0; i < arrar.length; i++) {   // 这边数组难操作，要把元素祛除了变成一个新数组
            if (arrar[i] == minHead && !removed) {
                removed = true;
            } else {
                newArray[++newArrayIndex] = arrar[i];
            }
        }



        return minHead + minmumOfArray(newArray);
    }

    // 获取数组中最小的开头
    public int getMinmumHead(int[] array, int findDelta) {

        int minHead = 0;
        int minNumCount = 0;
        // 求出最高位的最小值
        for (int i = 0; i < array.length; i++) {
            if (minHead == 0) {
                minHead = getFirstNumber(array[i], findDelta);
                minNumCount++;
            } else {
                if (getFirstNumber(array[i], findDelta) < minHead) {
                    minHead = getFirstNumber(array[i], findDelta);
                    minNumCount = 1;
                } else if (getFirstNumber(array[i], findDelta) == minHead) {
                    minNumCount++;
                }
            }
        }

        // 遍历数组将最高位最小的放到一个新的集合中
        int[] newArray = new int[minNumCount];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (getFirstNumber(array[i], findDelta) == minHead) {
               newArray[index] = array[i];
               index++;
            }
        }

        if (newArray.length == 1) {
            return  newArray[0];
        } else {
            // 最高位相同的有多个，再看次高位
            return getMinmumHead(newArray, findDelta + 1);
        }
    }

    // 求数字的最高位 (index: 1, 2, 3, ...)
    public int getFirstNumber(int number, int index) {
        String strNum = String.valueOf(number);
        if (strNum.length() < index) {
            String first = strNum.substring(strNum.length() - 1);
            return Integer.valueOf(first);
        } else {
            String first = strNum.substring(index - 1, index);
            return Integer.valueOf(first);
        }

    }


    // 人家思路，循环遍历数组，将两个数组合到一块，看那种组合较小，小的数放到前面
    // 这样一轮下来，组合最小的数在数组的最前面，然后从第二个数开始继续循环，知道最后
    public String PrintMinNumber(int[] numbers) {
        String st = "";
        if(numbers.length <= 0 || numbers == null){
            return st;
        }

        for(int i = 0; i < numbers.length - 1; i++){
            for(int j = i + 1; j < numbers.length; j++){
                // 这样的方法存在大数问题
//                int a = Integer.valueOf(numbers[i]+""+numbers[j]);
//                int b = Integer.valueOf(numbers[j]+""+numbers[i]);
                String a = numbers[i] + "" + numbers[j];
                String b = numbers[j] + "" + numbers[i];
                int res = stringNumCompare(a, b);
                if (res == 1){
                    int t = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = t;
                }
            }
        }
        for(int i = 0; i < numbers.length; i++){
            st += numbers[i];
        }
        return st;
    }

    public int stringNumCompare(String strNum1, String strNum2) {
        char[] charArray1 = strNum1.toCharArray();
        char[] charArray2 = strNum2.toCharArray();

        if (charArray1.length > charArray2.length) {
            return 1;
        } else if (charArray1.length == charArray2.length) {
            int result = 0;
            for (int i = 0; i < charArray1.length; i++) {
                if (charArray1[i] > charArray2[i]) {
                    result = 1;
                    break;
                } else if (charArray1[i] < charArray2[i]) {
                    result = -1;
                    break;
                }
            }
            return result;
        } else {
            return -1;
        }
    }


    public void findNumbersAppearOnes(int[] array, int[] num1, int[] num2) {
        int resultExclusiveOr = 0;
        // 所有数字异或，得到结果
        for (int i = 0; i < array.length; i++) {
            resultExclusiveOr ^= array[i];
        }

        // 找出结果中第一个为1的位
        int index = getFirst(resultExclusiveOr);

        // 根据为第一个为1的位将数组分成两组，每组异或得到只出现一次的值
        for (int j = 0; j < array.length; j++) {
            if (match(array[j], index)) {
                num1[0] ^= array[j];
            } else {
                num2[0] ^= array[j];
            }
        }

    }

    private int getFirst(int num) {
        for (int i = 0; i < 32; i++) {
            if ((num & 1) == 0) {
                num >>= 1;
            } else {
                return i;
            }
        }
        return 0;
    }

    private boolean match(int num, int index) {
        num >>= index;
        return (num & 1) == 1;
    }


    public int randomInRange(int min, int max) {
        Random random = new Random();
        int number = random.nextInt(max - min + 1) + min;
        return number;
    }


    public int reverse (int x) {
        // write code here
        boolean isNegative = x < 0;
        int absoluteNumber = Math.abs(x);
        char[] chars = String.valueOf(absoluteNumber).toCharArray();
        int result = 0;
        for(int i = chars.length; i > 0; i--) {
            result = result + (int)(Math.pow(10, i-1) * (chars[i-1] - '0'));
        }
        if (isNegative) {
            result = (-result);
        }

        return result;
    }


    public double pow(double base, int n) throws Exception {
        //
        double result = 1;
        if (n < 0 && base == 0) {
            throw new Exception("参数异常，对0做负数次方");
        }

        // 次方数的绝对值
        int x = Math.abs(n);


        for(int i = 1; i <= x; i++) {
            result =  result * base;
        }

        if (n < 0) {
            return 1 / result;
        }

        return result;


    }

    public double powerPro(double base, int n) throws Exception {
        double result;
        if (n < 0 && base == 0) {
            throw new Exception("参数异常，对0做负数次方");
        }

        // 次方数的绝对值
        int x = Math.abs(n);

        result = purelyPower(base, x);

        if (n < 0) {
            return 1 / result;
        }

        return result;

    }

    public double purelyPower(double base, int n) {
        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return base;
        }

        if ((n & 0x01) == 1) {
            // n 为奇数
            return base * purelyPower(base,n - 1);
        }

        // n 为 偶数
        double result;
        result = purelyPower(base, n >> 1);
        return result * result;
    }

    public void printOneToNRecurisively(int[] nums, int  n) {
        if (n == 1) {
            // 当n减到1时，这一位数字有10种情况，只打印一种吗？
            for (int i = 0; i < 10; i++) {
                nums[nums.length-1] = i;
                printNumbers(nums); // 写到这
            }
//            printNumbers(nums); // 这一步不能写在这，要确定一次打一次，写上面
            return; // 这一点开始的时候没想到，应该是要退出的，不然就往后执行了！！！
        }

        // 递推公式是什么，如果递归函数本身不需要返回值的话，那递推公式所要考虑的是 chars ?
        // 递的过程怎么联系起来，归的过程又怎么联系起来？

        // 当前的过程也需要确定第 n 位，然后再递其余的n-1位，这时候应该不能打，需要等到其他位确认了
        // 确定第 n 为
        for (int i = 0; i < 10; i++) {
            nums[nums.length - n] = i;
            printOneToNRecurisively(nums, n-1);
        }

        // 这样能打出来，但是次序不对，应该按从低位到高位的次序

    }


    public void printNumbers(int[] number) {
        for (int i = 0; i < number.length; i++) {
            System.out.print(number[i]);
        }
        System.out.println();
    }

}
