package com.twu.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;


/**
 * Created by dlafeir on 6/18/15.
 */
public class BoardTest {

    private PrintStream printStream;
    private Board board;
    public static final String DIVIDER_OF_ROWS = "-----";
    private ArrayList<Character> movesOnBoard;
    private String correctBoard;


    @Before
    public void setup() {
        printStream = mock(PrintStream.class);
        board = new Board(printStream);
        correctBoard = "%c|%c|%c\n" +
                    "-----\n" +
                    "%c|%c|%c\n" +
                    "-----\n" +
                    "%c|%c|%c\n";
        movesOnBoard = new ArrayList<Character>();
        for(int i=0; i<9;i++){
            movesOnBoard.add(' ');
        }
    }

    @Test
    public void shouldPrintBoardCorrectly() {
        board.printBoard();

        verify(printStream).printf(correctBoard,movesOnBoard.toArray());
    }

    @Test
    public void shouldPutAnXInBottomRightPositionWhenReceivingPlayerInputOfNine() {
        movesOnBoard.set(8,'X');

        board.putMoveOnBoard(9, 'X');
        board.printBoard();

        verify(printStream).printf(correctBoard,movesOnBoard.toArray());
    }


    @Test
    public void shouldReturnFalseWhenMoveIsAlreadyAtThatIndex() {
        board.putMoveOnBoard(1, 'X');

        boolean resultOfCheck = board.checkIfMoveIsValid(1);

        assertThat(resultOfCheck, is(false));
    }

    @Test
    public void shouldReturnTrueWhenThereIsNothingAtIndex() {
        boolean resultOfCheck = board.checkIfMoveIsValid(1);

        assertThat(resultOfCheck, is(true));
    }

    @Test
    public void shouldPrintAMessageWhenMoveIsInvalid() {
        board.putMoveOnBoard(1, 'X');

        board.checkIfMoveIsValid(1);

        verify(printStream).println("Location already taken");
    }

    @Test
    public void shouldReturnTrueWhenBoardIsFull() {
        for (int i = 1; i <= 9; i++) {
            board.putMoveOnBoard(i, 'X');
        }

        boolean resultOfCheck = board.isFull();

        assertThat(resultOfCheck, is(true));
    }

    @Test
    public void shouldReturnFalseWhenBoardIsNotFull() {
        boolean resultOfCheck = board.isFull();

        assertThat(resultOfCheck, is(false));
    }

    @Test
    public void shouldPrintMessageWhenBoardIsFull() {
        for (int i = 1; i <= 9; i++) {
            board.putMoveOnBoard(i, 'X');
        }

        board.isFull();

        verify(printStream).println("Game is a draw");
    }
}