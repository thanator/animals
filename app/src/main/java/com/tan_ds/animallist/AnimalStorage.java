package com.tan_ds.animallist;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Tan-DS on 5/20/2017.
 */

public class AnimalStorage {

    private List<Animal> mAnimals;
    private static final List<Animal> sOriginalAnimals;
    private final List<AnimaLaddedListmer> mListner;

    public AnimalStorage(){
        mAnimals = new ArrayList<>(sOriginalAnimals);
        mListner = new ArrayList<>();
    }

    static {
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

        sOriginalAnimals  = Collections.unmodifiableList(animals);
    }

    public List<Animal> returnAnimals(){
        Log.e("AnimStorage", "returnAnimal");
        return new ArrayList<>(mAnimals);
    }

    public void addAnimal(Animal animal){
        Log.e("AnimStorage", "addAnimal");
        mAnimals.add(animal);
        for (AnimaLaddedListmer listner : mListner){
            listner.onAdding();
        }
    }

    public void setlistner (AnimaLaddedListmer listner){
            mListner.add(listner);
    }

    public void delLisnter (AnimaLaddedListmer listner){
        mListner.remove(listner);
    }

    public interface AnimaLaddedListmer{

        void onAdding();
    }






}
