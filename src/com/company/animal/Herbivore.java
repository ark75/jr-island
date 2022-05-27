package com.company.animal;

import com.company.animal.Animal;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class Herbivore extends Animal {

    public void eat() {
        if (position.getPlant().get() > this.completeFoodWeight.get()) {
            position.setPlant(((int) (position.getPlant().get() - this.completeFoodWeight.get())));
            setSatiety(getSatiety().get()+completeFoodWeight.get());
        }
    }

    @Override
    public AtomicInteger getNumber() {
        return getNumber();
    }

}
