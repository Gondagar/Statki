package ua.serfer.view;

import ua.serfer.model.Board;
import ua.serfer.model.Player;
import ua.serfer.model.Point;
import ua.serfer.model.TypePlayers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import static java.lang.System.out;


/**
 * Created by serfer on 05.03.18.
 */
public class ConsoleView implements View {
    Random rnd = new Random();

    private Player[] players;

    @Override
    public void view(Board board) {
        for (int i = 0; i <= 10; i++) {

            for (int j = 0; j <= 22; j++) {
                out.printf("%3s", board.layout[i][j]);
            }

            System.out.println("");
        }
        System.out.println();
    }

    public ConsoleView(int quantityPlayers) {


        players = new Player[quantityPlayers];


    }

    public ConsoleView(Player[] players) {
        this.players = players;
    }

    //
    @Override
    public void viewEvilDebug(Board board) {
        for (int i = 0; i < 13; i++) {

            for (int j = 0; j < 13; j++) {
                out.printf("%3s", board.getShipsCordinats()[i][j]);
            }
            System.out.println("");
        }
        System.out.println();
    }




    @Override
    public void viewEvilFiels(Board Fiels) {

    }


    @Override
    public Point getPoint(TypePlayers typePlayers) {
        int x = 0, y = 0;

            x = 1 + rnd.nextInt(10);
            y = 1 + rnd.nextInt(10);
            System.out.println("AI Komputer atakuje współrzędne " + x + "-" + y);
            return new Point(x, y);

    }


    @Override
    public boolean checkCoordinate(int data) {
        if (data > 10 | data < 1) {
            System.out.print("Wprowadzono nieprawidłowe dane ");
            return false;
        } else {
            return true;
        }
    }


    @Override
    public Player[] getPlayers() {
        return players;
    }
}
