package com.tan_ds.animallist;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tan-DS on 5/18/2017.
 */

public class AnimalGenerator {


    public static final List<Animal> provadeAnimal(){

        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Вася", "Кот", 10));
        animals.add(new Animal("Рекс", "Собака", 8));
        animals.add(new Animal("Хлоя", "Хомячок", 5));
        animals.add(new Animal("Маруся", "Собака", 11));
        animals.add(new Animal("Лариса", "Кот", 18));
        animals.add(new Animal("Петя", "Попугай", 4));
        animals.add(new Animal("Ваня", "Ленивец", 21));
        animals.add(new Animal("Маша", "Кошка", 14));
        animals.add(new Animal("Саня", "Петух", 6));
        return animals;

    }



}

