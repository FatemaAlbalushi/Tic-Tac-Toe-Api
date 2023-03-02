package com.tictactoe.TicTacToe.Model;

import org.springframework.http.HttpStatus;

public class TicTacToeResponse {
    private int[][] board;
    private String[][] boardWithSymbols;
    private String status;

    private boolean isWinner;
    private boolean isFull;



    /**
     * Constructor for TicTacToeResponse class.
     * Takes in an int[][] array representing the Tic Tac Toe board and
     * generates a String[][] array with X's and O's instead of 1's and 2's
     * for easier readability.
     * @param board int[][] array representing the Tic Tac Toe board
     */
    public TicTacToeResponse(int[][] board) {
        this.board = board;
        this.boardWithSymbols = new String[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) {
                    boardWithSymbols[i][j] = " ";
                } else if (board[i][j] == 1) {
                    boardWithSymbols[i][j] = "X";
                } else if (board[i][j] == 2) {
                    boardWithSymbols[i][j] = "O";
                }
            }
        }


    }



    /**
     * Getter for the board variable.
     * @return int[][] array representing the Tic Tac Toe board
     */
//    public int[][] getBoard() {
//        return board;
//    }

    /**
     * Setter for the board variable.
     * @param board int[][] array representing the Tic Tac Toe board
     */
    public void setBoard(int[][] board) {
        this.board = board;
    }


    /**
     * Getter for the boardWithSymbols variable.
     * @return String[][] array representing the Tic Tac Toe board with X's and O's
     */
    public String[][] getBoardWithSymbols() {
        return boardWithSymbols;
    }


    public String getStatus() {
        TicTacToeBoard board1 = new TicTacToeBoard();
        if (board1.hasWon(1)) {
            status=("Game over. Player X wins.");
        } else if (board1.hasWon(2)) {
            status=("Game over. Player X wins.");
        }
        else if (board1.isFull()) {
            status=("Game over. Board is full. It's a tie.");
        } else {
            status=("Request succeeded with status code " + HttpStatus.OK.value());
        }
        return status;
    }


    /**
     * Setter for the boardWithSymbols variable.
     * Note: This setter is not used and is included for completeness.
     * @param boardWithSymbols int[][] array representing the Tic Tac Toe board with X's and O's
     */
    public void setBoardWithSymbols(String[][] boardWithSymbols) {
        this.boardWithSymbols = boardWithSymbols;
    }

    public void setBoardWithSymbols(int[][] boardWithSymbols) {
    }
}

