package com.twu.tictactoe;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;


public class Board {
    private PrintStream printStream;
    private List<Character> movesOnBoard;
    public static final int ARRAY_OFFSET = 1;

    public Board(PrintStream printStream) {
        this.movesOnBoard = new ArrayList<Character>();
        for(int i=0; i<9;i++){
            this.movesOnBoard.add(' ');
        }
        this.printStream = printStream;
    }

    public void printBoard() {
       printStream.printf( "%c|%c|%c\n" +
                           "-----\n" +
                           "%c|%c|%c\n" +
                           "-----\n" +
                           "%c|%c|%c\n", movesOnBoard.toArray());
        printStream.println();
    }

    public void putMoveOnBoard(int move, char x) {
        movesOnBoard.set(move-ARRAY_OFFSET, x);
    }

    public boolean checkIfMoveIsValid(int move) {
        if(movesOnBoard.get(move-ARRAY_OFFSET) == ' '){
            return true;
        }
        else{
            printStream.println("Location already taken");
            return false;
        }
    }

    public boolean isFull() {
        for(char c : movesOnBoard){
            if(c == ' '){
                return false;
            }
        }
        printStream.println("Game is a draw");
        return true;
    }
}
