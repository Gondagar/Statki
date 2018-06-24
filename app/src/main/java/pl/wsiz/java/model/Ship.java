package pl.wsiz.java.model;

import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

import pl.wsiz.statki.Kratka;
import pl.wsiz.statki.ShipLine;

public class Ship {

    public static final boolean DEBUG = true; // Debug
    int x1, x2, x3, x4, y1, y2, y3, y4;
    private boolean check = true;

    public Ship(int x, TypePlayers typePlayers, int[][] cordI, ArrayList<ShipLine>shipLineArrayListArray) {
        Random rnd = new Random();
        x1 = 1 + rnd.nextInt(10);
        y1 = 2 + rnd.nextInt(10);
        if(y1 > 10){
            y1 = 10;
        }
        switch (x) {
            case 4:
                if (x1 < 8) {
                    x2 = x1 + 1;
                    x3 = x2 + 1;
                    x4 = x3 + 1;
                    y4 = y3 = y2 = y1;
                    // Коодинаты кораблей
                    cordI[x1][y1] = 1;
                    cordI[x2][y2] = 1;
                    cordI[x3][y3] = 1;
                    cordI[x4][y4] = 1;

                  /*  for(int i = 0; i<shipLineArrayListArray.size(); i++){
                        if(shipLineArrayListArray.get(i).getLiczba() == x1 && shipLineArrayListArray.get(i).getLitera() == y1)
                        {
                            shipLineArrayListArray.get(i).setShip(true);
                            Log.i("Korabel", "" + shipLineArrayListArray.get(i).getLiczba()  + " " + shipLineArrayListArray.get(i).getLitera());
                        }
                        if(shipLineArrayListArray.get(i).getLiczba() == x2 && shipLineArrayListArray.get(i).getLitera() == y2){
                            shipLineArrayListArray.get(i).setShip(true);
                            Log.i("Korabel", "" + shipLineArrayListArray.get(i).getLiczba()  + " " + shipLineArrayListArray.get(i).getLitera());
                        }
                        if(shipLineArrayListArray.get(i).getLiczba() == x3 && shipLineArrayListArray.get(i).getLitera() == y3){
                            shipLineArrayListArray.get(i).setShip(true);
                            Log.i("Korabel", "" + shipLineArrayListArray.get(i).getLiczba()  + " " + shipLineArrayListArray.get(i).getLitera());
                        }
                        if(shipLineArrayListArray.get(i).getLiczba() == x4 && shipLineArrayListArray.get(i).getLitera() == y4){
                            shipLineArrayListArray.get(i).setShip(true);
                            Log.i("Korabel", "" + shipLineArrayListArray.get(i).getLiczba()  + " " + shipLineArrayListArray.get(i).getLitera());
                            Log.i("Korabel", "" + x1  + " " + y1);
                            Log.i("Korabel", "" + x2  + " " + y2);
                            Log.i("Korabel", "" + x3  + " " + y3);
                            Log.i("Korabel", "" + x4  + " " + y4);

                        }
                    }
*/
                    Kratka kratka1 = shipLineArrayListArray.get(x1).kratkiArray.get(y1);
                    kratka1.isShip = true;
                    Kratka kratka2 = shipLineArrayListArray.get(x2).kratkiArray.get(y2);
                    kratka2.isShip = true;
                    Kratka kratka3 = shipLineArrayListArray.get(x3).kratkiArray.get(y3 );
                    kratka3.isShip = true;
                    Kratka kratka4 = shipLineArrayListArray.get(x4 ).kratkiArray.get(y4 );
                    kratka4.isShip = true;



                    cordI[x1 - 1][y1 - 1] = 4;
                    cordI[x1][y1 - 1] = 4;
                    cordI[x2][y1 - 1] = 4;
                    cordI[x3][y1 - 1] = 4;
                    cordI[x4][y1 - 1] = 4;
                    cordI[x4 + 1][y1 - 1] = 4;
                    cordI[x4 + 1][y1] = 4;
                    cordI[x4 + 1][y1 + 1] = 4;
                    cordI[x4][y1 + 1] = 4;
                    cordI[x3][y1 + 1] = 4;
                    cordI[x2][y1 + 1] = 4;
                    cordI[x1][y1 + 1] = 4;
                    cordI[x1 - 1][y1 + 1] = 4;
                    cordI[x1 - 1][y1] = 4;

                } else if (x1 >= 8) {
                    if (y1 > 7) {
                        x4 = x3 = x2 = x1;
                        y1 = y1 - 3;
                        y2 = y1 + 1;
                        y3 = y2 + 1;
                        y3 = y3 + 1;
                        // Координаты корабля
                        cordI[x1][y1] = 1;
                        cordI[x2][y2] = 1;
                        cordI[x3][y3] = 1;
                        cordI[x4][y4] = 1;

                        Kratka kratka1 = shipLineArrayListArray.get(x1 ).kratkiArray.get(y1 );
                        kratka1.isShip = true;
                        Kratka kratka2 = shipLineArrayListArray.get(x2 ).kratkiArray.get(y2 );
                        kratka2.isShip = true;
                        Kratka kratka3 = shipLineArrayListArray.get(x3 ).kratkiArray.get(y3 );
                        kratka3.isShip = true;
                        Kratka kratka4 = shipLineArrayListArray.get(x4 ).kratkiArray.get(y4);
                        kratka4.isShip = true;

                        // Координата алиаса)
                        cordI[x1 - 1][y1 - 1] = 4;
                        cordI[x1][y1 - 1] = 4;
                        cordI[x1 + 1][y1 - 1] = 4;
                        cordI[x1 + 1][y1] = 4;
                        cordI[x2 + 1][y2] = 4;
                        cordI[x3 + 1][y3] = 4;
                        cordI[x4 + 1][y4] = 4;
                        cordI[x4 + 1][y4 + 1] = 4;
                        cordI[x4][y4 + 1] = 4;
                        cordI[x4 - 1][y4 + 1] = 4;
                        cordI[x4 - 1][y4] = 4;
                        cordI[x3 - 1][y3] = 4;
                        cordI[x1 - 1][y2] = 4;
                        cordI[x1 - 1][y1] = 4;

                    }
                    if (y1 < 8) {
                        x4 = x3 = x2 = x1;
                        y2 = y1 + 1;
                        y3 = y2 + 1;
                        y4 = y3 + 1;
                        // Координаты корабля
                        cordI[x1][y1] = 1;
                        cordI[x2][y2] = 1;
                        cordI[x3][y3] = 1;
                        cordI[x4][y4] = 1;

                        Kratka kratka1 = shipLineArrayListArray.get(x1 ).kratkiArray.get(y1 );
                        kratka1.isShip = true;
                        Kratka kratka2 = shipLineArrayListArray.get(x2 ).kratkiArray.get(y2 );
                        kratka2.isShip = true;
                        Kratka kratka3 = shipLineArrayListArray.get(x3 ).kratkiArray.get(y3 );
                        kratka3.isShip = true;
                        Kratka kratka4 = shipLineArrayListArray.get(x4 ).kratkiArray.get(y4 );
                        kratka4.isShip = true;

                        // Координата алиаса)   
                        cordI[x1 - 1][y1 - 1] = 4;
                        cordI[x1][y1 - 1] = 4;
                        cordI[x1 + 1][y1 - 1] = 4;
                        cordI[x1 + 1][y1] = 4;
                        cordI[x2 + 1][y2] = 4;
                        cordI[x3 + 1][y3] = 4;
                        cordI[x4 + 1][y4] = 4;
                        cordI[x4 + 1][y4 + 1] = 4;
                        cordI[x4][y4 + 1] = 4;
                        cordI[x4 - 1][y4 + 1] = 4;
                        cordI[x4 - 1][y4] = 4;
                        cordI[x3 - 1][y3] = 4;
                        cordI[x1 - 1][y2] = 4;
                        cordI[x1 - 1][y1] = 4;
                    }
                }
                debugShow(x, typePlayers);
                break;

            case 3:
                do {
                    if (cordI[x1][y1] == 0) {
                        if (typePlayers.equals(TypePlayers.Humen) & DEBUG)
                            System.out.println("Попали в пустую  начальную коодинату " + x1 + "-" + y1 + ". Пытаемся проложить от нее все палубы корабля. ");

                        if (y1 <= 8) {   // По горизонтали
                            y2 = y1 + 1;
                            y3 = y2 + 1;
                            x3 = x2 = x1;
                            if (cordI[x2][y2] == 0 & cordI[x3][y3] == 0) {
                                if (typePlayers.equals(TypePlayers.Humen) & DEBUG)
                                    System.out.println("По оси Y на месте теоритических палоб   пусто. Кораблю виделяеться даное пространнство и создаеться алиас.");

                                // Координаты корабля
                                cordI[x1][y1] = 1;
                                cordI[x1][y2] = 1;
                                cordI[x1][y3] = 1;

                                Kratka kratka1 = shipLineArrayListArray.get(x1 ).kratkiArray.get(y1 );
                                kratka1.isShip = true;
                                Kratka kratka2 = shipLineArrayListArray.get(x2 ).kratkiArray.get(y2 );
                                kratka2.isShip = true;
                                Kratka kratka3 = shipLineArrayListArray.get(x3 ).kratkiArray.get(y3 );
                                kratka3.isShip = true;



//  // Координата алиаса)                             
                                cordI[x1 - 1][y1 - 1] = 3;
                                cordI[x1][y1 - 1] = 3;
                                cordI[x1 + 1][y1 - 1] = 3;
                                cordI[x1 + 1][y1] = 3;
                                cordI[x1 + 1][y2] = 3;
                                cordI[x1 + 1][y3] = 3;
                                cordI[x1 - 1][y1] = 3;
                                cordI[x1 - 1][y2] = 3;
                                cordI[x1 - 1][y3] = 3;
                                cordI[x3 - 1][y3 + 1] = 3;
                                cordI[x3][y3 + 1] = 3;
                                cordI[x3 + 1][y3 + 1] = 3;
// вывод коодтнат корабля                            
                                debugShow(x, typePlayers);
                                // Выход с главного цикла. Это значит что завершаеться работа конструктора и создаеться обьект который возращенться в вызывающий класс где и записываеться в масив
                                check = false;
                            } else {
                                if (typePlayers.equals(TypePlayers.Humen) & DEBUG)
                                    System.out.println("Корабли не смог найти себе здесь места. Получаем новые корды");
                                x1 = 1 + rnd.nextInt(10);
                                y1 = 1 + rnd.nextInt(10);
                                continue;

                            }


                        } else if (y1 > 8) { // по  вертекали с верху в низ.

                            if (x1 <= 8) {
                                x2 = x1 + 1;
                                x3 = x2 + 1;
                                y3 = y2 = y1;
                                if (cordI[x2][y2] == 0 & cordI[x3][y3] == 0) {
                                    if (typePlayers.equals(TypePlayers.Humen) & DEBUG)
                                        System.out.println("По оси X на месте теоритических палоб   пусто. Кораблю виделяеться даное пространнство и создаеться алиас.");

                                    // Координаты корабля
                                    cordI[x1][y1] = 1;
                                    cordI[x2][y2] = 1;
                                    cordI[x3][y3] = 1;

                                    Kratka kratka1 = shipLineArrayListArray.get(x1 ).kratkiArray.get(y1 );
                                    kratka1.isShip = true;
                                    Kratka kratka2 = shipLineArrayListArray.get(x2 ).kratkiArray.get(y2 );
                                    kratka2.isShip = true;
                                    Kratka kratka3 = shipLineArrayListArray.get(x3 ).kratkiArray.get(y3 );
                                    kratka3.isShip = true;

                                    // Координата алиаса)
                                    cordI[x1 - 1][y1 - 1] = 3;
                                    cordI[x1 - 1][y1 + 1] = 3;
                                    cordI[x1 - 1][y1] = 3;
                                    cordI[x1][y1 - 1] = 3;
                                    cordI[x1][y1 + 1] = 3;
                                    cordI[x2][y2 + 1] = 3;
                                    cordI[x2][y2 - 1] = 3;
                                    cordI[x3][y3 - 1] = 3;
                                    cordI[x3][y3 + 1] = 3;
                                    cordI[x3 + 1][y1 - 1] = 3;
                                    cordI[x3 + 1][y1 + 1] = 3;
                                    cordI[x3 + 1][y1] = 3;

                                    debugShow(x, typePlayers);
                                    check = false;
                                } else {
                                    if (typePlayers.equals(TypePlayers.Humen) & DEBUG)
                                        System.out.println("Корабли не смог найти себе здесь места. Получаем новые корды");
                                    x1 = 1 + rnd.nextInt(10);
                                    y1 = 1 + rnd.nextInt(10);
                                    continue;
                                }
                            } else if (x1 > 8) { // по вертикали  c низу вверх. Произведена смена координат для сходста при создании алиаса.
                                x1 = x1 - 2;
                                x2 = x1 + 1;
                                x3 = x2 + 1;
                                y3 = y2 = y1;

                                if (cordI[x1][y1] == 0 & cordI[x2][y2] == 0 & cordI[x3][y3] == 0) // Производиться доп роверка x1 в виду его смещения и возмлжных багов.
                                {  // если смещение удачное то сюда упадет корабли
                                    if (typePlayers.equals(TypePlayers.Humen) & DEBUG) {
                                        System.out.println("По оси X на месте теоритических палоб   пусто. Кораблю виделяеться даное пространнство и создаеться алиас.");
                                        System.out.println("Корабля можно поставить тут!)");
                                    }
                                    cordI[x1][y1] = 1;
                                    cordI[x2][y2] = 1;
                                    cordI[x3][y3] = 1;

                                    Kratka kratka1 = shipLineArrayListArray.get(x1 ).kratkiArray.get(y1 );
                                    kratka1.isShip = true;
                                    Kratka kratka2 = shipLineArrayListArray.get(x2 ).kratkiArray.get(y2 );
                                    kratka2.isShip = true;
                                    Kratka kratka3 = shipLineArrayListArray.get(x3 ).kratkiArray.get(y3 );
                                    kratka3.isShip = true;

                                    cordI[x1 - 1][y1 - 1] = 3;
                                    cordI[x1 - 1][y1 + 1] = 3;
                                    cordI[x1 - 1][y1] = 3;
                                    cordI[x1][y1 - 1] = 3;
                                    cordI[x1][y1 + 1] = 3;
                                    cordI[x2][y2 - 1] = 3;
                                    cordI[x2][y2 + 1] = 3;
                                    cordI[x3][y3 - 1] = 3;
                                    cordI[x3][y3 + 1] = 3;
                                    cordI[x3 + 1][y1 - 1] = 3;
                                    cordI[x3 + 1][y1 + 1] = 3;
                                    cordI[x3 + 1][y1] = 3;

                                    debugShow(x, typePlayers);
                                    check = false;

                                } else  // Так как в данном условии в низ идти то уже нет куда. А в верх не вышло так как таму уже занято идем на рандом.
                                {
                                    if (typePlayers.equals(TypePlayers.Humen) & DEBUG)
                                        System.out.println("Корабли не смог найти себе здесь места. В какую сторону мы его не пробовали развернуть с этой начальной координаты");
                                    x1 = 1 + rnd.nextInt(10);
                                    y1 = 1 + rnd.nextInt(10);
                                    continue; // получаем новые корды
                                }
                            }
                        }
                    } else {
                        if (typePlayers.equals(TypePlayers.Humen) & DEBUG)
                            System.out.println("Попали в занятую клетку. (" + x1 + "-" + y1 + "). Рандомим новые корды");
                        x1 = 1 + rnd.nextInt(10);
                        y1 = 1 + rnd.nextInt(10);
                        continue;
                    }
                } while (check);
                break;
            case 2:
                do {
                    if (cordI[x1][y1] == 0) {
                        if (typePlayers.equals(TypePlayers.Humen) & DEBUG)
                            System.out.println("Попали в пустую  начальную коодинату " + x1 + "-" + y1 + ". Пытаемся проложить от нее все палубы корабля. ");

                        if (y1 <= 9) {   // По горизонтали
                            y2 = y1 + 1;
                            x2 = x1;
                            if (cordI[x2][y2] == 0) {
                                if (typePlayers.equals(TypePlayers.Humen) & DEBUG)
                                    System.out.println("По оси Y на месте теоритических палоб   пусто. Кораблю виделяеться даное пространнство и создаеться алиас.");

                                // Координаты корабля
                                cordI[x1][y1] = 1;
                                cordI[x2][y2] = 1;

                                Kratka kratka1 = shipLineArrayListArray.get(x1 ).kratkiArray.get(y1 );
                                kratka1.isShip = true;
                                Kratka kratka2 = shipLineArrayListArray.get(x2 ).kratkiArray.get(y2 );
                                kratka2.isShip = true;

//  // Координата алиаса)                             
                                cordI[x1 - 1][y1 - 1] = 2;
                                cordI[x1][y1 - 1] = 2;
                                cordI[x1 + 1][y1 - 1] = 2;
                                cordI[x1 + 1][y1] = 2;
                                cordI[x2 + 1][y2] = 2;
                                cordI[x1 - 1][y1] = 2;
                                cordI[x2 - 1][y2] = 2;
                                cordI[x2 - 1][y2 + 1] = 2;
                                cordI[x2][y2 + 1] = 2;
                                cordI[x2 + 1][y2 + 1] = 2;
// вывод коодтнат корабля                            
                                debugShow(x, typePlayers);
                                // Выход с главного цикла. Это значит что завершаеться работа конструктора и создаеться обьект который возращенться в вызывающий класс где и записываеться в масив
                                check = false;
                            } else {
                                if (typePlayers.equals(TypePlayers.Humen) & DEBUG)
                                   // System.out.println("Корабли не смог найти себе здесь места. Получаем новые корды");
                                x1 = 1 + rnd.nextInt(10);
                                y1 = 1 + rnd.nextInt(10);
                                continue;

                            }


                        } else if (y1 > 9) { // по  вертекали с верху в низ.

                            if (x1 <= 9) {
                                x2 = x1 + 1;
                                y2 = y1;
                                if (cordI[x2][y2] == 0) {
                                    if (typePlayers.equals(TypePlayers.Humen) & DEBUG)
                                       // System.out.println("По оси X на месте теоритических палоб   пусто. Кораблю виделяеться даное пространнство и создаеться алиас.");

                                    // Координаты корабля
                                    cordI[x1][y1] = 1;
                                    cordI[x2][y2] = 1;

                                    Kratka kratka1 = shipLineArrayListArray.get(x1 ).kratkiArray.get(y1 );
                                    kratka1.isShip = true;
                                    Kratka kratka2 = shipLineArrayListArray.get(x2 - 1).kratkiArray.get(y2);
                                    kratka2.isShip = true;
                                    // Координата алиаса)
                                    cordI[x1 - 1][y1 - 1] = 2;
                                    cordI[x1 - 1][y1 + 1] = 2;
                                    cordI[x1 - 1][y1] = 2;
                                    cordI[x1][y1 - 1] = 2;
                                    cordI[x1][y1 + 1] = 2;
                                    cordI[x2][y2 - 1] = 2;
                                    cordI[x2][y2 + 1] = 2;
                                    cordI[x2 + 1][y1 - 1] = 2;
                                    cordI[x2 + 1][y1 + 1] = 2;
                                    cordI[x2 + 1][y1] = 2;

                                    debugShow(x, typePlayers);
                                    check = false;
                                } else {
                                    if (typePlayers.equals(TypePlayers.Humen) & DEBUG)
                                        System.out.println("Корабли не смог найти себе здесь места. Получаем новые корды");
                                    x1 = 1 + rnd.nextInt(10);
                                    y1 = 1 + rnd.nextInt(10);
                                    continue;
                                }
                            } else if (x1 > 9) { // по вертикали  c низу вверх. Произведена смена координат для сходста при создании алиаса.
                                x1 = x1 - 2;
                                x2 = x1 + 1;
                                y2 = y1;

                                if (cordI[x1][y1] == 0 & cordI[x2][y2] == 0) // Производиться доп роверка x1 в виду его смещения и возмлжных багов.
                                {  // если смещение удачное то сюда упадет корабли
                                    if (typePlayers.equals(TypePlayers.Humen) & DEBUG) {
                                        System.out.println("По оси X на месте теоритических палоб   пусто. Кораблю виделяеться даное пространнство и создаеться алиас.");
                                        System.out.println("Корабля можно поставить тут!)");
                                    }
                                    cordI[x1][y1] = 1;
                                    cordI[x2][y2] = 1;

                                    Kratka kratka1 = shipLineArrayListArray.get(x1 - 1).kratkiArray.get(y1);
                                    kratka1.isShip = true;
                                    Kratka kratka2 = shipLineArrayListArray.get(x2 - 1).kratkiArray.get(y2);
                                    kratka2.isShip = true;

                                    cordI[x1 - 1][y1 - 1] = 2;
                                    cordI[x1 - 1][y1 + 1] = 2;
                                    cordI[x1 - 1][y1] = 2;
                                    cordI[x1][y1 - 1] = 2;
                                    cordI[x1][y1 + 1] = 2;
                                    cordI[x2][y2 - 1] = 2;
                                    cordI[x2][y2 + 1] = 2;
                                    cordI[x2 + 1][y1 - 1] = 2;
                                    cordI[x2 + 1][y1 + 1] = 2;
                                    cordI[x2 + 1][y1] = 2;

                                    debugShow(x, typePlayers);
                                    check = false;

                                } else  // Так как в данном условии в низ идти то уже нет куда. А в верх не вышло так как таму уже занято идем на рандом.
                                {
                                    if (typePlayers.equals(TypePlayers.Humen) & DEBUG)
                                        System.out.println("Корабли не смог найти себе здесь места. В какую сторону мы его не пробовали развернуть с этой начальной координаты");
                                    x1 = 1 + rnd.nextInt(10);
                                    y1 = 1 + rnd.nextInt(10);
                                    continue; // получаем новые корды
                                }
                            }
                        }
                    } else {
                        if (typePlayers.equals(TypePlayers.Humen) & DEBUG)
                            System.out.println("Попали в занятую клетку. (" + x1 + "-" + y1 + "). Рандомим новые корды");
                        x1 = 1 + rnd.nextInt(10);
                        y1 = 1 + rnd.nextInt(10);
                        continue;
                    }
                } while (check);
                break;
            case 1:
                do {
                    if (cordI[x1][y1] == 0) {
                        if (typePlayers.equals(TypePlayers.Humen) & DEBUG)
                            System.out.println("Попали в пустою ячейку. Кораблю виделяеться даное пространнство Алиас пока не создан.");
                        cordI[x1][y1] = 1;

                        Kratka kratka1 = shipLineArrayListArray.get(x1).kratkiArray.get(y1);
                        kratka1.isShip = true;


                        cordI[x1 - 1][y1 - 1] = 9;
                        cordI[x1][y1 - 1] = 9;
                        cordI[x1][y1 + 1] = 9;
                        cordI[x1 + 1][y1 - 1] = 9;
                        cordI[x1 + 1][y1] = 9;
                        cordI[x1 - 1][y1] = 9;
                        cordI[x1 - 1][y1 + 1] = 9;
                        cordI[x1 + 1][y1 + 1] = 9;

                        debugShow(x, typePlayers);
                        check = false;
                    } else {
                        if (typePlayers.equals(TypePlayers.Humen) & DEBUG)
                            System.out.println("Кораблик ебанулся на колову другому. Все подумали что ну его такого нахуй и начали шаманить нового)))");
                        x1 = 1 + rnd.nextInt(10);
                        y1 = 1 + rnd.nextInt(10);
                        continue;

                    }
                } while (check);
                break;
        }

    }

    // переопределенный метод toString. Визываеться с метода SHOW с передачей количества палуб корабля. Получив количество палуб в
    // свитче формируется определенная страка для возврата в вызываемый метод show{sout(toString(x))} 
    public String toString(int x) {
        String text;
        switch (x) {
            case 4:
                text = "1-кор " + this.x1 + "-" + this.y1 + "\n2-кор " + this.x2 + "-" + this.y2 + "\n3-кор " + this.x3 + "-" + this.y3 + "\n4-кор " + this.x4 + "-" + this.y4 + "\nСледующий корабль";
                break;
            case 3:
                text = "1-кор " + this.x1 + "-" + this.y1 + "\n2-кор " + this.x2 + "-" + this.y2 + "\n3-кор " + this.x3 + "-" + this.y3 + "\nСледующий корабль";
                break;

            case 2:
                text = "1-кор " + this.x1 + "-" + this.y1 + "\n2-кор " + this.x2 + "-" + this.y2 + "\nСледующий корабль";
                break;
            case 1:
                text = "1-кор " + this.x1 + "-" + this.y1 + "\nСледующий корабль";
                break;
            default:
                text = "";
        }

        return text;
    }

    void debugShow(int x, TypePlayers typePlayers) {

        if (typePlayers.equals(TypePlayers.Humen) & DEBUG)
            System.out.println(toString(x));

    }

}
