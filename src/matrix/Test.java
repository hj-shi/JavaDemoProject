package matrix;

public class Test {
    public static void main(String[] args) {
        MatrixMethods matrixMethods = new MatrixMethods();
//        int[][] matrix = matrixMethods.buildMatrix();
//        matrixMethods.printMatrixClockWisely(matrix, 4, 5);
        int[] array = new int[] {1, -2, 3, 10, -4, 7, 2, -5};
        int result = matrixMethods.maxSumOfChildArray(array);
        System.out.println(result);



        System.out.println("----------------------");
        int [][] arr = new int[][]{{4,5,6,8},{2,3},{1,6,9}};
        System.out.println(arr.length);
        System.out.println(arr[1][1]);//输出列数

        int[][] matrix = new int[][] {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15,}, {16, 17, 18, 19, 20}};

        System.out.println(matrix[4][1]);//输出2
    }

}
