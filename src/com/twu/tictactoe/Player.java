package com.twu.tictactoe;

public class Player {
    private IOParsingAndPrinting io;
    private Board board;

    public Player(IOParsingAndPrinting io, Board board) {
        this.io = io;
        this.board = board;
    }

    public void move() {
        int currentMove = io.getPlayersMove("Player 1");
        board.mark(currentMove, "X");
    }
}
