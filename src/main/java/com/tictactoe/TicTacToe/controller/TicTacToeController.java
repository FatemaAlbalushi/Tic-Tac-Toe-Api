package com.tictactoe.TicTacToe.controller;

import com.tictactoe.TicTacToe.Model.TicTacToeBoard;
import com.tictactoe.TicTacToe.Model.TicTacToeBot;
import com.tictactoe.TicTacToe.Model.TicTacToeRequest;
import com.tictactoe.TicTacToe.Model.TicTacToeResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TicTacToeController {

    @PostMapping
    public ResponseEntity<TicTacToeResponse> getBoardState(@RequestBody TicTacToeRequest request) {
        // Create a new TicTacToeBoard object
        TicTacToeBoard board = new TicTacToeBoard();

        // Populate the board with the given values
        int[][] boardState = request.getBoard();
        for (int i = 0; i < boardState.length; i++) {
            for (int j = 0; j < boardState[i].length; j++) {
                board.makeMove(i, j, boardState[i][j]);
            }
        }

        // Determine the player's symbol
        int player = 0;
        if (request.getSymbol().equals("X")) {
            player = 1;
        } else if (request.getSymbol().equals("O")) {
            player = 2;
        }

        // Get the bot's next move
        TicTacToeBot bot = new TicTacToeBot(player);
        int[] move = bot.makeMove(board);

        // Make the bot's move
        board.makeMove(move[0], move[1], player);

        // Create the response object
        TicTacToeResponse response = new TicTacToeResponse(board.getBoard());

        int[][] boardWithSymbols = new int[3][3];
        for (int i = 0; i < boardWithSymbols.length; i++) {
            for (int j = 0; j < boardWithSymbols[i].length; j++) {
                int value = board.getBoard()[i][j];
                if (value == 1) {
                    boardWithSymbols[i][j] = 'X';
                } else if (value == 2) {
                    boardWithSymbols[i][j] = 'O';
                } else {
                    boardWithSymbols[i][j] = ' ';
                }
            }
        }
        response.setBoardWithSymbols(boardWithSymbols);

        // Return the response
        return ResponseEntity.ok().body(response);

   }
}

