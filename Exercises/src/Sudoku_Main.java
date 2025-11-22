import java.util.Scanner;

public class Sudoku_Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Sudoku_class game = new Sudoku_class("sudoku.txt");

        System.out.println("The Game has started.");
        game.Print();
        game.unfillingAction();

        while (!game.isComplete()) {

            int row = 0, col = 0, num = 0;
            while (true) {
                System.out.print("Row Number (1-9): ");
                row = sc.nextInt();
                if (row >= 1 && row <= 9) break;
                System.out.println("Invalid Number! Try again.");
            }

            while (true) {
                System.out.print("Column Number (1-9): ");
                col = sc.nextInt();
                if (col >= 1 && col <= 9) break;
                System.out.println("Invalid Number! Try again.");
            }

            while (true) {
                System.out.print("For adding numbers Type (1-9) and for removing Type (0): ");
                num = sc.nextInt();
                if (num >= 0 && num <= 9) break;
                System.out.println("Invalid Number! Try again.");
            }

            if (num == 0) {
                game.matrix[row - 1][col - 1] = 0;
                System.out.println("Number has been removed.");
            } else {
                game.matrix[row - 1][col - 1] = num;
                if (!game.checkRules()) {
                    System.out.println("Try Again!");
                    game.matrix[row - 1][col - 1] = 0;
                    continue;
                }
                System.out.println("Number has been added.");
            }

            game.unfillingAction();

            game.saveToFile(game.fileAddress);

            game.Print();
        }

        System.out.println("Game Over!");
        sc.close();
    }
}
