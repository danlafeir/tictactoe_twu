package com.twu.tictactoe;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by dlafeir on 6/18/15.
 */
public class PlayerTest {

    @Test
    public void shouldCallReadLineWhenGrabbingPlayersMove() throws IOException {
        BufferedReader bufferedReader = mock(BufferedReader.class);
        Player player = new Player(bufferedReader);

        player.getPlayersMove();

        verify(bufferedReader).readLine();
    }


    @Test
    public void shouldReturnOnemWhenGettingUserInput() throws IOException {
        BufferedReader bufferedReader = mock(BufferedReader.class);
        Player player = new Player(bufferedReader);

        int move = player.getPlayersMove();

        assertThat(move, is(1));
    }



}