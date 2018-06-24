package ua.serfer.view;

import ua.serfer.model.Board;
import ua.serfer.model.Player;
import ua.serfer.model.Point;
import ua.serfer.model.TypePlayers;

/**
 * Created by serfer on 27.03.16.
 */
public interface View {

    void view(Board board);

    void viewEvilDebug(Board board);

    void viewEvilFiels(Board Fiels);

    Point getPoint(TypePlayers typePlayers);

    boolean checkCoordinate(int data);

    Player[] getPlayers();
}
