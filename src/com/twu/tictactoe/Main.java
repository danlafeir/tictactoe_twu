package com.twu.tictactoe;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by dlafeir on 6/18/15.
 */
public class Main {
    public static void main(String[] args) {


        Board board = new Board(System.out);
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(in);
        Player player1 = new Player(bufferedReader, System.out);
        Player player2 = new Player(bufferedReader, System.out);

        Game game = new Game(board,player1,player2);
        game.setupGame();
        game.play();
    }
}
