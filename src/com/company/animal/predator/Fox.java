package com.company.animal.predator;

import com.company.config.Config;
import com.company.island.Cell;
import com.company.animal.Predator;

import java.util.concurrent.atomic.AtomicInteger;

public class Fox extends Predator {
    public static AtomicInteger number = new AtomicInteger(0);

    public Fox(Cell position, double satiety, double velocity, double completeFoodWeight, double numberOfCubs, String icon) {

        this.position = position;
        this.weight = satiety; //Первоначально вес и сытость одинаковая
        this.setSatiety(satiety);
        this.velocity = velocity;
        this.completeFoodWeight.set((int) completeFoodWeight);
        this.numberOfCubs = numberOfCubs;
        this.icon = Config.FOX;
        number.incrementAndGet();
    }

    @Override
    public AtomicInteger getNumber() {
        return number;
    }
}
