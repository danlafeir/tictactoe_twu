package com.twu.tictactoe;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dlafeir on 6/18/15.
 */
public class Board {
    private PrintStream printStream;
    public static final String CORRECT_EVEN_ROW = "-----";
    private List<Character> movesOnBoard;

    public Board(PrintStream printStream) {
        movesOnBoard = new ArrayList<Character>();
        for(int i=0; i<=10;i++){
            movesOnBoard.add(' ');
        }
        this.printStream = printStream;
    }

    public void printBoard() {
        printStream.println();
        printStream.println(movesOnBoard.get(1) + "|" + movesOnBoard.get(2) + "|" + movesOnBoard.get(3));
        printStream.println(CORRECT_EVEN_ROW);
        printStream.println(movesOnBoard.get(4) + "|" + movesOnBoard.get(5) + "|" + movesOnBoard.get(6));
        printStream.println(CORRECT_EVEN_ROW);
        printStream.println(movesOnBoard.get(7) + "|" + movesOnBoard.get(8) + "|" + movesOnBoard.get(9));
        printStream.println();
    }

    public void putMoveOnBoard(int move, char x) {
        movesOnBoard.set(move, x);
    }

    public boolean checkIfMoveIsValid(int index) {
        if(movesOnBoard.get(index) == ' '){
            return true;
        }
        else{
            printStream.println("Location already taken");
            return false;
        }
    }
}
