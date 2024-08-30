import java.util.*;

public class SudokuSolver {

    static final int SIZE = 9;
    static final char EMPTY = '.';

    public static void main(String args[])
   {
   	Scanner sc=new Scanner(System.in);
	char board[][]=new char[9][9];
	for(int i=0;i<9;i++)
	{
	   for(int j=0;j<9;j++)
	     {
		board[i][j]=sc.next().charAt(0);
	     }
	}
	printSudoku(board);

    if(isValidSudoku(board))
	{
	    if(solveSudoku(board))
	    {
	      printSudoku(board);
            }
	    else
	    {
	       System.out.println("Not Able to Solve");
	    }
	}
     else
	{
	   System.out.println("Not a Valid Box");
	}
        
    }

    // Validate if the initial board configuration is a valid Sudoku
    static boolean isValidSudoku(char[][] board) {
        // Check rows and columns
        for (int i = 0; i < SIZE; i++) {
            boolean[] rowCheck = new boolean[SIZE];
            boolean[] colCheck = new boolean[SIZE];
            for (int j = 0; j < SIZE; j++) {
                if (!isValid(board[i][j], rowCheck)) {
                    return false;
                }
                if (!isValid(board[j][i], colCheck)) {
                    return false;
                }
            }
        }

        // Check 3x3 sub-boxes
        for (int i = 0; i < SIZE; i += 3) {
            for (int j = 0; j < SIZE; j += 3) {
                if (!isValidBox(board, i, j)) {
                    return false;
                }
            }
        }

        return true;
    }

    static boolean isValid(char c, boolean[] check) {
        if (c == EMPTY) {
            return true;
        }
        int num = c - '1';
        if (num < 0 || num >= SIZE || check[num]) {
            return false;
        }
        check[num] = true;
        return true;
    }

    static boolean isValidBox(char[][] board, int startRow, int startCol) {
        boolean[] boxCheck = new boolean[SIZE];
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (!isValid(board[i][j], boxCheck)) {
                    return false;
                }
            }
        }
        return true;
    }

    // Backtracking approach to solve Sudoku
    static boolean solveSudoku(char[][] board) {
        int[] emptyCell = findEmptyCell(board);
        if (emptyCell == null) {
            return true; // All cells filled
        }

        int row = emptyCell[0];
        int col = emptyCell[1];

        for (char c = '1'; c <= '9'; c++) {
            if (isValidMove(board, row, col, c)) {
                board[row][col] = c;
                if (solveSudoku(board)) {
                    return true;
                }
                board[row][col] = EMPTY; // Backtrack
            }
        }
        return false; // No valid number found for this cell
    }

    static boolean isValidMove(char[][] board, int row, int col, char c) {
        // Check row and column constraints
        for (int i = 0; i < SIZE; i++) {
            if (board[row][i] == c || board[i][col] == c) {
                return false;
            }
        }

        // Check 3x3 box constraints
        int boxStartRow = row - row % 3;
        int boxStartCol = col - col % 3;
        for (int i = boxStartRow; i < boxStartRow + 3; i++) {
            for (int j = boxStartCol; j < boxStartCol + 3; j++) {
                if (board[i][j] == c) {
                    return false;
                }
            }
        }

        return true;
    }

    static int[] findEmptyCell(char[][] board) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == EMPTY) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    // Utility function to print the Sudoku board
    static void printSudoku(char[][] board) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
