package pl.wsiz.java.contol;


import java.util.ArrayList;

import pl.wsiz.java.model.Ship;
import pl.wsiz.java.model.TypePlayers;
import pl.wsiz.statki.Kratka;
import pl.wsiz.statki.ShipLine;


public class ShipsFabric {

   public static void creatSheaps(Ship[] sheaps, TypePlayers typePlayers, int[][] massCordCheack, ArrayList<ShipLine>kratkasArray) {


        sheaps[0] = new Ship(4, typePlayers, massCordCheack, kratkasArray);
        sheaps[1] = new Ship(3, typePlayers, massCordCheack, kratkasArray);
        sheaps[2] = new Ship(3, typePlayers, massCordCheack, kratkasArray);
        sheaps[3] = new Ship(2, typePlayers, massCordCheack, kratkasArray);
        sheaps[4] = new Ship(2, typePlayers, massCordCheack, kratkasArray);
        sheaps[5] = new Ship(2, typePlayers, massCordCheack, kratkasArray);
        sheaps[6] = new Ship(1, typePlayers, massCordCheack, kratkasArray);
        sheaps[7] = new Ship(1, typePlayers, massCordCheack, kratkasArray);
        sheaps[8] = new Ship(1, typePlayers, massCordCheack, kratkasArray);
        sheaps[9] = new Ship(1, typePlayers, massCordCheack, kratkasArray);


    }
}
