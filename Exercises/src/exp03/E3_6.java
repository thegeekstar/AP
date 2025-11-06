package exp03;

import java.util.Scanner;

public class E3_6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = input.nextInt();

        System.out.print("Enter number of columns: ");
        int cols = input.nextInt();

        if (rows < 2 || cols < 2) {
            System.out.println("Matrix must be at least 2x2.");
            return;
        }

        int[][] matrix = new int[rows][cols];

        System.out.println("Enter matrix elements:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = input.nextInt();
            }
        }

        int maxSum = Integer.MIN_VALUE;
        int bestRow = 0, bestCol = 0;

        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < cols - 1; j++) {
                int sum = matrix[i][j] + matrix[i][j+1]
                        + matrix[i+1][j] + matrix[i+1][j+1];

                if (sum > maxSum) {
                    maxSum = sum;
                    bestRow = i;
                    bestCol = j;
                }
            }
        }

        System.out.println("Max 2x2 submatrix:");
        System.out.println(matrix[bestRow][bestCol] + " " + matrix[bestRow][bestCol+1]);
        System.out.println(matrix[bestRow+1][bestCol] + " " + matrix[bestRow+1][bestCol+1]);
        System.out.println("Max sum: " + maxSum);
    }
}

