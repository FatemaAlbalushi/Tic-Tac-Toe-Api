package com.tictactoe.TicTacToe.Model;

/**
 * The TicTacToeBoard class represents the game board for Tic Tac Toe.
 * It stores the game board as a 2D array of integers, where 0 represents an empty cell,
 * 1 represents a cell marked by player 1, and 2 represents a cell marked by player 2.
 */
public class TicTacToeBoard {
    private final int[][] board;
    private int size;

    /**
     * Constructor for the TicTacToeBoard class.
     * Initializes the size of the board to 3 and creates a new 2D array of size 3x3 to represent the board.
     */
    public TicTacToeBoard() {
        this.size = 3;
        this.board = new int[size][size];
    }

    /**
     * Marks the specified cell with the given player's mark.
     * @param row the row of the cell to mark
     * @param col the column of the cell to mark
     * @param player the player (1 or 2) making the move
     */
    public void makeMove(int row, int col, int player) {
        board[row][col] = player;
    }

    /**
     * Returns the game board as a 2D array of integers.
     * @return the game board as a 2D array of integers
     */
    public int[][] getBoard() {
        return board;
    }

    /**
     * Returns the value of the cell at the specified row and column.
     * @param row the row of the cell to retrieve the value of
     * @param col the column of the cell to retrieve the value of
     * @return the value of the cell at the specified row and column
     */
    public int getCellValue(int row, int col) {
        return board[row][col];
    }

    /**
     * Sets the value of the cell at the specified row and column to the given value.
     * @param row the row of the cell to set the value of
     * @param col the column of the cell to set the value of
     * @param value the value to set the cell to
     */
    public void setCellValue(int row, int col, int value) {
        board[row][col] = value;
    }

    /**
     * Determines whether the board is full.
     * @return true if the board is full (i.e. there are no more empty cells), false otherwise
     */
    public boolean isFull() {
        for (int[] row : board) {
            for (int cell : row) {
                if (cell == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Determines whether the specified player has won the game.
     * @param player the player to check for a win (1 or 2)
     * @return true if the specified player has won, false otherwise
     */
    public boolean hasWon(int player) {
        // check rows
        for (int row = 0; row < 3; row++) {
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true;
            }
        }

        // check columns
        for (int col = 0; col < 3; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }

        // check diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }

        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }

        return false;
    }
}

