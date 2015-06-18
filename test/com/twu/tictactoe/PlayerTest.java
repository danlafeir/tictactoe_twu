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
public class PlayerTest {

    private Player player;
    private BufferedReader bufferedReader;
    private PrintStream printStream;

    @Before
    public void setup(){
        bufferedReader = mock(BufferedReader.class);
        printStream = mock(PrintStream.class);
        player = new Player(bufferedReader, printStream);
    }


    @Test
    public void shouldCallReadLineWhenGrabbingPlayersMove() throws IOException {
        player.getPlayersMove();

        verify(bufferedReader).readLine();
    }


    @Test
    public void shouldReturnOneWhenGettingUserInput() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");

        int move = player.getPlayersMove();

        assertThat(move, is(1));
    }

    @Test
    public void shouldPrintMessageToUserWhenGrabbingUserInput(){
        player.getPlayersMove();

        verify(printStream).print("Please enter a position between 1 and 9: ");
    }



}