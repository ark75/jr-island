package com.company;

import com.company.config.Config;
import com.company.island.Island;
import com.company.island.LifeCycle;
import com.company.island.ShowIsland;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Game {
    public static void main(String[] args) {
        Island island = new Island(Config.SIZE_X, Config.SIZE_Y);
        try {
             ShowIsland.show(island);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        LifeCycle task3 = new LifeCycle(island);
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        ScheduledFuture<?> lifeCycle = executor.scheduleAtFixedRate(task3, 0, Config.taktInMillies, TimeUnit.MILLISECONDS);

        while(true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (Config.conditionOfGameOver()) {
                System.out.println("Game Over");
                executor.shutdownNow();
                System.exit(0);
            }
        }
    }
}
