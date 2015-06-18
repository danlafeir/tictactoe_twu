package com.twu.tictactoe;

import java.io.PrintStream;

/**
 * Created by dlafeir on 6/18/15.
 */
public class Board {
    private PrintStream printStream;
    public static final String CORRECT_EVEN_ROW = "---------";
    public static final String CORRECT_ODD_ROW = "  |  |  ";


    public Board(PrintStream printStream) {

        this.printStream = printStream;
    }

    public void printBoard() {
        printStream.println(CORRECT_ODD_ROW);
        printStream.println(CORRECT_EVEN_ROW);
        printStream.println(CORRECT_ODD_ROW);
        printStream.println(CORRECT_EVEN_ROW);
        printStream.println(CORRECT_ODD_ROW);
        
    }
}
