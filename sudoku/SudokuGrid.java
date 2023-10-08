import java.awt.Point;

public class SudokuGrid {
    private static final int SIZE = 9;
    static final int DIGIT_RANGE = 9;

    private int[][] grid;
    private int rEmpty, cEmpty; // Coordinates of the last found empty cell

    public SudokuGrid() {
        // Initialize the grid and set rEmpty and cEmpty to -1
        grid = new int[SIZE][SIZE];
        rEmpty = -1;
        cEmpty = -1;
    }

    public SudokuGrid copy() {
        // Create a copy of the SudokuGrid and return it
        SudokuGrid copyGrid = new SudokuGrid();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                copyGrid.grid[i][j] = this.grid[i][j];
            }
        }
        copyGrid.rEmpty = this.rEmpty;
        copyGrid.cEmpty = this.cEmpty;
        return copyGrid;
    }

    public Point findEmptyCell() {
        // Find the next empty cell in reading order and return its coordinates as a Point
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (grid[row][col] == 0) {
                    rEmpty = row;
                    cEmpty = col;
                    return new Point(row, col);
                }
            }
        }
        return null;
    }

    public void print() {
        // Print the Sudoku grid
        for (int i = 0; i < SIZE; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println("+-------------------+");
            }
            for (int j = 0; j < SIZE; j++) {
                if (j % 3 == 0 && j != 0) {
                    System.out.print("| ");
                }
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void fillCell(int r, int c, int value) {
        // Fill the cell at row r and column c
        grid[r][c] = value; 
    }

    public boolean givesConflict(int r, int c, int d) {
        // Check if filling the number d in the cell at row r and column c causes a conflict
        return rowConflict(r, d) || colConflict(c, d) || boxConflict(r, c, d);
    }

    private boolean rowConflict(int r, int d) {
        // Check if there is a conflict in the row r when filling the number d
        for (int col = 0; col < SIZE; col++) {
            if (grid[r][col] == d) {
                return true;
            }
        }
        return false;
    }

    private boolean colConflict(int c, int d) {
        // Check if there is a conflict in the column c when filling the number d
        for (int row = 0; row < SIZE; row++) {
            if (grid[row][c] == d) {
                return true;
            }
        }
        return false;
    }

    private boolean boxConflict(int r, int c, int d) {
        // Check if there is a conflict in the 3x3 box containing the cell at row r and column c
        // when filling the number d
        int boxRow = (r / 3) * 3;
        int boxCol = (c / 3) * 3;
        for (int i = boxRow; i < boxRow + 3; i++) {
            for (int j = boxCol; j < boxCol + 3; j++) {
                if (grid[i][j] == d) {
                    return true;
                }
            }
        }
        return false;
    }
}