package com.company.animal;


import com.company.config.Config;
import com.company.island.Cell;
import com.company.island.God;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public abstract class Animal {


    public double velocity;
    public AtomicInteger completeFoodWeight = new AtomicInteger();
    public Cell position;

    private AtomicReference<Double> satiety = new AtomicReference<>();

    public double numberOfCubs;
    public String icon;
    public double weight;

    private AtomicBoolean isMoved;

    public AtomicBoolean isMoved() {
        return isMoved;
    }

    public void setMoved(boolean moved) {
        isMoved.set(moved);
    }

    public abstract void eat();

    public abstract AtomicInteger getNumber();


    public void die() throws NoSuchFieldException, IllegalAccessException {
        getNumber().decrementAndGet();
        position.getAnimals().removeIf(s -> s == this);
    }


    public void move() {
        int tempX = this.position.getX().get();
        int tempY = this.position.getY().get();
        for (int i = 0; i <= (int) this.velocity; i++) {
            int direction = God.godWill(5);
            switch (direction) {
                case 1 -> {
                    tempY = tempY + 1;
                    tempY = Math.min(tempY, Config.SIZE_Y);
                }
                case 2 -> {
                    tempX = tempX + 1;
                    tempX = Math.min(tempX, Config.SIZE_X);
                }
                case 3 -> {
                    tempY = tempY - 1;
                    if (tempY < 0) {
                        tempY = 0;
                    }
                }
                case 4 -> {
                    tempX = tempX - 1;
                    if (tempX < 0) {
                        tempX = 0;
                    }
                }
                default -> {
                }
            }
        }
        int finalTempX = tempX;
        int finalTempY = tempY;


        this.position = this.position.getIsland().getCells().stream()
                .filter(cell -> cell.getX().get() == finalTempX && cell.getY().get() == finalTempY)
                .toList().get(0);
        this.setMoved(true);
        this.checkMaxNumber();
    }

    public void multiply() {

        boolean possibilityToMultiply = this.position.getAnimals().stream()
                .map((animal -> animal.getClass().getSimpleName()))
                .anyMatch(s -> s.equals(this.getClass().getSimpleName()));
        if (possibilityToMultiply) {
            int numberOnCell = this.position.getAnimals().stream()
                    .filter(s -> s.getClass().equals(this.getClass()))
                    .toList()
                    .size();
            int typeOfAnimal = God.numberOfClass(this.getClass().getSimpleName());
            int maxNumberOnCell = (int) Config.characteristics[typeOfAnimal][1];
            if (numberOnCell <= maxNumberOnCell - this.numberOfCubs) {
                CopyOnWriteArrayList<Animal> animalsToAdd = new CopyOnWriteArrayList<>();
                for (int i = 0; i < this.numberOfCubs; i++) {
                    animalsToAdd.add(God.createAnimal(typeOfAnimal, this.position));
                }
                animalsToAdd.addAll(this.position.getAnimals());
                this.position.setAnimals(animalsToAdd);
            }
        }
    }

    public void checkMaxNumber() {
        int numberOnCell = this.position.getAnimals().stream()
                .filter(s -> s.getClass().equals(this.getClass()))
                .toList()
                .size();
        int typeOfAnimal = God.numberOfClass(this.getClass().getSimpleName());
        if (numberOnCell >= Config.characteristics[typeOfAnimal][1]) {
            try {
                this.die();
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public AtomicReference<Double> getSatiety() {
        return satiety;
    }

    public void setSatiety(Double satiety) {
        this.satiety.set(satiety);
    }
}






