package ua.serfer;


import ua.serfer.contol.GameController;
import ua.serfer.model.Player;
import ua.serfer.view.ConsoleView;


import java.util.Scanner;


public class Main {
    private final static int NUMBER_PLAYERS = 2;
    private static boolean theFirstGame = true;

    public static void main(String[] args) {
        ConsoleView view;
        GameController gameController;
        Player[] players = null;

        view =  new ConsoleView(NUMBER_PLAYERS);
        gameController = new GameController(view);
        gameController.startGame();
    }


}
