package com.twu.tictactoe;

/**
 * Created by dlafeir on 6/18/15.
 */
public class Game {

    private Board board;
    private Player player1;
    private Player player2;
    private int currentMove;

    public Game(Board board, Player player1, Player player2) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
    }

    public void setupGame() {
        board.printBoard();
    }

    public void play() {
        playerMove(player1,'X');
        playerMove(player2, 'O');
    }

    public void playerMove(Player player, char symbol) {
        currentMove = player.getPlayersMove();
        if(board.checkIfMoveIsValid(currentMove)){
            board.putMoveOnBoard(currentMove, symbol);
            board.printBoard();
        }
    }
}
