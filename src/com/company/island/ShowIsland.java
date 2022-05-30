package com.company.island;


import com.company.config.Config;
import com.company.animal.predator.*;
import com.company.animal.herbivore.*;
import java.util.stream.Collectors;

public class ShowIsland {


    public static void show(Island island) throws NoSuchFieldException, IllegalAccessException {

        System.out.printf("%s - %d, %s - %d, %s - %d, %s - %d, %s - %d, " +
                        " %s - %d, %s - %d, %s - %d, %s - %d, %s - %d, " +
                        "%s - %d, %s - %d, %s - %d, %s - %d, %s - %d, %s - %d \n",
                Config.BEAR, Bear.number.get(),
                Config.WOLF, Wolf.number.get(),
                Config.BOA, Boa.number.get(),
                Config.FOX, Fox.number.get(),
                Config.EAGLE, Eagle.number.get(),
                Config.BOAR, Boar.number.get(),
                Config.BUFFALO, Buffalo.number.get(),
                Config.CATERPILLAR, Caterpillar.number.get(),
                Config.DEER, Deer.number.get(),
                Config.DUCK, Duck.number.get(),
                Config.GOAT, Goat.number.get(),
                Config.HORSE, Horse.number.get(),
                Config.MOUSE, Mouse.number.get(),
                Config.RABBIT, Rabbit.number.get(),
                Config.SHEEP, Sheep.number.get(),
                Config.PLANT,  Island.numberOfPlants.get());


        String world = island.getCells().stream()
                .flatMap(cell -> cell.getAnimals().stream()
                        .map(animal -> animal.icon)
                        .distinct())
                .collect(Collectors.joining(""));
        System.out.println(world);
    }
}



