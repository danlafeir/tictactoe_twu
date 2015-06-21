package com.twu.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by dlafeir on 6/18/15.
 */
public class IOParsingAndPrintingTest {

    private IOParsingAndPrinting IOParsingAndPrinting;
    private BufferedReader bufferedReader;
    private PrintStream printStream;

    @Before
    public void setup(){
        bufferedReader = mock(BufferedReader.class);
        printStream = mock(PrintStream.class);
        IOParsingAndPrinting = new IOParsingAndPrinting(bufferedReader, printStream);
    }

    @Test
    public void shouldCallReadLineWhenGrabbingPlayersMove() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");

        int move = IOParsingAndPrinting.getPlayersMoveAtCorrectArrayIndex("Player one");

        assertThat(move, is(0));
    }

    @Test
    public void shouldPrintMessageWhenGrabbingUserInput(){
        String correctMessage = "Player one please enter a position between 1 and 9: ";

        IOParsingAndPrinting.getPlayersMoveAtCorrectArrayIndex("Player one");

        verify(printStream).print(correctMessage);
    }

}