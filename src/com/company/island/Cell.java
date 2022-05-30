package com.company.island;

import com.company.animal.Animal;
import com.company.config.Config;


import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Cell {
    private final Island island;

    public Island getIsland() {
        return island;
    }

    private final AtomicInteger x = new AtomicInteger();
    private final AtomicInteger y = new AtomicInteger();
    private CopyOnWriteArrayList<Animal> animals;
    private  AtomicInteger plant =   new AtomicInteger();

    public Cell(Island island, int x, int y, int plant) {
        this.island = island;
        this.x.set(x);
        this.y.set(y);
        this.plant.set(Math.min(plant, Config.NUMBER_OF_PLANTS));
    }

    public AtomicInteger getX() {
        return x;
    }

    public AtomicInteger getY() {
        return y;
    }

    public CopyOnWriteArrayList<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(CopyOnWriteArrayList<Animal> animals) {
        this.animals = animals;
    }

    public AtomicInteger getPlant() {
        return plant;
    }

    public void setPlant(int plant) {
        if (plant < 0) {
            plant = 0;
        }
        this.plant.set(Math.min(plant, Config.NUMBER_OF_PLANTS));
    }
}
