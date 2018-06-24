package pl.wsiz.java.model;


import java.util.ArrayList;
import java.util.Scanner;

import pl.wsiz.statki.Kratka;
import pl.wsiz.statki.ShipLine;

/**
 * Created by serfer on 05.03.16.
 */
public class Player {

    private static int attemptsAll;
    private final String name;
    private final Board board;
    TypePlayers type;
    private int countDMG;
    private int attempts;
    private Scanner scanner = new Scanner(System.in);


    public Player(String name, TypePlayers type, ArrayList<ShipLine>kratkas) {
        this.name = name;
        this.type = type;
        this.board = new Board(type, kratkas);
    }

    public static int getAttemptsAll() {
        return attemptsAll;
    }

    public static void setAttemptsAll(int attemptsAll) {
        Player.attemptsAll++;
    }

    public String getName() {
        return name;
    }

    public Board getBoard() {
        return board;
    }

    public TypePlayers getType() {
        return type;
    }

    public void incrementCountDmg() {
        countDMG++;
    }

    public int getCountDMG() {
        return countDMG;
    }

    public void incrementCountAttemts() {
        attempts++;
    }

    public int getAttempts() {
        return attempts;
    }


}
