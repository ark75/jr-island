package com.company.animal;

public abstract class Herbivore extends Animal {

    public void eat() {
        if (position.getPlant().get() > this.completeFoodWeight.get()) {
            position.setPlant(( (position.getPlant().get() - this.completeFoodWeight.get())));
            setSatiety(getSatiety().get()+completeFoodWeight.get());
        }
    }



}
