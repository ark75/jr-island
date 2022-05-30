package com.company.config;

import com.company.island.LifeCycle;

public class Config {
    public static final int SIZE_X = 100;
    public static final int SIZE_Y = 20;
    public static final int taktInMillies = 500;

    public static boolean conditionOfGameOver() {
        return LifeCycle.cycles.get() > 100;
    }
    public static final int[][] possibilityOfEat = {
            {-1, 0, 0, 0, 0, 10, 15, 60, 80, 60, 70, 15, 10, 40, 0, 0},
            {0, -1, 15, 0, 0, 0, 0, 20, 40, 0, 0, 0, 0, 10, 0, 0},
            {0, 0, -1, 0, 0, 0, 0, 70, 90, 0, 0, 0, 0, 60, 40, 0},
            {0, 80, 0, -1, 0, 40, 80, 80, 90, 70, 70, 50, 20, 10, 0, 0},
            {0, 0, 10, 0, -1, 0, 0, 90, 90, 70, 70, 0, 0, 80, 0, 0},
            {0, 0, 10, 0, 0, -1, 0, 0, 90, 90, 0, 0, 0, 0, 0, 100},
            {0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 90, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 50, 0, 0, -1, 0, 0, 90, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 90, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 100}
    };
    //Эти переменные поясняют, что означают столбцы в характеристиках класса
    public static final int codeOfSatiety = 0;
    public static final int codeOfVelocity = 2;
    public static final int codeOfCompleteFoodWeight = 3;
    public static final int codeOfNumberOfCubs = 4;

    public static final double[][] characteristics = {
        //вес, макс. число, скорость, полное насыщение, кол-во детей
            {50, 30, 3, 8, 3},    //Волк
            {15, 30, 1, 3, 2},    //Удав
            {8, 30, 2, 2, 3},     //Лиса
            {500, 5, 2, 80, 5},   //Медведь
            {6, 20, 3, 1, 2},       //Орел
            {400, 20, 4, 60, 2},    //Лошадь
            {300, 20, 4, 50, 2},    //Олень
            {2, 150, 2, .45, 5},    //Кролик
            {.05, 500, 1, .01, 5},  //Мышь
            {60, 140, 3, 10, 2},    //Коза
            {70, 140, 3, 15, 2},    //Овца
            {400, 50, 2, 50, 4},    //Кабан
            {700, 10, 3, 100, 2},   //Буйвол
            {1, 200, 4, .15, 2},    //Утка
            {.001, 1000, 0, 0, 4},  //Гусеница
            {1, 200, -1, -1, -1},    //Растения

    };

    public static final String WOLF = "\uD83D\uDC3A";
    public static final String BOA = "\uD83D\uDC0D";
    public static final String FOX = "\uD83E\uDD8A";
    public static final String BEAR = "\uD83D\uDC3B";
    public static final String EAGLE = "\uD83E\uDD85";
    public static final String HORSE = "\uD83D\uDC0E";
    public static final String DEER = "\uD83E\uDD8C";
    public static final String RABBIT = "\uD83D\uDC07";
    public static final String MOUSE = "\uD83D\uDC39";
    public static final String GOAT = "\uD83D\uDC10";
    public static final String SHEEP = "\uD83D\uDC11";
    public static final String BOAR = "\uD83D\uDC17";
    public static final String BUFFALO = "\uD83D\uDC2E";
    public static final String DUCK = "\uD83E\uDD86";
    public static final String CATERPILLAR = "\uD83D\uDC1B";
    public static final String PLANT = "\uD83C\uDF3F";
    public static final int NUMBER_OF_PLANTS = 200;

}

