package exp03;

import java.util.Scanner;

public class E3_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter elements of a 2x2 matrix:");

        System.out.print("a11: ");
        double a11 = input.nextDouble();

        System.out.print("a12: ");
        double a12 = input.nextDouble();

        System.out.print("a21: ");
        double a21 = input.nextDouble();

        System.out.print("a22: ");
        double a22 = input.nextDouble();

        double determinant = (a11 * a22) - (a12 * a21);

        System.out.println("Determinant = " + determinant);
    }
}
