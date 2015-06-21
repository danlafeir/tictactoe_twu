package com.twu.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;


/**
 * Created by dlafeir on 6/18/15.
 */
public class BoardTest {

    private PrintStream printStream;
    private Board board;
    private List<String> movesOnBoard;
    private ArrayList<Cell> cells;


    @Before
    public void setup() {
        printStream = mock(PrintStream.class);
        cells = mock(ArrayList.class);
        board = new Board(printStream, cells);
        movesOnBoard = asList(" "," "," ",
                " "," "," ",
                " "," "," ");

    }

    @Test
    public void shouldPrintBoardCorrectly() {
        String correctBoard =  " | | \n" +
                "-----\n" +
                " | | \n" +
                "-----\n" +
                " | | \n";

        board.print();

        verify(printStream).println(correctBoard);
    }

}