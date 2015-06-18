package com.twu.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by dlafeir on 6/18/15.
 */
public class Player {

    private String name;
    private BufferedReader bufferedReader;
    private PrintStream printStream;

    public Player(String name, BufferedReader bufferedReader, PrintStream printStream) {
        this.name = name;
        this.bufferedReader = bufferedReader;
        this.printStream = printStream;
    }

    public int getPlayersMove() {
        String inputMessage = name + " please enter a position between 1 and 9: ";
        printStream.print(inputMessage);
        int move = 0;
        try {
            move = Integer.parseInt(bufferedReader.readLine());
        }
        catch (NumberFormatException e){}
        catch (IOException e) {}

        return move;
    }

}
