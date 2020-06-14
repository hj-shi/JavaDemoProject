package sort;

public class Test {
    public static void main(String[] args) {
        int[] arr = new int[] {13, 2, 6, 18, 7, 4, 25, 12, 15};
        Solution.mergeSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
