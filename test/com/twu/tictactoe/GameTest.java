package com.twu.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by dlafeir on 6/18/15.
 */
public class GameTest {

    private Game game;
    private Board board;
    private List<Player> players;

    @Before
    public void setup(){
        players = mock(List.class);
        board = mock(Board.class);
        game = new Game(board, players);
    }

    @Test
    public void shouldCallPrintBoardWhenSettingUpGame(){
        game.setupGame();

        verify(board).printBoard();
    }

    @Test
    public void shouldCallGetUserInputWhenPlayingTheGame(){
        Player player = mock(Player.class);

        game.play();

        verify(player).getPlayersMove();
    }


}