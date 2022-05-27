package com.company.island;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Island {
    public CopyOnWriteArrayList<Cell> cells;
    public static AtomicInteger numberOfPlants = new AtomicInteger(0);
    public CopyOnWriteArrayList<Cell> getCells() {
        return cells;
    }
    public Island(int sizeX, int sizeY) {
        cells = God.createWorld(this, sizeX, sizeY);
    }
}
