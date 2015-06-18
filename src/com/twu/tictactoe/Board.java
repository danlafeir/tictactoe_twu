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
    public static final int ARRAY_OFFSET = 1;

    public Board(PrintStream printStream) {
        movesOnBoard = new ArrayList<Character>();
        for(int i=0; i<9;i++){
            movesOnBoard.add(' ');
        }
        this.printStream = printStream;
    }

    public void printBoard() {
        printStream.println();
        printStream.println(movesOnBoard.get(0) + "|" + movesOnBoard.get(1) + "|" + movesOnBoard.get(2));
        printStream.println(CORRECT_EVEN_ROW);
        printStream.println(movesOnBoard.get(3) + "|" + movesOnBoard.get(4) + "|" + movesOnBoard.get(5));
        printStream.println(CORRECT_EVEN_ROW);
        printStream.println(movesOnBoard.get(6) + "|" + movesOnBoard.get(7) + "|" + movesOnBoard.get(8));
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
