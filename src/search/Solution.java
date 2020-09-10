package search;

public class Solution {
    // 算法应该是个递归算法，每次减少一半
    // 除 数组和待查的数，是否应该传入待查的范围，还是单独写一个函数？
    // 一个函数试试应该可以

    // 总结下：
    // 首先是函数是需要 start, end 这两个参数的，通过这两个参数控制每次递归的范围（逐步缩小范围也是二分的思想）
    // 递归退出的条件是 start > end || start > array.length - 1 || end < 0，这个需要用实际的例子辅助去分析边界
    // 第一次没有找到的原因是，没有找到值时，下次 start 是 index + 1 或 end 是 index - 1;
    // 最终结果怎么返回，没有找到就 在一个小的集合里面找，把找的结果 return 就行了。

    public int binarySearch(int[] array, int number, int start, int end) {
        // 先不考虑边界问题，递归退出的条件是？找到要查找的值，或者到达数组边界
        if (array == null || array.length <= 0) {
            return -1;
        }

        // 经过分析发现只写这样就行了，不用再判断 start > array.length - 1 和 end < 0
        if (start > end) {
            // 没有找到
            return -1;
        }

        int index = (int) (start + end) / 2;
        if (array[index] == number) {
            return index;
        }

        if (array[index] > number) {
            // 前一半查找, 将end设置为 index - 1
            end = index - 1;
            // 递归结果怎么得到
            return binarySearch(array, number, start, end);
        } else {
            start = index + 1;
            return binarySearch(array, number, start, end);
        }

    }

    // 总结下关键点
    // 1. 查找到一个值后，查找左边是否有值的关键是，固定二分搜索的 start 为 0，因为是要找最左边的，右边的就不用管了
    // 所以需要一个变量 end，根据查找的 end 值

    public int[] findNumberRange(int[] array, int number) {
        // 初始化返回值
        int[] output = new int[] {-1, -1};
        if (array == null || array.length <= 0) {
            return output;
        }

        // 先使用上面查找方法进查找
        int index = binarySearch(array, number, 0, array.length - 1);
        if (index == -1) {
            // 数组中没有number
            return output;
        }

        // 找到了
        output[0] = index;
        output[1] = index;

        // 判断这个值左边是否还有相同的值，如果有递归找出左边的边界
        // 还需要传入边界, 感觉需要一个循环

        int leftIndex = index;
        int end;
        while (leftIndex - 1 >= 0 && array[leftIndex -1] == number) {
            output[0] = leftIndex - 1;
            end = leftIndex - 1;
            // 二分查找，如果有肯定能找到一个并返回其 index，没有找不到返回 -1
            // 找到的话不用管右边了，再看左边还有没有
            leftIndex = binarySearch(array, number, 0, end);
        }

        int start;
        int rightIndex = index;
        while (rightIndex + 1 < array.length && array[rightIndex + 1] == number) {
            output[1] = rightIndex + 1;
            start = rightIndex + 1;
            rightIndex = binarySearch(array, number, start, array.length - 1);
        }

        return output;
    }
}
