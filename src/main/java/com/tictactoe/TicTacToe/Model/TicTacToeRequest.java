package com.tictactoe.TicTacToe.Model;

/**
 * The TicTacToeRequest class represents a request object for a Tic Tac Toe game.
 * It contains the current state of the game board and the symbol chosen by the player.
 */
public class TicTacToeRequest {

    /**
     * The current state of the game board.
     */
    private int[][] board;

    /**
     * The symbol chosen by the player.
     */
    private String symbol;

    /**
     * Constructs an empty TicTacToeRequest object.
     */
    public TicTacToeRequest() {

    }

    /**
     * Returns the current state of the game board.
     * @return the current state of the game board.
     */
    public int[][] getBoard() {
        return board;
    }

    /**
     * Sets the current state of the game board.
     * @param board the current state of the game board.
     */
    public void setBoard(int[][] board) {
        this.board = board;
    }

    /**
     * Returns the symbol chosen by the player.
     * @return the symbol chosen by the player.
     */
    public String getSymbol() {
        return symbol;
    }

}

