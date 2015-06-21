package com.twu.tictactoe;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class PlayerTest {

    public static final String PLAYER_NAME = "Player 1";
    public static final String PLAYER_SYMBOL = "X";
    private IOParsingAndPrinting io;
    private Player player;
    private Board board;

    @Before
    public void setup(){
        io = mock(IOParsingAndPrinting.class);
        board = mock(Board.class);
        player = new Player(PLAYER_NAME, PLAYER_SYMBOL, io,board);
    }

    @Test
    public void shouldCallGetPlayerMoveWhenPlayerMakesAMove(){
        player.move();

        verify(io).getPlayersMoveAtCorrectArrayIndex(PLAYER_NAME);
    }

    @Test
    public void shouldMarkXOnBoardInCellOneWhenPlayerInputIsOne(){
        when(io.getPlayersMoveAtCorrectArrayIndex(PLAYER_NAME)).thenReturn(1);

        player.move();

        verify(board).mark(1, "X");
    }

    @Test
    public void shouldMarkXOnBoardInCellFourWhenPlayerInputIsFour(){
        when(io.getPlayersMoveAtCorrectArrayIndex(PLAYER_NAME)).thenReturn(4);

        player.move();

        verify(board).mark(4, "X");
    }

    @Test
    public void shouldMarkOInCellOneWhenPlayerWithThatSymbolMakesAMove(){
        Player player2 = new Player("Player 2","O",io,board);
        when(io.getPlayersMoveAtCorrectArrayIndex("Player 2")).thenReturn(4);
        when(board.isMoveValid(2)).thenReturn(true);

        player2.move();

        verify(board).mark(4, "O");
    }

    @Test
    public void shouldMarkBoardOnSecondAttemptWhenGettingInputThatIsAlreadyTakenFirst(){
        when(io.getPlayersMoveAtCorrectArrayIndex(PLAYER_NAME)).thenReturn(1).thenReturn(2);
        when(board.isMoveValid(1)).thenReturn(false);
        when(board.isMoveValid(2)).thenReturn(true);

        player.move();

        verify(board).mark(2, PLAYER_SYMBOL);
    }

    @Test
    public void shouldPrintMessageWhenMoveIsInvalid(){
        when(io.getPlayersMoveAtCorrectArrayIndex(PLAYER_NAME)).thenReturn(1).thenReturn(2);
        when(board.isMoveValid(1)).thenReturn(false);
        when(board.isMoveValid(2)).thenReturn(true);

        player.move();

        verify(io).println("Location already taken");
    }
}