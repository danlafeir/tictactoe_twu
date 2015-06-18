package com.twu.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by dlafeir on 6/18/15.
 */
public class Player {

    private BufferedReader bufferedReader;
    private PrintStream printStream;

    public Player(BufferedReader bufferedReader, PrintStream printStream) {
        this.bufferedReader = bufferedReader;
        this.printStream = printStream;
    }

    public int getPlayersMove() {
        printStream.print("Please enter a position between 1 and 9: ");
        int move = 0;
        try {
            move = Integer.parseInt(bufferedReader.readLine());
        }
        catch (NumberFormatException e){}
        catch (IOException e) {}

        return move;
    }
}
