package com.company.island;

public class GrowPlant  {
    public Island island;

    public GrowPlant(Island island) {
        this.island = island;
    }

    public static void growPlants(Island island) {
        for (Cell cell : island.cells) {
            cell.setPlant(cell.getPlant().get() * 2);
        }
    }

}
