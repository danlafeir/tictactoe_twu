package com.twu.tictactoe;

import java.io.PrintStream;

/**
 * Created by dlafeir on 6/18/15.
 */
public class Main {
    public static void main(String[] args) {

        Board board = new Board(System.out);
        board.printBoard();
    }
}
