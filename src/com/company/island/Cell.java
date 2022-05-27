package com.company.island;

import com.company.animal.Animal;
import com.company.config.Config;


import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Cell {
    private Island island;

    public Island getIsland() {
        return island;
    }

    private AtomicInteger x = new AtomicInteger();
    private AtomicInteger y = new AtomicInteger();
    private CopyOnWriteArrayList<Animal> animals;
    private AtomicInteger plant =   new AtomicInteger();

    public Cell(Island island, int x, int y, int plant) {
        this.island = island;
        this.x.set(x);
        this.y.set(y);
        this.plant.set(Math.min(plant, Config.NUMBER_OF_PLANTS));
    }

    public AtomicInteger getX() {
        return x;
    }

    public void setX(int x) {
        this.x.set(Math.min((x<0)?0:x, Config.SIZE_X));
    }

    public AtomicInteger getY() {
        return y;
    }

    public void setY(int y) {

        this.y.set(Math.min((y<0)?0:y, Config.SIZE_Y));

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
