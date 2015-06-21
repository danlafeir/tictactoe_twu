package com.twu.tictactoe;


public class Game {

    private Board board;
    private IOParsingAndPrinting IOParsingAndPrinting1;
    private IOParsingAndPrinting IOParsingAndPrinting2;
    private int currentMove;

    public Game(Board board, IOParsingAndPrinting IOParsingAndPrinting1, IOParsingAndPrinting IOParsingAndPrinting2) {
        this.board = board;
        this.IOParsingAndPrinting1 = IOParsingAndPrinting1;
        this.IOParsingAndPrinting2 = IOParsingAndPrinting2;
    }

    public void setupGame() {
        board.printBoard();
    }

    public void play() {
        playerMove(IOParsingAndPrinting1, 'X');
        while(board.isFull() == false){
            playerMove(IOParsingAndPrinting2, 'O');
            playerMove(IOParsingAndPrinting1, 'X');
        }
    }

    public void playerMove(IOParsingAndPrinting IOParsingAndPrinting, char symbol) {
        currentMove = IOParsingAndPrinting.getPlayersMove("");
        while(board.checkIfMoveIsValid(currentMove) == false){
            currentMove = IOParsingAndPrinting.getPlayersMove("");
        }
        board.putMoveOnBoard(currentMove, symbol);
        board.printBoard();
    }
}
