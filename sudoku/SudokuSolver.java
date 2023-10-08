import java.awt.Point;

public class SudokuSolver {

    private SudokuGrid grid;

    public SudokuSolver(SudokuGrid grid) {
        // Initialize the SudokuSolver with the provided SudokuGrid
        this.grid = grid;
    }

    public boolean solve() {
        // Use a recursive strategy to solve the Sudoku puzzle
        Point emptyCell = grid.findEmptyCell();

        if (emptyCell == null) {
            return true; 
        }

        int row = emptyCell.x;
        int col = emptyCell.y;

        for (int digit = 1; digit <= SudokuGrid.DIGIT_RANGE; digit++) {
            if (!grid.givesConflict(row, col, digit)) {
                grid.fillCell(row, col, digit);

                if (solve()) {
                    return true;
                }
                grid.fillCell(row, col, 0); 
            }
        }

        return false;
    }

    public static void main(String[] args) {
        // Create a SudokuGrid and a SudokuSolver
        // Call solve() to solve the puzzle and print the solution or a message if no solution is found
        SudokuGrid sudokuGrid = new SudokuGrid(); 
        SudokuSolver solver = new SudokuSolver(sudokuGrid);
        if (solver.solve()) {
            sudokuGrid.print(); // Print the solved Sudoku grid
        } else {
            System.out.println("No solution");
        }
    }
}