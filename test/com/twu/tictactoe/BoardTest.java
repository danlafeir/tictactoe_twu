package com.twu.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.*;


/**
 * Created by dlafeir on 6/18/15.
 */
public class BoardTest {

    private PrintStream printStream;
    private Board board;
    private List<String> movesOnBoard;
    private ArrayList<String> cells;


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

    @Test
    public void shouldPutXInPositionOneWhenBoardMarkedInPositionOne(){
        when(cells.get(0)).thenReturn("X");
        String correctBoard =  "X| | \n" +
                "-----\n" +
                " | | \n" +
                "-----\n" +
                " | | \n";

        board.mark(0, "X");

        verify(printStream).println(correctBoard);
    }

}