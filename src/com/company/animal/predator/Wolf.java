package com.company.animal.predator;

import com.company.config.Config;
import com.company.island.Cell;
import com.company.animal.Predator;

import java.util.concurrent.atomic.AtomicInteger;

public class Wolf extends Predator {
    public static AtomicInteger number = new AtomicInteger(0);

    public Wolf(Cell position, double satiety, double velocity, double completeFoodWeight, double numberOfCubs, String icon) {

        this.setSatiety(satiety);
        this.weight = satiety; //Первоначально вес и сытость одинаковая
        this.velocity = velocity;
        this.completeFoodWeight.set((int) completeFoodWeight);
        this.position = position;
        this.numberOfCubs = numberOfCubs;
        this.icon = Config.WOLF;
        number.incrementAndGet();
    }

    @Override
    public AtomicInteger getNumber() {
        return number;
    }
}
