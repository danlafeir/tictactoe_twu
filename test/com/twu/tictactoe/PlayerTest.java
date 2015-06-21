package com.twu.tictactoe;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class PlayerTest {

    private IOParsingAndPrinting io;
    private Player player;
    private Board board;

    @Before
    public void setup(){
        io = mock(IOParsingAndPrinting.class);
        board = mock(Board.class);
        player = new Player(io,board);
    }

    @Test
    public void shouldCallGetPlayerMoveWhenPlayerMakesAMove(){
        player.move();

        verify(io).getPlayersMove("Player 1");
    }

    @Test
    public void shouldMarkXOnBoardInCellOneWhenPlayerInputIsOne(){
        when(io.getPlayersMove("Player 1")).thenReturn(1);

        player.move();

        verify(board).mark(1, "X");
    }

    @Test
    public void shouldMarkXOnBoardInCellFourWhenPlayerInputIsFour(){
        when(io.getPlayersMove("Player 1")).thenReturn(4);

        player.move();

        verify(board).mark(4, "X");
    }


}