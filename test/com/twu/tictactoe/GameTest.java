package com.twu.tictactoe;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

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
        board = mock(Board.class);
        player1 = mock(Player.class);
        player2 = mock(Player.class);
        game = new Game(board, player1, player2);
    }

    @Test
    public void shouldCallPrintBoardWhenPlayingTheGame(){
        game.play();

        verify(board).print();
    }

    @Test
    public void shouldCallPlayerOneMoveWhenPlayingTheGame(){
        game.play();

        verify(player1).move();
    }

    @Test
    public void shouldCallPlayerTwoMoveWhenPlayingTheGame(){
        game.play();

        verify(player2).move();
    }



}