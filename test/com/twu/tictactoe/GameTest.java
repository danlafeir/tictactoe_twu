package com.twu.tictactoe;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;

/**
 * Created by dlafeir on 6/18/15.
 */
public class GameTest {

    private Game game;
    private Board board;
    private Player player1;
    private Player player2;

    @Before
    public void setup(){
        player1 = mock(Player.class);
        player2 = mock(Player.class);
        board = mock(Board.class);
        game = new Game(board, player1, player2);
    }

    @Test
    public void shouldCallPrintBoardWhenSettingUpGame(){
        game.setupGame();

        verify(board).printBoard();
    }

    @Test
    public void shouldCallGetPlayersMoveFromPlayer1WhenPlayingTheGame(){
        game.play();

        verify(player1).getPlayersMove();
    }

    @Test
    public void shouldCallGetPlayersMoveFromPlayer2WhenPlayingTheGame(){
        game.play();

        verify(player2).getPlayersMove();
    }

    @Test
    public void shouldUseNumberTwoInPutMoveOnBoardWhenPlayerInputIsTwo(){
        when(board.checkIfMoveIsValid(anyInt())).thenReturn(true);
        when(player1.getPlayersMove()).thenReturn(2);

        game.play();

        verify(board).putMoveOnBoard(2, 'X');
    }

    @Test
    public void shouldUseNumberThreeInPutMoveOnBoardWhenPlayerInputIsThree(){
        when(board.checkIfMoveIsValid(anyInt())).thenReturn(true);
        when(player1.getPlayersMove()).thenReturn(3);

        game.play();

        verify(board).putMoveOnBoard(3, 'X');
    }

    @Test
    public void shouldUseAOWhenPlayerTwoMakesAMove(){
        when(board.checkIfMoveIsValid(anyInt())).thenReturn(true);
        when(player1.getPlayersMove()).thenReturn(1);
        when(player2.getPlayersMove()).thenReturn(3);

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
        when(player1.getPlayersMove()).thenReturn(1);

        game.playerMove(player1, 'X');

        verify(board).checkIfMoveIsValid(1);
    }

    @Test
    public void shouldCheckIfMoveIsValidWithWhenPlayerOneChoosesTwo(){
        when(board.checkIfMoveIsValid(anyInt())).thenReturn(true);
        when(player1.getPlayersMove()).thenReturn(2);

        game.playerMove(player1, 'X');

        verify(board).checkIfMoveIsValid(2);
    }

    @Test
    public void shouldCallPutMoveOnBoardOnceWhenAMoveIsInvalid(){
        when(player1.getPlayersMove()).thenReturn(2).thenReturn(3);
        when(board.checkIfMoveIsValid(anyInt())).thenReturn(false).thenReturn(true);

        game.playerMove(player1, 'X');

        verify(board, times(1)).putMoveOnBoard(3,'X');
    }

    @Test
    public void shouldPrintBoardOnceWhenAMoveIsInvalid(){
        when(player1.getPlayersMove()).thenReturn(2);
        when(board.checkIfMoveIsValid(2)).thenReturn(true);

        game.playerMove(player1, 'X');

        verify(board, times(1)).printBoard();
    }

    @Test
    public void shouldCallIsFullOnTheBoardWhenPlaying() {
        game.play();

        verify(board).isFull();
    }


}