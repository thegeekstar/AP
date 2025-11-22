import java.io.*;

public class Sudoku_class {

    int[][] matrix;
    String fileAddress;
    private long startTime;
    private int filledCount;
    private int unfilledCount;

    public Sudoku_class(String fileAddress) {
        this.fileAddress = fileAddress;
        this.filledCount = 0;
        this.unfilledCount = 0;
        this.startTime = System.currentTimeMillis();
        this.matrix = new int[9][9];
        loadMatrixFromFile();
    }

    private void loadMatrixFromFile() {
        this.matrix = readBoardFromFile(this.fileAddress);
    }

    void saveToFile(String address) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(address))) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    bw.write(matrix[i][j] + "");
                }
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error in saving the file!!!" + e.getMessage());
        }
    }


    private int[][] readBoardFromFile(String address) {
        int[][] tempMatrix = new int[9][9];

        try (BufferedReader br = new BufferedReader(new FileReader(address))) {

            for (int i = 0; i < 9; i++) {
                String line = br.readLine();
                if (line == null) break;

                for (int j = 0; j < 9; j++) {
                    char c = line.charAt(j);
                    if (c == '.' || c == '0') {
                        tempMatrix[i][j] = 0;
                    } else {
                        tempMatrix[i][j] = Character.getNumericValue(c);
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("File Not Found!!!" + e.getMessage());
        }

        return tempMatrix;
    }

    public void Print() {

        System.out.print("    ");
        for (int col = 0; col < 9; col++) {
            System.out.print((col + 1) + "  ");
            if ((col + 1) % 3 == 0 && col != 8) System.out.print(" ");
        }
        System.out.println();

        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0) {
                System.out.println("  +-------+-------+-------+");
            }

            System.out.print((i + 1) + " | ");

            for (int j = 0; j < 9; j++) {
                if (matrix[i][j] == 0) {
                    System.out.print(". ");
                } else {
                    System.out.print(matrix[i][j] + " ");
                }

                if ((j + 1) % 3 == 0) System.out.print("| ");
            }
            System.out.println();
        }
        System.out.println("  +-------+-------+-------+");
    }

    boolean checkRules() {
        for (int i = 0; i < 9; i++) {
            boolean[] seen = new boolean[10];
            for (int j = 0; j < 9; j++) {
                int num = matrix[i][j];
                if (num != 0) {
                    if (seen[num]) return false;
                    seen[num] = true;
                }
            }
        }

        for (int j = 0; j < 9; j++) {
            boolean[] seen = new boolean[10];
            for (int i = 0; i < 9; i++) {
                int num = matrix[i][j];
                if (num != 0) {
                    if (seen[num]) return false;
                    seen[num] = true;
                }
            }
        }

        for (int blockRow = 0; blockRow < 3; blockRow++) {
            for (int blockCol = 0; blockCol < 3; blockCol++) {
                boolean[] seen = new boolean[10];
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        int num = matrix[blockRow * 3 + i][blockCol * 3 + j];
                        if (num != 0) {
                            if (seen[num]) return false;
                            seen[num] = true;
                        }
                    }
                }
            }
        }

        return true;
    }

    public void unfillingAction() {
        int filled = 0;
        int unfilled = 0;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (matrix[i][j] == 0) {
                    unfilled++;
                } else {
                    filled++;
                }
            }
        }

        this.filledCount = filled;
        this.unfilledCount = unfilled;
    }

    public void fillingAction() {
        if (checkRules()) {
            filledCount++;
            saveToFile(fileAddress);
        }
    }

    public boolean isComplete() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (matrix[i][j] == 0) return false;
            }
        }
        return true;
    }

}

