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

    public int binarySearch(int []array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }

        int indexStart = 0;
        int indexEnd = array.length -1;
        int index = array.length / 2;
        while (index >= 0 && index < array.length) {
            if (array[index] == target) {
                return index;
            } else if (array[index] > target) {
                // 从前面半部分查找
                indexEnd = index - 1;
                index = (indexStart + indexEnd) / 2;
            } else if (array[index] < target) {
                // 从后半部分查找
                indexStart = index + 1;
                index  = (indexStart + indexEnd) / 2;
            }
        }

        return -1;

    }

    public int getMoreThanHalfNumber(int[] array) {
        if (array == null || array.length == 0) {
            return Integer.MIN_VALUE;
        }
        int result = array[0];
        int count = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == result) {
                count++;
            } else {
                if (count == 1) {
                    result = array[i];
                } else {
                    count--;
                }
            }
        }

        return result;
    }

    public int getMiddleOf(int[] array, int left, int right) {
       int middle = (left + right) / 2;
       if (array[middle] < array[left] ) {
           swap(array, left, middle );
       }

       if (array[right]  < array[left]) {
           swap(array, left, right);
       }

       if (array[right]  < array[middle]) {
           swap(array, right, middle);
       }

       return middle;
//        if (right - left < 2) {
//            return left;
//        } else {
//           int middleValue = array[(left + right) / 2];
//           if (array[left] < array[right]) {
//               if (middleValue < array[left]) {
//                   return left;
//               } else if (middleValue > array[right]) {
//                   return right;
//               } else {
//                   return (left + right) / 2;
//               }
//
//           } else {
//               if (middleValue < array[right]) {
//                   return right;
//               } else if (middleValue > array[left]) {
//                   return left;
//               } else {
//                   return (left + right) / 2;
//               }
//           }
//
//
//        }

    }

    public void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }



    // 用最后一个元素将数组分为两部分，其中左边都比最后一个元素大，右边都比最后一个元素小
    public int getBigKOf(int[] array, int left, int right) {
        int leftIndex = left;
        int rightIndex = right - 2;

        int targetIndex = getMiddleOf(array, left, right);
        swap(array, targetIndex, right -1);

        while (leftIndex < rightIndex) {
            while (leftIndex < right - 1) {
                // 找到第一个大于目标元素的位置
                if (array[leftIndex] < array[right-1]) {
                    leftIndex++;
                } else {
                    break;
                }
            }

            while (rightIndex > left) {
                // 找到第一个小于目标元素的位置
                if (array[rightIndex] > array[right-1]) {
                    rightIndex--;
                } else {
                    break;
                }
            }

            // 交换
            if (leftIndex < rightIndex) {
               swap(array, leftIndex, rightIndex);
            }
        }

        swap(array, leftIndex, right - 1);

       return leftIndex;
    }

    public int getMinK(int[] array, int k) {
        int left = 0;
        int right = array.length - 1;
        int index = getBigKOf(array, left, right);

        while (index != k) {
            if (k < index) {
                right = index - 1;
            } else {
                left = index + 1;
            }
            index = getBigKOf(array, left, right);
        }

        return  index;

    }
}
