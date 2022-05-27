package com.company.animal.herbivore;

import com.company.config.Config;
import com.company.island.Cell;
import com.company.animal.Herbivore;

import java.util.concurrent.atomic.AtomicInteger;

public class Duck extends Herbivore {
    public static AtomicInteger number = new AtomicInteger(0);

    public Duck(Cell position, double satiety, double velocity, double completeFoodWeight, double numberOfCubs, String icon) {

        this.weight = satiety; //Первоначально вес и сытость одинаковая
        this.position = position;
        this.setSatiety(satiety);
        this.velocity = velocity;
        this.completeFoodWeight.set((int) completeFoodWeight);
        this.numberOfCubs = numberOfCubs;
        this.icon = Config.DUCK;
        number.incrementAndGet();
    }

    @Override
    public AtomicInteger getNumber() {
        return number;
    }
}
