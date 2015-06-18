package com.twu.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by dlafeir on 6/18/15.
 */
public class Player {

    private BufferedReader bufferedReader;

    public Player(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public int getPlayersMove() {
        int move = 0;
        try {
            move = Integer.parseInt(bufferedReader.readLine());
        }
        catch (NumberFormatException e){
        }
        catch (IOException e) {
        }

        return move;
    }
}
