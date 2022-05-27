package com.company.island;


import com.company.animal.Animal;
import com.company.config.Config;
import com.company.config.Types;
import com.company.animal.herbivore.*;
import com.company.animal.predator.*;


import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class God {
    public static CopyOnWriteArrayList<Cell> createWorld(Island island, int x, int y) {
        CopyOnWriteArrayList<Cell> world = new CopyOnWriteArrayList<>();
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                Cell cell = new Cell(island, i, j, Config.NUMBER_OF_PLANTS);
                cell.setAnimals(createAnimalsOnCell(cell));
                world.add(cell);
            }
        }
        return world;
    }

    public static CopyOnWriteArrayList<Animal> createAnimalsOnCell(Cell cell) {
               CopyOnWriteArrayList<Animal> animals = new CopyOnWriteArrayList<>();
        for (int i = 0; i < Types.values().length; i++) {
            int numberOfAnimalsOnCell =  godWill((int) Config.characteristics[i][1]); //какое-то число, не более максимально возможного
            for (int j = 0; j < numberOfAnimalsOnCell; j++) {
                animals.add(createAnimal(i, cell));
            }
        }
        return animals;
    }

    public static Animal createAnimal(int typeOfAnimal, Cell cell) {
        switch (typeOfAnimal) {
            case 0 -> {
                return new Wolf(cell, //Cell position,
                        Config.characteristics[typeOfAnimal][Config.codeOfSatiety], //double satiety
                        Config.characteristics[typeOfAnimal][Config.codeOfVelocity],//  double velocity
                        Config.characteristics[typeOfAnimal][Config.codeOfCompleteFoodWeight],// double completeFoodWeight
                        Config.characteristics[typeOfAnimal][Config.codeOfNumberOfCubs],// double numberOfCubs
                        Config.WOLF);//String icon
            }
            case 1 -> {
                return new Boa(cell, //Cell position,
                        Config.characteristics[typeOfAnimal][Config.codeOfSatiety], //double satiety
                        Config.characteristics[typeOfAnimal][Config.codeOfVelocity],//  double velocity
                        Config.characteristics[typeOfAnimal][Config.codeOfCompleteFoodWeight],// double completeFoodWeight
                        Config.characteristics[typeOfAnimal][Config.codeOfNumberOfCubs],// double numberOfCubs
                        Config.BOA);//String icon
            }
            case 2 -> {
                return new Fox(cell,
                        Config.characteristics[typeOfAnimal][Config.codeOfSatiety], //double satiety
                        Config.characteristics[typeOfAnimal][Config.codeOfVelocity],//  double velocity
                        Config.characteristics[typeOfAnimal][Config.codeOfCompleteFoodWeight],// double completeFoodWeight
                        Config.characteristics[typeOfAnimal][Config.codeOfNumberOfCubs],// double numberOfCubs
                        Config.FOX);//String icon
            }
            case 3 -> {
                return new Bear(cell,
                        Config.characteristics[typeOfAnimal][Config.codeOfSatiety], //double satiety
                        Config.characteristics[typeOfAnimal][Config.codeOfVelocity],//  double velocity
                        Config.characteristics[typeOfAnimal][Config.codeOfCompleteFoodWeight],// double completeFoodWeight
                        Config.characteristics[typeOfAnimal][Config.codeOfNumberOfCubs],// double numberOfCubs
                        Config.BEAR);//String icon
            }
            case 4 -> {
                return new Eagle(cell,
                        Config.characteristics[typeOfAnimal][Config.codeOfSatiety], //double satiety
                        Config.characteristics[typeOfAnimal][Config.codeOfVelocity],//  double velocity
                        Config.characteristics[typeOfAnimal][Config.codeOfCompleteFoodWeight],// double completeFoodWeight
                        Config.characteristics[typeOfAnimal][Config.codeOfNumberOfCubs],// double numberOfCubs
                        Config.EAGLE);//String icon
            }
            case 5 -> {
                return new Horse(cell,
                        Config.characteristics[typeOfAnimal][Config.codeOfSatiety], //double satiety
                        Config.characteristics[typeOfAnimal][Config.codeOfVelocity],//  double velocity
                        Config.characteristics[typeOfAnimal][Config.codeOfCompleteFoodWeight],// double completeFoodWeight
                        Config.characteristics[typeOfAnimal][Config.codeOfNumberOfCubs],// double numberOfCubs
                        Config.HORSE);//String icon
            }
            case 6 -> {
                return new Deer(cell,
                        Config.characteristics[typeOfAnimal][Config.codeOfSatiety], //double satiety
                        Config.characteristics[typeOfAnimal][Config.codeOfVelocity],//  double velocity
                        Config.characteristics[typeOfAnimal][Config.codeOfCompleteFoodWeight],// double completeFoodWeight
                        Config.characteristics[typeOfAnimal][Config.codeOfNumberOfCubs],// double numberOfCubs
                        Config.DEER);//String icon
            }
            case 7 -> {
                return new Rabbit(cell,
                        Config.characteristics[typeOfAnimal][Config.codeOfSatiety], //double satiety
                        Config.characteristics[typeOfAnimal][Config.codeOfVelocity],//  double velocity
                        Config.characteristics[typeOfAnimal][Config.codeOfCompleteFoodWeight],// double completeFoodWeight
                        Config.characteristics[typeOfAnimal][Config.codeOfNumberOfCubs],// double numberOfCubs
                        Config.RABBIT);//String icon
            }
            case 8 -> {
                return new Mouse(cell,
                        Config.characteristics[typeOfAnimal][Config.codeOfSatiety], //double satiety
                        Config.characteristics[typeOfAnimal][Config.codeOfVelocity],//  double velocity
                        Config.characteristics[typeOfAnimal][Config.codeOfCompleteFoodWeight],// double completeFoodWeight
                        Config.characteristics[typeOfAnimal][Config.codeOfNumberOfCubs],// double numberOfCubs
                        Config.MOUSE);//String icon
            }
            case 9 -> {
                return new Goat(cell,
                        Config.characteristics[typeOfAnimal][Config.codeOfSatiety], //double satiety
                        Config.characteristics[typeOfAnimal][Config.codeOfVelocity],//  double velocity
                        Config.characteristics[typeOfAnimal][Config.codeOfCompleteFoodWeight],// double completeFoodWeight
                        Config.characteristics[typeOfAnimal][Config.codeOfNumberOfCubs],// double numberOfCubs
                        Config.GOAT);//String icon
            }
            case 10 -> {
                return new Sheep(cell,
                        Config.characteristics[typeOfAnimal][Config.codeOfSatiety], //double satiety
                        Config.characteristics[typeOfAnimal][Config.codeOfVelocity],//  double velocity
                        Config.characteristics[typeOfAnimal][Config.codeOfCompleteFoodWeight],// double completeFoodWeight
                        Config.characteristics[typeOfAnimal][Config.codeOfNumberOfCubs],// double numberOfCubs
                        Config.SHEEP);//String icon
            }
            case 11 -> {
                return new Boar(cell,
                        Config.characteristics[typeOfAnimal][Config.codeOfSatiety], //double satiety
                        Config.characteristics[typeOfAnimal][Config.codeOfVelocity],//  double velocity
                        Config.characteristics[typeOfAnimal][Config.codeOfCompleteFoodWeight],// double completeFoodWeight
                        Config.characteristics[typeOfAnimal][Config.codeOfNumberOfCubs],// double numberOfCubs
                        Config.BOAR);//String icon
            }
            case 12 -> {
                return new Buffalo(cell,
                        Config.characteristics[typeOfAnimal][Config.codeOfSatiety], //double satiety
                        Config.characteristics[typeOfAnimal][Config.codeOfVelocity],//  double velocity
                        Config.characteristics[typeOfAnimal][Config.codeOfCompleteFoodWeight],// double completeFoodWeight
                        Config.characteristics[typeOfAnimal][Config.codeOfNumberOfCubs],// double numberOfCubs
                        Config.BUFFALO);//String icon
            }
            case 13 -> {
                return new Duck(cell,
                        Config.characteristics[typeOfAnimal][Config.codeOfSatiety], //double satiety
                        Config.characteristics[typeOfAnimal][Config.codeOfVelocity],//  double velocity
                        Config.characteristics[typeOfAnimal][Config.codeOfCompleteFoodWeight],// double completeFoodWeight
                        Config.characteristics[typeOfAnimal][Config.codeOfNumberOfCubs],// double numberOfCubs
                        Config.DUCK);//String icon
            }
            case 14 -> {
                return new Caterpillar(cell,
                        Config.characteristics[typeOfAnimal][Config.codeOfSatiety], //double satiety
                        Config.characteristics[typeOfAnimal][Config.codeOfVelocity],//  double velocity
                        Config.characteristics[typeOfAnimal][Config.codeOfCompleteFoodWeight],// double completeFoodWeight
                        Config.characteristics[typeOfAnimal][Config.codeOfNumberOfCubs],// double numberOfCubs
                        Config.CATERPILLAR);//String icon;
            }
        }
        return null;
    }

    public static int godWill(int number) {
        return ThreadLocalRandom.current().nextInt(0,  number);
    }
    public static int numberOfClass(String name) {
        for (Types nameOfClass : Types.values()) {
            if (Objects.equals(nameOfClass.toString(), name)) {
                return nameOfClass.ordinal();
            }
        }
        return 0;
    }
}
