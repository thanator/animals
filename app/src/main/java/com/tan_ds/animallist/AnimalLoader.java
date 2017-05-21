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

public class AnimalLoader extends AsyncTaskLoader<List<Animal>> implements AnimalStorage.AnimaLaddedListmer{

    private final AnimalStorage mAnimalStorage;
    private List<Animal> mAnimalsCache;


    public AnimalLoader(Context context, AnimalStorage animalStorage) {
        super(context);
        mAnimalStorage = animalStorage;
        mAnimalStorage.setlistner(this);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        if (takeContentChanged() || mAnimalsCache == null) {
            Log.e("will it work?", "onStartLoading-before");
            forceLoad();
        }
    }

    @Override
    public void deliverResult(List<Animal> data) {
        super.deliverResult(data);
        mAnimalsCache = data;
    }

    @Override
    protected void onReset() {
        super.onReset();
        mAnimalStorage.delLisnter(this);
    }

    @Override
    public List<Animal> loadInBackground() {
        return  mAnimalStorage.returnAnimals();
    }

    @Override
    public void onAdding() {
        onContentChanged();
    }
}
