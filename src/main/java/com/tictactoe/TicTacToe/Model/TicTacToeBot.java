package com.tictactoe.TicTacToe.Model;

/**

 This class represents the TicTacToeBot that plays against the player in the game.
 It uses the minimax algorithm to make moves and try to win the game.
 */
import java.util.Random;


public class TicTacToeBot{
    private final int player;
    private final Random random;

    /**
     * Constructor for TicTacToeBot class.
     * @param player the integer value representing the bot player, either 1 or 2.
     */
    public TicTacToeBot(int player) {
        this.player = player;
        this.random = new Random();
    }


    /**
     * Method that makes a move for the bot on the given board and returns the move.
     * @param board the TicTacToeBoard object representing the game board.
     * @return the move made by the bot as an array of integers containing the row and column indexes.
     */
    public int[] makeMove(TicTacToeBoard board) {
        int[] move = minimax(board, player, 0);
        board.setCellValue(move[0], move[1], player);
        return move;
    }


    /**
     * The minimax algorithm implementation for the bot to make moves and try to win the game.
     * @param board the TicTacToeBoard object representing the game board.
     * @param currentPlayer the integer value representing the current player, either 1 or 2.
     * @param depth the depth of the recursive call for the algorithm.
     * @return the move made by the bot as an array of integers containing the row and column indexes
     * and the score for the current move.
     */
    private int[] minimax(TicTacToeBoard board, int currentPlayer, int depth) {
        if (board.hasWon(player)) {
            return new int[]{-1, -1, 10 - depth};
        }

        if (board.hasWon(3 - player)) {
            return new int[]{-1, -1, depth - 10};
        }

        if (board.isFull()) {
            return new int[]{-1, -1, 0};
        }

        int bestRow = -1;
        int bestCol = -1;
        int bestScore = (currentPlayer == player) ? Integer.MIN_VALUE : Integer.MAX_VALUE;

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board.getCellValue(row, col) == 0) {
                    board.setCellValue(row, col, currentPlayer);

                    int[] score = minimax(board, 3 - currentPlayer, depth + 1);

                    if (currentPlayer == player && score[2] > bestScore) {
                        bestScore = score[2];
                        bestRow = row;
                        bestCol = col;
                    }

                    if (currentPlayer != player && score[2] < bestScore) {
                        bestScore = score[2];
                        bestRow = row;
                        bestCol = col;
                    }

                    board.setCellValue(row, col, 0);
                }
            }
        }

        return new int[]{bestRow, bestCol, bestScore};
    }
}
