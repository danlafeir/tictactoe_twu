package com.twu.tictactoe;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by dlafeir on 6/18/15.
 */
public class Main {
    public static void main(String[] args) {

        Board board = new Board(System.out);
        board.printBoard();
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(in);
        Player player = new Player(bufferedReader, System.out);
        player.getPlayersMove();
    }
}
