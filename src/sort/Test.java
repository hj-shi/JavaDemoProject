package sort;

public class Test {
    public static void main(String[] args) {
        int[] arr = new int[] {13, 2, 6, 18, 7, 4, 25, 12, 15};
        Solution.mergeSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println("快排2-----------------");

//        int[] arr2 = new int[] {13, 2, 6, 18, 7, 4, 25, 12, 15, 31, 1, 16};
        int[] arr2 = new int[] {13, 2};
        Solution solution = new Solution();
        solution.quickSort2(arr2, 0, arr2.length - 1);
//        solution.insertionSort(arr2, 0, arr2.length - 1);
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
    }
}
