package matrix;

public class MatrixMethods {
    public int[][] buildMatrix() {
        int[][] matrix = new int[][] {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15,}, {16, 17, 18, 19, 20}};
        return matrix;
    }

    public void printMatrixClockWisely(int[][] matrix, int columns, int rows) {
        if (matrix == null || columns <= 0 || rows <= 0) {
            return;
        }

       int start = 0;

       while (start * 2 < columns && start * 2 < rows) {
           printMatrixInCircle(matrix, columns, rows, start);
           start++;
       }

    }

    public void printMatrixInCircle(int[][] matrix, int columns, int rows, int start) {
        int endX = columns - start - 1; // 最大的 x
        int endY = rows - start - 1; // 最大的y

        // 从左往右打印一行
        for (int i = start; i <= endX; i++) {
            System.out.print(matrix[i][start] + " ");
        }

        // 从上往下打印一行
        if (endY - start + 1 >= 2) {
            for (int j = start + 1; j <= endY; j++) {
                System.out.print(matrix[endX][j] +  " " );
            }
        }

        // 从右往左打印一行
        if (endX - start + 1 >= 2 && endY - start + 1 >= 2) {
            for (int k = endX - 1; k >= start; k--) {
                System.out.print(matrix[k][endY] + " ");
            }
        }

        // 从下往上打印一行
        if (endX - start + 1 >= 2 && endY - start + 1 >= 3) {
            for (int l = endY - 1; l > start; l--) {
                System.out.print(matrix[start][l] + " ");
            }
        }
    }

    // 连续子数组的最大和
    public int maxSumOfChildArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int sum = 0;
        int maxSum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (sum <= 0) {
                sum = arr[i];
            } else {
                sum += arr[i];
            }
            if (sum > maxSum) {
                maxSum = sum;
            }
        }
        return maxSum;
    }
}
