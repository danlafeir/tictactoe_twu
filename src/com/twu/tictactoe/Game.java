package com.twu.tictactoe;


public class Game {

    private Board board;
    private IOParsingAndPrinting IOParsingAndPrinting1;
    private IOParsingAndPrinting IOParsingAndPrinting2;

    public Game(Board board, IOParsingAndPrinting IOParsingAndPrinting1, IOParsingAndPrinting IOParsingAndPrinting2) {
        this.board = board;
        this.IOParsingAndPrinting1 = IOParsingAndPrinting1;
        this.IOParsingAndPrinting2 = IOParsingAndPrinting2;
    }

    public void setupGame() {
        board.print();
    }

    public void play() {
        playerMove(IOParsingAndPrinting1, 'X');
        while(board.isFull() == false){
            playerMove(IOParsingAndPrinting2, 'O');
            playerMove(IOParsingAndPrinting1, 'X');
        }
    }

    private void playerMove(IOParsingAndPrinting ioParsingAndPrinting1, char x) {
    }

}
