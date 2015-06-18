package com.twu.tictactoe;

import java.io.BufferedReader;

/**
 * Created by dlafeir on 6/18/15.
 */
public class Player {

    private BufferedReader bufferedReader;

    public Player(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public int getPlayersMove() {

        return 1;
    }
}
