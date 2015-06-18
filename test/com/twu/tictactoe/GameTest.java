package com.twu.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
    public void shouldCallGetUserInputFromPlayer1WhenPlayingTheGame(){
        game.play();

        verify(player1).getPlayersMove();
    }

    @Test
    public void shouldPlaceAMoveOneABoardWhenPlayingGame(){
        game.play();

        verify(board).putMoveOnBoard(anyInt());
    }

    @Test
    public void shouldUseNumberTwoInPutMoveOnBoardWhenPlayerInputIsTwo(){
        when(player1.getPlayersMove()).thenReturn(2);

        game.play();

        verify(board).putMoveOnBoard(2);
    }

    @Test
    public void shouldUseNumberThreeInPutMoveOnBoardWhenPlayerInputIsThree(){
        when(player1.getPlayersMove()).thenReturn(3);

        game.play();

        verify(board).putMoveOnBoard(3);
    }


}