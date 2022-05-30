package com.company.animal;

import com.company.config.Config;
import com.company.island.God;
public abstract class Predator extends Animal {


    public void eat() {
        int choice =  God.godWill(position.getAnimals().size());
        Animal choiceVictim = position.getAnimals().get(choice);
        int eat = God.godWill(100) - (Config.possibilityOfEat[God.numberOfClass(
                this.getClass().getSimpleName())][God.numberOfClass(choiceVictim
                .getClass().getSimpleName())]);
        if (eat < 50) {
            try {
                choiceVictim.die();
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
            setSatiety(getSatiety().get() + choiceVictim.getSatiety().get());
        }

    }




}
