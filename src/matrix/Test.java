package matrix;

public class Test {
    public static void main(String[] args) {
        MatrixMethods matrixMethods = new MatrixMethods();
        int[][] matrix = matrixMethods.buildMatrix();
        matrixMethods.printMatrixClockWisely(matrix, 4, 5);
    }
}
