import java.util.Scanner;

public class MatrixOperations {

    private static final int SIZE = 4;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrixA = new int[SIZE][SIZE];
        int[][] matrixB = new int[SIZE][SIZE];

        System.out.print("Enter elements of matrix A:");
        inputMatrix(matrixA, scanner);

        System.out.print("Enter elements of matrix B:");
        inputMatrix(matrixB, scanner);

        int[][] productAB = multiplyMatrices(matrixA, matrixB);
        int[][] productBA = multiplyMatrices(matrixB, matrixA);

        System.out.println("Matrix A:");
        printMatrix(matrixA);

        System.out.println("Matrix B:");
        printMatrix(matrixB);

        System.out.println("Product AB:");
        printMatrix(productAB);

        System.out.println("Product BA:");
        printMatrix(productBA);

        boolean areEqual = areMatricesEqual(productAB, productBA);

        System.out.println("Are AB and BA equal? " + areEqual);
    }

    private static void inputMatrix(int[][] matrix, Scanner scanner) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    private static int[][] multiplyMatrices(int[][] matrixA, int[][] matrixB) {
        int[][] product = new int[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                for (int k = 0; k < SIZE; k++) {
                    product[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }

        return product;
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean areMatricesEqual(int[][] matrixA, int[][] matrixB) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (matrixA[i][j] != matrixB[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }
}