package com.twu.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Matchers.booleanThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


/**
 * Created by dlafeir on 6/18/15.
 */
public class BoardTest {

    private PrintStream printStream;
    private Board board;
    public static final String DIVIDER_OF_ROWS = "-----";


    @Before
    public void setup(){
        printStream = mock(PrintStream.class);
        board = new Board(printStream);
    }

    @Test
    public void shouldPrintBoardCorrectly(){
        String correctOddRow = " | | ";

        board.printBoard();

        verify(printStream, times(3)).println(correctOddRow);
        verify(printStream, times(2)).println(DIVIDER_OF_ROWS);
    }

    @Test
    public void shouldPutAnXInTopLeftPositionWhenReceivingPlayerInputOfOne(){
        String correctFirstRow = "X| | ";
        String correctSecondAndThirdRow = " | | ";

        board.putMoveOnBoard(1,'X');
        board.printBoard();

        verify(printStream, times(1)).println(correctFirstRow);
        verify(printStream, times(2)).println(DIVIDER_OF_ROWS);
        verify(printStream, times(2)).println(correctSecondAndThirdRow);
    }

    @Test
    public void shouldPutAnXInBottomRightPositionWhenReceivingPlayerInputOfNine(){
        String correctThirdRow = " | |X";
        String correctSecondAndFirstRow = " | | ";

        board.putMoveOnBoard(9,'X');
        board.printBoard();

        verify(printStream, times(2)).println(correctSecondAndFirstRow);
        verify(printStream, times(2)).println(DIVIDER_OF_ROWS);
        verify(printStream, times(1)).println(correctThirdRow);
    }

    @Test
    public void shouldPutAnOInBottomRightPositionWhenReceivingPlayerInputOfNine(){
        String correctThirdRow = " | |O";
        String correctSecondAndFirstRow = " | | ";

        board.putMoveOnBoard(9,'O');
        board.printBoard();

        verify(printStream, times(2)).println(correctSecondAndFirstRow);
        verify(printStream, times(2)).println(DIVIDER_OF_ROWS);
        verify(printStream, times(1)).println(correctThirdRow);
    }

    @Test
    public void shouldReturnFalseWhenMoveIsAlreadyAtThatIndex(){
        board.putMoveOnBoard(1,'X');

        boolean resultOfCheck = board.checkIfMoveIsValid(1);

        assertThat(resultOfCheck, is(false));
    }

    @Test
    public void shouldReturnTrueWhenThereIsNothingAtIndex(){
        boolean resultOfCheck = board.checkIfMoveIsValid(1);

        assertThat(resultOfCheck, is(true));
    }
}