package pl.wsiz.java.model;


import java.util.ArrayList;

import pl.wsiz.java.contol.ShipsFabric;
import pl.wsiz.statki.GoodPosition;
import pl.wsiz.statki.Kratka;
import pl.wsiz.statki.ShipLine;


public class Board {
    public static final String X = "X";
    public static final int defaultSizeBoard = 13;
    private static final String KEY = "_";
    public String[][] layout;
    public Ship[] sheaps;
    private int[][] shipsCordinats;
    private TypePlayers type;

    public Board(TypePlayers type, ArrayList<ShipLine>kratki) {
        shipsCordinats = new int[defaultSizeBoard][defaultSizeBoard];
        this.type = type;
        sheaps = new Ship[10];
        ShipsFabric.creatSheaps(sheaps, type, shipsCordinats, kratki);

    }

    public int[][] getShipsCordinats() {
        return shipsCordinats;
    }








































    public  int[][] viewEvilDebugNormal() {
        int[][] goodField = new int[10][10];
        int[][] shipsFilds = new int[10][10];
        for (int i = 1; i < 11; i++) {

           for (int j = 1; j < 11; j++) {
                goodField[i - 1][j - 1] = shipsCordinats[i][j];
            }

        }
        for (int i = 1; i < 11; i++) {

            for (int j = 1; j < 11; j++) {
                if(goodField[i - 1][j - 1] == 1) {
                    shipsFilds[i - 1][j - 1] = goodField[i - 1][j - 1];
                }
            }

        }
        return goodField;
    }

    public ArrayList<GoodPosition> viewEvilDebugNormal2() {
        ArrayList<GoodPosition>goodPositions = new ArrayList<>();


        for (int i = 0; i < 13; i++) {

            for (int j = 0; j < 13; j++) {

                if (shipsCordinats[i][j] == 1) {
                    GoodPosition goodPosition = new GoodPosition(i - 1, j - 1);
                    goodPositions.add(goodPosition);
                }
            }

        }

        return goodPositions;
    }
}

