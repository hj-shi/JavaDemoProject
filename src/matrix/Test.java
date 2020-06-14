package matrix;

public class Test {
    public static void main(String[] args) {
        MatrixMethods matrixMethods = new MatrixMethods();
//        int[][] matrix = matrixMethods.buildMatrix();
//        matrixMethods.printMatrixClockWisely(matrix, 4, 5);
        int[] array = new int[] {1, -2, 3, 10, -4, 7, 2, -5};
        int result = matrixMethods.maxSumOfChildArray(array);
        System.out.println(result);
    }
}
