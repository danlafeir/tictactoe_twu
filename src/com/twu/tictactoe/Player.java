package com.twu.tictactoe;

public class Player {
    private IOParsingAndPrinting io;

    public Player(IOParsingAndPrinting io, Board board) {
        this.io = io;
    }

    public void move() {
        io.getPlayersMove("Player 1");

    }
}
