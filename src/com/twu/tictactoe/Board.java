package com.twu.tictactoe;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;


public class Board {
    private PrintStream printStream;
    private List<String> movesOnBoard;
    public static final int ARRAY_OFFSET = 1;

    public Board(PrintStream printStream, ArrayList<Cell> cells) {
        this.movesOnBoard = asList(" "," "," ",
                                    " "," "," ",
                                    " "," "," ");
        this.printStream = printStream;
    }

    public void printBoard() {
       printStream.printf( "%s|%s|%s\n" +
                           "-----\n" +
                           "%s|%s|%s\n" +
                           "-----\n" +
                           "%s|%s|%s\n", movesOnBoard.toArray());
        printStream.println();
    }

    public void putMoveOnBoard(int move, String x) {
        movesOnBoard.set(move-ARRAY_OFFSET, x);
    }

    public boolean checkIfMoveIsValid(int move) {
        if(movesOnBoard.get(move-ARRAY_OFFSET) == " "){
            return true;
        }
        else{
            printStream.println("Location already taken");
            return false;
        }
    }

    public boolean isFull() {
        for(String c : movesOnBoard){
            if(c == " "){
                return false;
            }
        }
        printStream.println("Game is a draw");
        return true;
    }

    public void print() {
    }


    public void mark(int position, String symbol) {

    }
}
