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
    public void shouldUseNumberTwoInPutMoveOnBoardWhenPlayerInputIsTwo(){
        when(board.checkIfMoveIsValid(anyInt())).thenReturn(true);
        when(IOParsingAndPrinting1.getPlayersMove("")).thenReturn(2);

        game.play();

        verify(board).putMoveOnBoard(2, 'X');
    }

    @Test
    public void shouldUseNumberThreeInPutMoveOnBoardWhenPlayerInputIsThree(){
        when(board.checkIfMoveIsValid(anyInt())).thenReturn(true);
        when(IOParsingAndPrinting1.getPlayersMove("")).thenReturn(3);

        game.play();

        verify(board).putMoveOnBoard(3, 'X');
    }

    @Test
    public void shouldUseAOWhenPlayerTwoMakesAMove(){
        when(board.checkIfMoveIsValid(anyInt())).thenReturn(true);
        when(IOParsingAndPrinting1.getPlayersMove("")).thenReturn(1);
        when(IOParsingAndPrinting2.getPlayersMove("")).thenReturn(3);

        game.play();

        verify(board).putMoveOnBoard(1, 'X');
        verify(board).putMoveOnBoard(3, 'O');
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
    public void shouldCallPutMoveOnBoardOnceWhenAMoveIsInvalid(){
        when(IOParsingAndPrinting1.getPlayersMove("")).thenReturn(2).thenReturn(3);
        when(board.checkIfMoveIsValid(anyInt())).thenReturn(false).thenReturn(true);

        game.playerMove(IOParsingAndPrinting1, 'X');

        verify(board, times(1)).putMoveOnBoard(3,'X');
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