package search;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
//        int[] array = new int[]{5,7,7,8,9,10};
        Solution solution = new Solution();

//        System.out.println("预期输出-1");
//        int index = solution.binarySearch(array, -1,  0, array.length - 1);
//        System.out.println(index);
//
//        System.out.println("预期输出0");
//        int index1 = solution.binarySearch(array, 5,  0, array.length - 1);
//        System.out.println(index1);
//
//        System.out.println("预期输出5");
//        int index2 = solution.binarySearch(array, 10,  0, array.length - 1);
//        System.out.println(index2);
//
//        System.out.println("预期输出-1");
//        int index3 = solution.binarySearch(array, 11,  0, array.length - 1);
//        System.out.println(index3);
//
//        System.out.println("预期输出1或2");
//        int index4 = solution.binarySearch(array, 7,  0, array.length - 1);
//        System.out.println(index4);


//        int index = solution.binarySearch(array, -1,  7, array.length - 1);
//        System.out.println("查找结果： " + index);

//        int[] output = solution.findNumberRange(array, 8);
//        System.out.println("中间值，预期输出33");
//        for (int i = 0; i < output.length; i++) {
//            System.out.print(output[i]);
//        }
//        System.out.println();
//
//        int[] output1 = solution.findNumberRange(array, 5);
//        System.out.println("左边界，预期输出00");
//        for (int i = 0; i < output1.length; i++) {
//            System.out.print(output1[i]);
//        }
//        System.out.println();
//
//        int[] output2 = solution.findNumberRange(array, -1);
//        System.out.println("超过左边界，预期输出-1-1");
//        for (int i = 0; i < output2.length; i++) {
//            System.out.print(output2[i]);
//        }
//        System.out.println();
//
//        int[] output3 = solution.findNumberRange(array, 7);
//        System.out.println("中间值重复值，预期输出12");
//        for (int i = 0; i < output3.length; i++) {
//            System.out.print(output3[i]);
//        }
//        System.out.println();
//
//        int[] output4 = solution.findNumberRange(array, 10);
//        System.out.println("右边界，预期输出55");
//        for (int i = 0; i < output4.length; i++) {
//            System.out.print(output4[i]);
//        }
//        System.out.println();
//
//        int[] output5 = solution.findNumberRange(array, 15);
//        System.out.println("超出右边界，预期输出-1-1");
//        for (int i = 0; i < output5.length; i++) {
//            System.out.print(output5[i]);
//        }

//        int[] testarray = new int[] {1, 3, 5, 7, 8 , 9};
//        int target = 9;
//        int result = solution.binarySearch(testarray, target);
//        System.out.println(result);

//        int[] array = new int[] {1, 2, 3, 2, 2, 2, 5, 4, 2};
//        System.out.println(solution.getMoreThanHalfNumber(array));
//        int[] array = new int[] {4, 5, 1, 8, 2, 7, 3, 6};
//        int k = solution.getMinK(array, 4);
//        for (int i = 0; i < k; i++) {
//            System.out.print(array[i] + " ");
//        }
//        System.out.println();
//        System.out.println(k);

        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i) + " ");
        }
        System.out.println();

        arrayList.remove(1);


        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i) + " ");
        }
//        int[] array = new int[] {4, 5, 1, 8, 2, 7, 3, 6};
//        int index = solution.getBigKOf(array, 0, 7);
//        System.out.println(index);
    }
}
