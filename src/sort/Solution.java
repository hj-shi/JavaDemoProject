package sort;

import java.util.Random;

public class Solution {
    private static final int CUTOFF = 10;

    // 归并排序
    public static void mergeSort(int[] a) {
        int[] tmpArray = new int[a.length];
        mergeSort(a, tmpArray, 0, a.length - 1);
    }

    private static void mergeSort(int[] a, int[] tmpArray, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(a, tmpArray, left, center);
            mergeSort(a, tmpArray, center + 1, right);
            merge(a, tmpArray, left, center + 1, right);
        }
    }

    private static void merge(int[] a, int[] tmpArray, int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos + 1;

        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (a[leftPos] <= a[rightPos]) {
                tmpArray[tmpPos++] = a[leftPos++];
            } else {
                tmpArray[tmpPos++] = a[rightPos++];
            }
        }

        // 拷贝剩余所有的
        while (leftPos <= leftEnd) {
            tmpArray[tmpPos++] = a[leftPos++];
        }

        while (rightPos <= rightEnd) {
            tmpArray[tmpPos++] = a[rightPos++];
        }

        // 把临时数组拷贝回来
        for (int i = 0; i < numElements; i++, rightEnd--) {
            a[rightEnd] = tmpArray[rightEnd];
        }
    }


    public void quickSort(int[] array, int length, int start, int end) {
        if (start == end) {
            return;
        }

        int index = partition(array, length, start, end);
        if (index > start) {
            quickSort(array, length, start, index - 1);
        }
        if (index < end) {
            quickSort(array, length, index + 1, end);
        }
    }


    public int  partition(int[] data, int length, int start, int end) {
        if (data == null || length < 0 || start < 0 || end >= length) {
            throw new IllegalArgumentException("参数异常，请检查入参");
        }

        int index = randomInRange(start, end);
        // 交换index 和 end
        swap(data, index, end);

        int small = start - 1;
        for (index = start; index < end; ++index) {
            if (data[index] < data[end]) {
                ++small;
                if (small != index) {
                    swap(data, index, small);
                }
            }
        }

        ++small;
        swap(data, small, end);

        return small;
    }

    private int randomInRange(int start, int end) {
        int delta = end - start + 1;
        Random rand = new Random();
        int randDelta = rand.nextInt(delta);

        return start + randDelta;
    }

    // 交换数组中两个位置的数字
    private void swap(int[] arr, int pos1, int  pos2) {
        int tmp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = tmp;
    }

    private int median3(int[] arr, int left, int right) {
        int center = (left + right) / 2;
        if (arr[center] < arr[left]) {
            swap(arr, left, center);
        }
        if (arr[right] < arr[left]) {
            swap(arr, left, right);
        }
        if (arr[right] < arr[center]) {
            swap(arr, center, right);
        }

        // 这样排序之后最后一个肯定比选择的值大，第一个肯定比选择的值小
        return center;
    }

    public int partion2(int[] array, int start, int end) {
        if (array == null || array.length < 0 || start < 0 || end >= array.length) {
            throw new IllegalArgumentException("参数异常，请检查入参");
        }

        int index = median3(array, start, end);

        // 交换中值和倒数第二个数
        swap(array, index, end - 1);

        int i = start, j = end - 1;
        for (;;) {
            while (array[++i] < array[end-1]) {}
            while (array[--j] > array[end-1]) {}
            if (i < j) {
                swap(array, i, j);
            } else {
                break;
            }
        }

        swap(array, i, end - 1);

        return i;
    }

    public void quickSort2(int[] array, int start, int end) {
        if (start == end) {
            return;
        }

        if (start + CUTOFF <= end) {
            int index = partion2(array, start, end);

            quickSort2(array, start,index - 1);
            quickSort2(array,index + 1, end);
        } else {
            insertionSort(array, start, end);
        }
    }

    public void insertionSort(int[] array, int start, int end) {
        for (int p = start + 1; p <= end; p++) {
            for (int j = p; j > start; j--) {
                if (array[j] < array[j-1]) {
                    int tmp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = tmp;
                } else {
                    break;
                }
            }
        }
    }

}
