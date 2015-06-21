package com.twu.tictactoe;

public class Player {
    private String name;
    private String symbol;
    private IOParsingAndPrinting io;
    private Board board;

    public Player(String name, String symbol, IOParsingAndPrinting io, Board board) {
        this.name = name;
        this.symbol = symbol;
        this.io = io;
        this.board = board;
    }

    public void move() {
        int currentMove = io.getPlayersMoveAtCorrectArrayIndex(this.name);
        while(!board.isMoveValid(currentMove)){
            io.println("Location already taken");
            currentMove = io.getPlayersMoveAtCorrectArrayIndex(this.name);
        }
        board.mark(currentMove, this.symbol);
    }
}
