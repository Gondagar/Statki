package pl.wsiz.statki;

import java.util.ArrayList;

public class ShipLine {
    public   ArrayList<Kratka>kratkiArray = new ArrayList<>();
    int liczba;

    public ShipLine(ArrayList<Kratka> kratkiArray, int liczba) {
        this.kratkiArray = kratkiArray;
        this.liczba = liczba;
    }
}
