package ua.serfer.contol;


import ua.serfer.model.Board;
import ua.serfer.model.Player;
import ua.serfer.model.Point;
import ua.serfer.model.Ship;
import ua.serfer.view.ConsoleView;
import ua.serfer.view.View;


public class GameController {


    ConsoleView view;
    private boolean cheacker = true;


    public GameController(ConsoleView view) {
        this.view = view;
    }

    public void startGame() {
        Player humen = view.getPlayers()[0];
        Player ai = view.getPlayers()[1];
        System.out.println("Start........");
        do {

            view.view(humen.getBoard());
            if (Ship.DEBUG) {
                view.viewEvilDebug(humen.getBoard());
                view.view(ai.getBoard());
            }
            playGame(ai, humen, view.getPoint(humen.getType()));
            if (humen.getCountDMG() == 20) break;
            playGame(humen, ai, view.getPoint(ai.getType()));

        } while (cheacker);
    }

    private void playGame(Player evil, Player we, Point point) {

        int xRef = point.getX();
        int yRef = point.getY();
        we.incrementCountAttemts();
        if (Board.X.equals(evil.getBoard().layout[xRef][yRef])) {
            evil.getBoard().layout[xRef][yRef] = "*";
            System.out.println(we.getName() + " (" + we.getType() + ") " + "trafił!!! :)");

            we.getBoard().layout[xRef][yRef + 12] = "x";
            we.incrementCountDmg();

        } else {
            if (!"x".equals(we.getBoard().layout[xRef][yRef + 12]))
                we.getBoard().layout[xRef][yRef + 12] = "*";

        }


        if (we.getCountDMG() == 20) {
            showWinner(we);
            view.viewEvilFiels(evil.getBoard());
            cheacker = false;

        }
        System.out.println();
        System.out.println();


    }


    private void showWinner(Player gemer) {
        System.out.println("\n\n\n******************************************************************\n");
        System.out.println(gemer.getName() + " wygrał\\ła. Ilość prób " + gemer.getAttempts() + "\n\n");

    }


}
