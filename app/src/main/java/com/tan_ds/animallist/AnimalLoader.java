package com.tan_ds.animallist;

import android.support.v4.content.AsyncTaskLoader;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import java.util.List;
import java.util.Random;

/**
 * Created by Tan-DS on 5/18/2017.
 */

public class AnimalLoader extends AsyncTaskLoader<List<AnimalClass>> implements AnimalStorage.animaladdedlistmer{

    private final AnimalStorage mAnimalStorage;
    private List<AnimalClass> firstStart;


    public AnimalLoader(Context context, AnimalStorage animalStorage) {
        super(context);
        mAnimalStorage = animalStorage;
        mAnimalStorage.setlistner(this);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        if (takeContentChanged() || firstStart == null) {
            Log.e("will it work?", "onStartLoading-before");
            forceLoad();
        }
    }

    @Override
    public void deliverResult(List<AnimalClass> data) {
        super.deliverResult(data);
        firstStart = data;
    }

    @Override
    protected void onReset() {
        super.onReset();
        mAnimalStorage.delLisnter(this);
    }

    @Override
    public List<AnimalClass> loadInBackground() {

        return  mAnimalStorage.returnAnimals();

        //Random rand = new Random();
        //new AnimalGenerator().provadeAnimal().get(rand.nextInt(10));


    }

    @Override
    public void onadded() {

        Log.e("will it work?", "OnAnimalLoaded");
        onContentChanged();
    }
}
