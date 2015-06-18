package com.twu.tictactoe;

import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by dlafeir on 6/18/15.
 */
public class GameTest {


    @Test
    public void shouldCallPrintBoardWhenSettingUpGame(){
        List<Player> players = mock(List.class);
        Board board = mock(Board.class);
        Game game = new Game(board, players);

        game.setupGame();

        verify(board).printBoard();
    }




}