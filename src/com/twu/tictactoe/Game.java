package com.twu.tictactoe;

/**
 * Created by dlafeir on 6/18/15.
 */
public class Game {

    private Board board;
    private Player player1;
    private Player player2;

    public Game(Board board, Player player1, Player player2) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
    }

    public void setupGame() {
        board.printBoard();
    }

    public void play() {
        int move = player1.getPlayersMove();
        board.putMoveOnBoard(move);
        board.printBoard();
    }
}
