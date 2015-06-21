package com.twu.tictactoe;

import java.io.PrintStream;
import java.util.List;

import static java.lang.String.format;
import static java.util.Arrays.asList;


public class Board {
    private PrintStream printStream;
    private List<String> movesOnBoard;
    public static final int ARRAY_OFFSET = 1;
    private List<String> cells;

    public Board(PrintStream printStream, List<String> cells) {
        this.cells = asList(" "," "," ",
                                    " "," "," ",
                                    " "," "," ");
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

//    public boolean checkIfMoveIsValid(int move) {
//        if(movesOnBoard.get(move-ARRAY_OFFSET) == " "){
//            return true;
//        }
//        else{
//            printStream.println("Location already taken");
//            return false;
//        }
//    }

    public boolean isFull() {
        for(String c : movesOnBoard){
            if(c == " "){
                return false;
            }
        }
        printStream.println("Game is a draw");
        return true;
    }


    public boolean checkIfMoveIsValid(int i) {
        return false;
    }
}
