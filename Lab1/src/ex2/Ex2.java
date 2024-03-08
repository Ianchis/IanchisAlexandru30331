package ex2;

public class Ex2 {
    public static void main(String[] args) {
        int[][] matrix1 = {{2, 3, 1}, {7, 1, 6}, {9, 2, 4}};
        int[][] matrix2 = {{8, 5, 3}, {3, 9, 2}, {2, 7, 3}};

        // Calculate sum of matrices
        int[][] sum = addMatrices(matrix1, matrix2);

        // Calculate product of matrices
        int[][] product = multiplyMatrices(matrix1, matrix2);

        // Displaying results
        System.out.println("Sum of matrices:");
        displayMatrix(sum);
        System.out.println("\nProduct of matrices:");
        displayMatrix(product);
    }

    // Function to add two matrices
    public static int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int columns = matrix1[0].length;
        int[][] result = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }

    // Function to multiply two matrices
    public static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        int rows1 = matrix1.length;
        int columns1 = matrix1[0].length;
        int columns2 = matrix2[0].length;
        int[][] result = new int[rows1][columns2];

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < columns2; j++) {
                for (int k = 0; k < columns1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }

    // Function to display matrix
    public static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
