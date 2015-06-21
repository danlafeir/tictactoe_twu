package com.twu.tictactoe;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import static java.util.Arrays.asList;

public class Main {
    public static void main(java.lang.String[] args) {
        List<String> cells = asList(" "," "," ",
                                    " "," "," ",
                                    " "," "," ");
        Board board = new Board(System.out, cells);
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(in);
        IOParsingAndPrinting io = new IOParsingAndPrinting(bufferedReader, System.out);
        Player player1 = new Player("Player 2", "O", io, board);
        Player player2 = new Player("Player 2", "O", io, board);
        Game game = new Game(board, player1, player2);

        game.play();
    }
}
