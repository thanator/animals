package com.tan_ds.animallist;

import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Tan-DS on 5/20/2017.
 */

public class AnimalStorage {

    public AnimalStorage(){
        mAnimals = new ArrayList<>(mOriginalAnimals);
        mListner = new ArrayList<>();

    }

    private List<AnimalClass> mAnimals;
    private static final List<AnimalClass> mOriginalAnimals;
    private final List<animaladdedlistmer> mListner;



    static {
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

        mOriginalAnimals  = Collections.unmodifiableList(animals);
    }


    public List<AnimalClass> returnAnimals(){
        Log.e("AnimStorage", "returnAnimal");
        return new ArrayList<>(mAnimals);
    }

    public void addAnimal(AnimalClass animal){
        Log.e("AnimStorage", "addAnimal");
        mAnimals.add(animal);
        for (animaladdedlistmer listner : mListner){
            listner.onadded();
        }

    }


    public void setlistner (animaladdedlistmer listner){
            mListner.add(listner);
    }

    public void delLisnter (animaladdedlistmer listner){
        mListner.remove(listner);
    }

    public interface animaladdedlistmer{

        void onadded();
    }






}
