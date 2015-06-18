package com.twu.tictactoe;

import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


/**
 * Created by dlafeir on 6/18/15.
 */
public class BoardTest {

    @Test
    public void shouldPrintBoardCorrectly(){
        PrintStream printStream;
        printStream = mock(PrintStream.class);
        Board board = new Board(printStream);
        String correctOddRow = "  |  |  ";
        String correctEvenRow = "---------";

        board.printBoard();

        verify(printStream, times(3)).println(correctOddRow);
        verify(printStream, times(2)).println(correctEvenRow);
    }
}