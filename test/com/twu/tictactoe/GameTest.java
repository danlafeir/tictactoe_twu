package com.twu.tictactoe;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

/**
 * Created by dlafeir on 6/18/15.
 */
public class GameTest {

    private Game game;
    private Board board;
    private IOParsingAndPrinting IOParsingAndPrinting1;
    private IOParsingAndPrinting IOParsingAndPrinting2;

    @Before
    public void setup(){
        IOParsingAndPrinting1 = mock(IOParsingAndPrinting.class);
        IOParsingAndPrinting2 = mock(IOParsingAndPrinting.class);
        board = mock(Board.class);
        game = new Game(board, IOParsingAndPrinting1, IOParsingAndPrinting2);
    }

    @Test
    public void shouldCallPrintBoardWhenSettingUpGame(){
        game.setupGame();

        verify(board).printBoard();
    }

    @Test
    public void shouldCallGetPlayersMoveFromPlayer1WhenPlayingTheGame(){
        game.play();

        verify(IOParsingAndPrinting1).getPlayersMove("");
    }

    @Test
    public void shouldCallGetPlayersMoveFromPlayer2WhenPlayingTheGame(){
        game.play();

        verify(IOParsingAndPrinting2).getPlayersMove("");
    }

    @Test
    public void shouldPrintTheBoardTwiceWhenPlayingTheGame(){
        game.play();

        verify(board, times(2)).printBoard();
    }

    @Test
    public void shouldCheckIfMoveIsValidWithWhenPlayerOneChoosesOne(){
        when(board.checkIfMoveIsValid(anyInt())).thenReturn(true);
        when(IOParsingAndPrinting1.getPlayersMove("")).thenReturn(1);

        game.playerMove(IOParsingAndPrinting1, 'X');

        verify(board).checkIfMoveIsValid(1);
    }

    @Test
    public void shouldCheckIfMoveIsValidWithWhenPlayerOneChoosesTwo(){
        when(board.checkIfMoveIsValid(anyInt())).thenReturn(true);
        when(IOParsingAndPrinting1.getPlayersMove("")).thenReturn(2);

        game.playerMove(IOParsingAndPrinting1, 'X');

        verify(board).checkIfMoveIsValid(2);
    }



    @Test
    public void shouldPrintBoardOnceWhenAMoveIsInvalid(){
        when(IOParsingAndPrinting1.getPlayersMove("")).thenReturn(2);
        when(board.checkIfMoveIsValid(2)).thenReturn(true);

        game.playerMove(IOParsingAndPrinting1, 'X');

        verify(board, times(1)).printBoard();
    }

    @Test
    public void shouldCallIsFullOnTheBoardWhenPlaying() {
        game.play();

        verify(board).isFull();
    }


}