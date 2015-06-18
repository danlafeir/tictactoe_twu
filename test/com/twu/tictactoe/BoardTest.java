package com.twu.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

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

        board.putMoveOnBoard(1);
        board.printBoard();

        verify(printStream, times(1)).println(correctFirstRow);
        verify(printStream, times(2)).println(DIVIDER_OF_ROWS);
        verify(printStream, times(2)).println(correctSecondAndThirdRow);
    }

}