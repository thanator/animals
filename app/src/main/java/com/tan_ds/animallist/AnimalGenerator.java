package com.tan_ds.animallist;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tan-DS on 5/18/2017.
 */

public class AnimalGenerator {


    public static final List<AnimalClass> provadeAnimal(){

        List<AnimalClass> animals = new ArrayList<>();
        animals.add(new AnimalClass("Вася", "Кот", 10));
        animals.add(new AnimalClass("Рекс", "Собака", 8));
        animals.add(new AnimalClass("Хлоя", "Хомячок", 5));
        animals.add(new AnimalClass("Маруся", "Собака", 11));
        animals.add(new AnimalClass("Лариса", "Кот", 18));
        animals.add(new AnimalClass("Петя", "Попугай", 4));
        animals.add(new AnimalClass("Ваня", "Ленивец", 21));
        animals.add(new AnimalClass("Маша", "Кошка", 14));
        animals.add(new AnimalClass("Саня", "Петух", 6));
        return animals;

    }



}

