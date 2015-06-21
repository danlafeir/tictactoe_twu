package com.twu.tictactoe;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Cell> cells = new ArrayList<Cell>();
        Board board = new Board(System.out, cells);
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(in);
        IOParsingAndPrinting IOParsingAndPrinting1 = new IOParsingAndPrinting(bufferedReader, System.out);
        IOParsingAndPrinting IOParsingAndPrinting2 = new IOParsingAndPrinting(bufferedReader, System.out);

        Game game = new Game(board, IOParsingAndPrinting1, IOParsingAndPrinting2);
        game.setupGame();
        game.play();
    }
}
