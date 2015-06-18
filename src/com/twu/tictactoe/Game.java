package com.twu.tictactoe;

import java.util.List;

/**
 * Created by dlafeir on 6/18/15.
 */
public class Game {

    private Board board;
    private List<Player> players;

    public Game(Board board, List<Player> players) {
        this.board = board;
        this.players = players;
    }

    public void setupGame() {
        board.printBoard();
    }


    public void play() {
    }
}
