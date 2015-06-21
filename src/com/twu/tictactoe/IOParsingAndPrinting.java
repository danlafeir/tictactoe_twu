package com.twu.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class IOParsingAndPrinting {

    public static final int ARRAY_OFFSET_CORRECTION = 1;
    private BufferedReader bufferedReader;
    private PrintStream printStream;

    public IOParsingAndPrinting(BufferedReader bufferedReader, PrintStream printStream) {
        this.bufferedReader = bufferedReader;
        this.printStream = printStream;
    }

    public int getPlayersMoveAtCorrectArrayIndex(String playerName) {
        String inputMessage = playerName + " please enter a position between 1 and 9: ";
        printStream.print(inputMessage);
        int move = 0;
        try {
            move = Integer.parseInt(bufferedReader.readLine());
        }
        catch (NumberFormatException e){}
        catch (IOException e) {}

        return move-ARRAY_OFFSET_CORRECTION;
    }

}
