package exp03;

import java.util.Scanner;

public class E3_5 {
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

        System.out.print("Enter row to remove (0-based index): ");
        int removeRow = input.nextInt();

        System.out.print("Enter column to remove (0-based index): ");
        int removeCol = input.nextInt();

        int[][] result = new int[rows - 1][cols - 1];

        int r = 0;
        for (int i = 0; i < rows; i++) {
            if (i == removeRow) continue;
            int c = 0;
            for (int j = 0; j < cols; j++) {
                if (j == removeCol) continue;
                result[r][c] = matrix[i][j];
                c++;
            }
            r++;
        }

        System.out.println("Matrix after removing row " + removeRow + " and column " + removeCol + ":");
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}

