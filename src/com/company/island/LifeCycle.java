package com.company.island;


import com.company.animal.Animal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class LifeCycle implements Runnable {
    private final Island island;
    public static AtomicInteger cycles = new AtomicInteger(0) ;

    public LifeCycle(Island island) {
        this.island = island;
    }

    @Override
    public void run() {
        cycles.incrementAndGet();
        System.out.println("Шаг - " + cycles);
        GrowPlant.growPlants(island);
        commandEat();
        commandClearIsMoved();
        commandMove();
        commandMultiply();
        countPlant();

        try {
            ShowIsland.show(island);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private void commandMultiply() {
        ExecutorService service = Executors.newCachedThreadPool();
        service.submit(() -> {
            for (Cell cell : island.getCells()) {
                for (Animal animal : cell.getAnimals()) {
                    animal.multiply();
                }
            }
        });
    }

    private void commandMove() {

        ExecutorService service = Executors.newCachedThreadPool();
        service.submit(() -> {
            for (Cell cell : island.getCells()) {
                for (Animal animal : cell.getAnimals()) {
                    if (!animal.isMoved().get()) {
                        animal.move();
                    }
                }
            }
        });
    }

    private void commandClearIsMoved() {

        ExecutorService service = Executors.newCachedThreadPool();
        service.submit(() -> {
            for (Cell cell : island.getCells()) {
                for (Animal animal : cell.getAnimals()) {
                    animal.setMoved(false);
                }
            }
        });
    }

    private void commandEat() {
        ExecutorService service = Executors.newCachedThreadPool();
        service.submit(() -> {
            for (Cell cell : island.getCells()) {
                for (Animal animal : cell.getAnimals()) {
                    animal.eat();
                }
            }
        });
    }
    private void countPlant() {
        ExecutorService service = Executors.newCachedThreadPool();
        service.submit(() -> {
            Island.numberOfPlants.set(0);
            for (Cell cell : island.getCells()) {
                Island.numberOfPlants.getAndAdd(cell.getPlant().get());
            }
        });
    }
}

