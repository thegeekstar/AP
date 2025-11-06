package exp03;

import java.util.Scanner;

public class E3_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of rows of Matrix A: ");
        int r1 = input.nextInt();
        System.out.print("Enter number of columns of Matrix A: ");
        int c1 = input.nextInt();

        System.out.print("Enter number of rows of Matrix B: ");
        int r2 = input.nextInt();
        System.out.print("Enter number of columns of Matrix B: ");
        int c2 = input.nextInt();

        if (c1 != r2) {
            System.out.println("Matrix multiplication is not possible!");
            return;
        }

        int[][] A = new int[r1][c1];
        System.out.println("\nEnter elements of Matrix A:");
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c1; j++) {
                A[i][j] = input.nextInt();
            }
        }

        int[][] B = new int[r2][c2];
        System.out.println("\nEnter elements of Matrix B:");
        for (int i = 0; i < r2; i++) {
            for (int j = 0; j < c2; j++) {
                B[i][j] = input.nextInt();
            }
        }

        int[][] result = new int[r1][c2];

        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                result[i][j] = 0;
                for (int k = 0; k < c1; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        System.out.println("\nResult of Matrix Multiplication:");
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
