package com.twu.tictactoe;

import java.io.PrintStream;
import java.util.List;

import static java.lang.String.format;

public class Board {
    private PrintStream printStream;
    private List<String> cells;

    public Board(PrintStream printStream, List<String> cells) {
        this.cells = cells;
        this.printStream = printStream;
    }

    public void print() {
        String boardString = format(
                "%s|%s|%s\n" +
                "-----\n" +
                "%s|%s|%s\n" +
                "-----\n" +
                "%s|%s|%s\n", cells.toArray());

        printStream.println(boardString);
    }

    public void mark(int position, String symbol) {
        cells.set(position,symbol);
        this.print();
    }

}
