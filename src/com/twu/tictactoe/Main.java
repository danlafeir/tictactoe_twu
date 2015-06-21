package com.twu.tictactoe;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        Board board = new Board(System.out);
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(in);
        IOParsingAndPrinting IOParsingAndPrinting1 = new IOParsingAndPrinting(bufferedReader, System.out);
        IOParsingAndPrinting IOParsingAndPrinting2 = new IOParsingAndPrinting(bufferedReader, System.out);

        Game game = new Game(board, IOParsingAndPrinting1, IOParsingAndPrinting2);
        game.setupGame();
        game.play();
    }
}
