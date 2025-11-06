package exp03;

import java.util.Scanner;

public class E3_3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = input.nextInt();

        System.out.print("Enter number of columns: ");
        int cols = input.nextInt();

        int[][] matrix = new int[rows][cols];

        System.out.println("Enter matrix elements:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = input.nextInt();
            }
        }

        int maxRowIndex = 0;
        int maxRowSum = Integer.MIN_VALUE;

        for (int i = 0; i < rows; i++) {
            int rowSum = 0;
            for (int j = 0; j < cols; j++) {
                rowSum += matrix[i][j];
            }

            if (rowSum > maxRowSum) {
                maxRowSum = rowSum;
                maxRowIndex = i + 1;
            }
        }

        System.out.println("Row with the largest sum is: " + maxRowIndex);
        System.out.println("Sum = " + maxRowSum);
    }
}

