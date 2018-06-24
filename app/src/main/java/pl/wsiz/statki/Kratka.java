package pl.wsiz.statki;

public class Kratka {
    int liczba;
    int litera;
    public boolean isShip;
    boolean striliana = false;

    public Kratka(int liczba, int litera) {
        this.liczba = liczba;
        this.litera = litera;
    }

    public void setShip(boolean ship) {
        isShip = ship;
    }

    public int getLiczba() {
        return liczba;
    }

    public int getLitera() {
        return litera;
    }

    public boolean isShip() {
        return isShip;
    }
}
